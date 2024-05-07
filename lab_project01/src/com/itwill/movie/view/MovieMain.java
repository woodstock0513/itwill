package com.itwill.movie.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.itwill.movie.controller.MemberDao;
import com.itwill.movie.controller.MovieDao;
import com.itwill.movie.model.Movie;
import com.itwill.movie.view.MovieLogin.notifyLogin;

import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class MovieMain implements notifyLogin{
	
	private static final String[] IMAGES = {
			"images/mov1.jpg",
			"images/mov2.jpg",
			"images/mov3.jpg"
	};

	private static final String[] SEARCH_NAMES = { "로봇 드림", "쿵푸팬더4", "웡카"};
	private static final String[] COLUMN_NAMES = {"영화 이름", "상영시간"};
	
	private MovieDao dao = MovieDao.getInstance();
	private MemberDao memberdao = MemberDao.getInstance();
	
	private JFrame frame;
	private JLabel lblMovie1;
	private JTable table;
	private JLabel lblMovie2;
	private JLabel lblMovie3;
	private JComboBox<String> comboBox;
	private JLabel lblMovInfo;
	private JButton btnRes;
	private JButton btnNext;
	private DefaultTableModel tableModel;
	private JButton btnSelect;
	private String info = "영화를 고르세요.";
	private JButton btnSeeAll;
	private JButton btnLogin;
	private int memno;
	private JButton btnLogout;
	private JLabel lblWelcome;
	private JScrollPane scrollPane;
	
	private ArrayList<LocalDateTime> times = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieMain window = new MovieMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MovieMain() {
		initialize();
		initializeTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();	
		frame.setTitle("☆인기 영화 할인 예매 사이트☆");
		frame.setBounds(700, 200, 459, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblMovie1 = new JLabel(new ImageIcon(IMAGES[0]));
		lblMovie1.setText("");
		lblMovie1.setBounds(36, 64, 104, 128);
		frame.getContentPane().add(lblMovie1);
		
		lblMovie2 = new JLabel(new ImageIcon(IMAGES[1]));
		lblMovie2.setText("");
		lblMovie2.setBounds(167, 64, 104, 128);
		frame.getContentPane().add(lblMovie2);
		
		lblMovie3 = new JLabel(new ImageIcon(IMAGES[2]));
		lblMovie3.setText("");
		lblMovie3.setBounds(307, 64, 104, 128);
		frame.getContentPane().add(lblMovie3);
		
		comboBox = new JComboBox<>();
		final DefaultComboBoxModel<String> comboboxmodel = new DefaultComboBoxModel<>(SEARCH_NAMES);
		comboBox.setModel(comboboxmodel);
		comboBox.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 15));
		comboBox.setBounds(36, 212, 290, 31);
		frame.getContentPane().add(comboBox);
		
		lblMovInfo = new JLabel(info);
		lblMovInfo.setFont(new Font("더잠실 2 Light", Font.PLAIN, 15));
		lblMovInfo.setBounds(36, 253, 264, 46);
		frame.getContentPane().add(lblMovInfo);

		btnNext = new JButton("예매");
		btnNext.addActionListener((e) -> findMovieSeat());
		btnNext.setFont(new Font("더잠실 2 Light", Font.PLAIN, 14));
		btnNext.setBounds(335, 555, 76, 46);
		frame.getContentPane().add(btnNext);
		
		btnRes = new JButton("예약확인");
		btnRes.addActionListener((e) -> checkReservation());
		btnRes.setFont(new Font("더잠실 2 Light", Font.PLAIN, 14));
		btnRes.setBounds(237, 555, 89, 46);
		frame.getContentPane().add(btnRes);
		
		btnSelect = new JButton("확인");
		btnSelect.addActionListener((e)-> {showMovieTimes(); showMovieInfo();});
		btnSelect.setFont(new Font("더잠실 2 Light", Font.PLAIN, 15));
		btnSelect.setBounds(335, 212, 76, 31);
		frame.getContentPane().add(btnSelect);
		
		btnSeeAll = new JButton("전체보기");
		btnSeeAll.addActionListener((e) -> initializeTable());
		btnSeeAll.setFont(new Font("더잠실 2 Light", Font.PLAIN, 14));
		btnSeeAll.setBounds(307, 253, 104, 46);
		frame.getContentPane().add(btnSeeAll);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener((e)-> loginOrNot());
		btnLogin.setFont(new Font("더잠실 2 Light", Font.PLAIN, 14));
		btnLogin.setBounds(29, 555, 89, 46);
		frame.getContentPane().add(btnLogin);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 309, 382, 236);
		frame.getContentPane().add(scrollPane);
		
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		
		table = new JTable(tableModel);

		scrollPane.setViewportView(table);

		table.getTableHeader().setFont(new Font("더잠실 3 Regular", Font.PLAIN, 14));
		table.setFont(new Font("더잠실 2 Light", Font.PLAIN, 16));
		table.setModel(tableModel);
		
		
		
		btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener((e)-> logout());
		btnLogout.setFont(new Font("더잠실 2 Light", Font.PLAIN, 14));
		btnLogout.setBounds(130, 555, 95, 46);
		frame.getContentPane().add(btnLogout);
		
		String text = "";
		if (MovieLogin.MEMBER_NO == 0) {
			text = "";
		} else {
			text = memberdao.findName(MovieLogin.MEMBER_NO)+"님 반갑습니다!";
		}
		lblWelcome = new JLabel(text);
		lblWelcome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWelcome.setFont(new Font("더잠실 2 Light", Font.PLAIN, 14));
		lblWelcome.setBounds(36, 10, 376, 36);
		frame.getContentPane().add(lblWelcome);
		
		UIManager.put("OptionPane.messageFont", new Font("더잠실 3 Regular", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("더잠실 3 Regular", Font.PLAIN, 14));

	}
	
	
	private void logout() {
		if (MovieLogin.MEMBER_NO == 0) {
			JOptionPane.showMessageDialog(frame, "먼저 로그인해주십시오.");
		} else {
			MovieLogin.MEMBER_NO = 0;
			JOptionPane.showMessageDialog(frame, "로그아웃 성공!");
			lblWelcome.setText("");
		}
	}

	private void loginOrNot() {
		if (MovieLogin.MEMBER_NO == 0) {
			MovieLogin.showLogin(this,frame);
		} else {
			JOptionPane.showMessageDialog(frame, "이미 로그인 된 상태입니다.");
		}
	}

	private void checkReservation() {
		//  movie login에서 받은 memno을 이용해 예약 확인
		if (MovieLogin.MEMBER_NO == 0) {
			JOptionPane.showMessageDialog(frame, "비회원은 예약 현황을 볼 수 없습니다.");
		} else {
			MyReservations.showMyReservations(frame);
		}
		
	}

	private void findMovieSeat() {
		// 테이블 어디 눌렀는지 확인 -> 인덱스 가져와서 seat이랑 연동
		int index = table.getSelectedRow();
		if (index==-1) {
			JOptionPane.showMessageDialog(frame, "상영시간을 선택하세요", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		//index로 tnum찾기 -> 영화 제목이랑 시간 비교해서 찾아야할듯
		String mname = (String) table.getValueAt(index, 0);
//		LocalDateTime mdate = (LocalDateTime) table.getValueAt(index, 1);
		LocalDateTime mdate = times.get(index);
		int tnum = dao.findTimeNo(mname, mdate);
		MovieSeat.showMovieSeat(tnum, frame,this);
	}

	private void showMovieInfo() {
		int index = comboBox.getSelectedIndex();
		info = dao.readOneInfo(index);
		lblMovInfo.setText("<html>"+info+"</html>");
		
	}
	
	private void showMovieTimes() {
		// 콤보박스 어디 눌럿는지 확인 -> 그게 무슨 영화인지 확인 -> 그거의 시간표 불러오기
		int index = comboBox.getSelectedIndex();
		List<Movie> result = null;
		switch (index) {
		case 0:
			result = dao.readOneTime(index);
			resetTable(result);
			break;
		case 1:
			result = dao.readOneTime(index);
			resetTable(result);
			break;
		case 2:
			result = dao.readOneTime(index);
			resetTable(result);
			break;		
		}
	}

	private void initializeTable() {
		List<Movie> result = dao.readAllTimes();
		resetTable(result);
		for (Movie m : result) {
			times.add(m.getMovieDate());
		}
	}
	
	private void resetTable(List<Movie> movies) {
		tableModel = new DefaultTableModel(null, COLUMN_NAMES) {
        public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
		for (Movie m : movies) {
			Object[] row = {m.getMovieName(), m.getMovieDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"))};
			tableModel.addRow(row);
		}
		table.setModel(tableModel);
		DefaultTableCellRenderer rdr = new DefaultTableCellRenderer();
		rdr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getTableHeader().getColumnModel().getColumn(0).setCellRenderer(rdr);
		table.getTableHeader().getColumnModel().getColumn(1).setCellRenderer(rdr);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
	}

	@Override
	public void setText() {
		String text = memberdao.findName(MovieLogin.MEMBER_NO);
		String label = String.format("%s님 반갑습니다!", text);
		lblWelcome.setText(label);
	}
}

package com.itwill.movie.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.movie.controller.MovieDao;
import com.itwill.movie.model.Movie;

import java.awt.Font;
import java.time.LocalDateTime;
import java.util.List;

public class MovieMain {
	
	private static final String[] IMAGES = {
			"images/mov1.jpg",
			"images/mov2.jpg",
			"images/mov3.jpg"
	};

	private static final String[] SEARCH_NAMES = { "로봇드림", "쿵푸팬더4", "웡카"};
	private static final String[] COLUMN_NAMES = {"영화 이름", "상영시간"};
	
	private MovieDao dao = MovieDao.getInstance();
	
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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 459, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblMovie1 = new JLabel(new ImageIcon(IMAGES[0]));
		lblMovie1.setText("1");
		lblMovie1.setBounds(37, 10, 104, 128);
		frame.getContentPane().add(lblMovie1);
		
		lblMovie2 = new JLabel(new ImageIcon(IMAGES[1]));
		lblMovie2.setText("2");
		lblMovie2.setBounds(168, 10, 104, 128);
		frame.getContentPane().add(lblMovie2);
		
		lblMovie3 = new JLabel(new ImageIcon(IMAGES[2]));
		lblMovie3.setText("3");
		lblMovie3.setBounds(308, 10, 104, 128);
		frame.getContentPane().add(lblMovie3);
		
		comboBox = new JComboBox<>();
		final DefaultComboBoxModel<String> comboboxmodel = new DefaultComboBoxModel<>(SEARCH_NAMES);
		comboBox.setModel(comboboxmodel);
		comboBox.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 15));
		comboBox.setBounds(37, 158, 290, 31);
		frame.getContentPane().add(comboBox);
		
		lblMovInfo = new JLabel(info);
		lblMovInfo.setFont(new Font("더잠실 2 Light", Font.PLAIN, 15));
		lblMovInfo.setBounds(37, 199, 377, 46);
		frame.getContentPane().add(lblMovInfo);
		
		table = new JTable();
		table.setFont(new Font("더잠실 2 Light", Font.PLAIN, 16));
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(tableModel);
		table.setBounds(37, 268, 375, 212);
		frame.getContentPane().add(table);
		
		btnNext = new JButton("다음");
		btnNext.addActionListener((e) -> findMovieSeat());
		btnNext.setFont(new Font("더잠실 2 Light", Font.PLAIN, 14));
		btnNext.setBounds(323, 501, 89, 46);
		frame.getContentPane().add(btnNext);
		
		btnRes = new JButton("예약확인");
		btnRes.setFont(new Font("더잠실 2 Light", Font.PLAIN, 14));
		btnRes.setBounds(37, 501, 151, 46);
		frame.getContentPane().add(btnRes);
		
		btnSelect = new JButton("확인");
		btnSelect.addActionListener((e)-> {showMovieTimes(); showMovieInfo();});
		btnSelect.setFont(new Font("더잠실 2 Light", Font.PLAIN, 15));
		btnSelect.setBounds(336, 158, 76, 31);
		frame.getContentPane().add(btnSelect);
		
		btnSeeAll = new JButton("전체보기");
		btnSeeAll.addActionListener((e) -> initializeTable());
		btnSeeAll.setFont(new Font("더잠실 2 Light", Font.PLAIN, 14));
		btnSeeAll.setBounds(200, 501, 111, 46);
		frame.getContentPane().add(btnSeeAll);
		
		
		
	}
	
	
	private void findMovieSeat() {
		// TODO 테이블 어디 눌렀는지 확인 -> 인덱스 가져와서 seat이랑 연동
		int index = table.getSelectedRow();
		if (index==-1) {
			JOptionPane.showMessageDialog(frame, "상영시간을 선택하세요", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		//index로 tnum찾기 -> 영화 제목이랑 시간 비교해서 찾아야할듯
		String mname = (String) table.getValueAt(index, 0);
		LocalDateTime mdate = (LocalDateTime) table.getValueAt(index, 1);
		int tnum = dao.findTnum(mname, mdate);
		MovieSeat.showMovieSeat(tnum);
	}

	private void showMovieInfo() {
		int index = comboBox.getSelectedIndex();
		info = dao.readOneInfo(index);
		lblMovInfo.setText("<html>"+info+"</html>");
		
	}
	
	private void showMovieTimes() {
		// TODO 콤보박스 어디 눌럿는지 확인 -> 그게 무슨 영화인지 확인 -> 그거의 시간표 불러오기
		int index = comboBox.getSelectedIndex();
		List<Movie> result = null;
		switch (index) {
		case 0:
			result = dao.readOne(index);
			resetTable(result);
			break;
		case 1:
			result = dao.readOne(index);
			resetTable(result);
			break;
		case 2:
			result = dao.readOne(index);
			resetTable(result);
			break;		
		}
	}

	private void initializeTable() {
		List<Movie> result = dao.read();
		resetTable(result);
		
	}
	
	private void resetTable(List<Movie> movies) {
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		for (Movie m : movies) {
			Object[] row = {m.getMname(), m.getMdate()};
			tableModel.addRow(row);
		}
		table.setModel(tableModel);
	}
	
}

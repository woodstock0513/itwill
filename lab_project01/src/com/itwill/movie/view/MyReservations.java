package com.itwill.movie.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.itwill.movie.controller.MovieDao;
import com.itwill.movie.model.Movie;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;



public class MyReservations extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;

	private MovieDao dao =  MovieDao.getInstance();
	private Component parentComponent;
	
	private static final String[] COLUMN_NAMES = {"영화 이름", "상영시간", "좌석 번호", "예약 시간"};
	private JScrollPane scrollPane;
	private JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
	public static void showMyReservations(Component parentComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyReservations frame = new MyReservations(parentComponent);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyReservations(Component parentComponent) {
		this.parentComponent = parentComponent;
		initialize();
		initializeTable();
	}
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 700;
		int y = 300;
		if (parentComponent != null) {
			x=parentComponent.getX()-50;
			y=parentComponent.getY()+150;
		}
		setBounds(x,y, 553, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("내 예매 현황");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		lblTitle.setBounds(12, 10, 513, 32);
		contentPane.add(lblTitle);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 68, 513, 268);
		contentPane.add(scrollPane);
		
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		table = new JTable(tableModel);
		// 여기 넣어봐야 아무 쓸모 없음
//		table.getColumnModel().getColumn(0).setPreferredWidth(15);
//		table.getColumnModel().getColumn(1).setPreferredWidth(20);
//		table.getColumnModel().getColumn(2).setPreferredWidth(10);
//		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getTableHeader().setFont(new Font("더잠실 3 Regular", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.setFont(new Font("더잠실 2 Light", Font.PLAIN, 14));
		table.setModel(tableModel);
		
		btnCancel = new JButton("예매 취소");
		btnCancel.addActionListener((e) -> cancelReservation());
		btnCancel.setBounds(352, 346, 173, 30);
		contentPane.add(btnCancel);
	}
	
	private void cancelReservation() {
		// TODO 테이블에서 열 선택. 그거 지울거냐고 물어보고 삭제하기 + seat에서 state 바꾸기도 해야함
		int index = table.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(contentPane, "취소할 예매 내역을 선택해주세요.");
			return;
		} else {
			List<Movie> result = dao.findMyReservations(MovieLogin.MEMBER_NO);
			int resNo = result.get(index).getReservationNo();
			int timeNo = dao.findTimeNo(result.get(index).getMovieName(), result.get(index).getMovieDate());
			int seatNo = result.get(index).getSeatNo();
			int seatId = ((timeNo-1) * 5 + seatNo); // 겨우 찾음 아오
			String info = "<html>영화 : "+result.get(index).getMovieName() + "<br> 상영시간 : " 
			+ result.get(index).getMovieDate()+"<html> <br> 선택한 좌석 : "+seatNo+"</html>";
			int choice = JOptionPane.showConfirmDialog(contentPane, 
					info+ "<html> <br> 내역을 취소하시겠습니까? </html>", "확인",
					JOptionPane.OK_CANCEL_OPTION);
			if (choice == JOptionPane.OK_OPTION) {
				dao.deleteReservation(resNo);
				dao.updateStateToOn(seatId); //seatNo가 아니라 Id를 받아야함..
				JOptionPane.showMessageDialog(contentPane, "취소 성공!");
				//resetTable
				initializeTable();	
			}
		}
		
	}

	private void initializeTable() {
		List<Movie> result = dao.findMyReservations(MovieLogin.MEMBER_NO);
		resetTable(result);
		
	}
	private void resetTable(List<Movie> movies) {
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		for (Movie m : movies) {
			Object[] row = {m.getMovieName(), m.getMovieDate(), m.getSeatNo(), m.getReservtime()};
			tableModel.addRow(row);
		}
		table.setModel(tableModel);
		
		DefaultTableCellRenderer rdr = new DefaultTableCellRenderer();
		rdr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getTableHeader().getColumnModel().getColumn(0).setCellRenderer(rdr);
		table.getTableHeader().getColumnModel().getColumn(1).setCellRenderer(rdr);
		table.getTableHeader().getColumnModel().getColumn(2).setCellRenderer(rdr);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		
		
		
	}
	
}

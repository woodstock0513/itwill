package com.itwill.movie.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.movie.controller.MovieDao;
import com.itwill.movie.model.Movie;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;



public class MyReservations extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;

	private MovieDao dao =  MovieDao.getInstance();
	
	private static final String[] COLUMN_NAMES = {"영화 이름", "상영시간", "좌석"};
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void showMyReservations() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyReservations frame = new MyReservations();
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
	public MyReservations() {
		initialize();
		initializeTable();
	}
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 308, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("내 예매 현황");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		lblTitle.setBounds(12, 10, 247, 32);
		contentPane.add(lblTitle);
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 68, 265, 268);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("더잠실 2 Light", Font.PLAIN, 14));
		table.setModel(tableModel);
	}
	
	private void initializeTable() {
		List<Movie> result = dao.findMyReservations(MovieLogin.MEMNO);
		resetTable(result);
		
	}
	private void resetTable(List<Movie> movies) {
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		for (Movie m : movies) {
			Object[] row = {m.getMname(), m.getMdate(), m.getSeatNo()};
			tableModel.addRow(row);
		}
		table.setModel(tableModel);
	}
	
}

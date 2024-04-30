package com.itwill.movie.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.movie.controller.MovieDao;
import com.itwill.movie.model.Movie;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MovieSeat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSeat1;
	private JButton btnSeat2;
	private JButton btnSeat3;
	private JButton btnSeat4;
	private JButton btnSeat5;
	private int timeNum;
	private JLabel lblMovInfo;
	private MovieDao dao = MovieDao.getInstance();

	/**
	 * Launch the application.
	 */
	public static void showMovieSeat(int timeNum) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieSeat frame = new MovieSeat(timeNum);
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
	public MovieSeat(int timeNum) {
		this.timeNum = timeNum;
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 389, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblScreen = new JLabel("Screen");
		lblScreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblScreen.setBounds(12, 87, 348, 21);
		contentPane.add(lblScreen);
		
		lblMovInfo = new JLabel(getInfo(timeNum));
		lblMovInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovInfo.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 15));
		getInfo(timeNum);
		
		lblMovInfo.setBounds(12, 10, 348, 61);
		contentPane.add(lblMovInfo);

		btnSeat1 = new JButton("1");
//		btnSeat1.addActionListener((e)->getInfo(tableIndex));
		btnSeat1.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		btnSeat1.setBounds(12, 118, 60, 40);
		contentPane.add(btnSeat1);
		
		btnSeat2 = new JButton("2");
		btnSeat2.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		btnSeat2.setBounds(84, 118, 60, 40);
		contentPane.add(btnSeat2);
		
		btnSeat3 = new JButton("3");
		btnSeat3.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		btnSeat3.setBounds(156, 118, 60, 40);
		contentPane.add(btnSeat3);
		
		btnSeat4 = new JButton("4");
		btnSeat4.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		btnSeat4.setBounds(228, 118, 60, 40);
		contentPane.add(btnSeat4);
		
		btnSeat5 = new JButton("5");
		btnSeat5.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		btnSeat5.setBounds(300, 118, 60, 40);
		contentPane.add(btnSeat5);

	}
	
	private void selectSeat() {
		// TODO 좌석 상태 바꾸고 메세지 창 띄우기
		
		
		
		
	}
	
	
	
	private String getInfo(int index) {
		//index+1에 해당하는 열의 영화 이름, 영화 시간 알아오기
		Movie movie = dao.readOneNameAndDate(index);
		String result = "<html>선택한 영화 : "+movie.getMname() + "<br> 상영시간 : " + movie.getMdate()+"</html>";
		return result;
	}
	
	

}

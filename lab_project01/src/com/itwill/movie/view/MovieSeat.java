package com.itwill.movie.view;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MovieSeat extends JFrame {
	
	private class Color {
		String state;
		int seatNo;
		
		public Color() {}
		
		public Color(String state, int seatNo) {
			this.state = state;
			this.seatNo = seatNo;
		}
		
		public java.awt.Color setColor(String state, int seatNo) {
			java.awt.Color color;
			if (state.equals("ON")) {
				 color = java.awt.Color.PINK;
			} else { //상태 OFF랑 unknown 포함!!
				color = java.awt.Color.GRAY;
			}
			return color;
		}
		
		
	}
	

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
	private int seatNo;

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
		setBounds(700, 300, 389, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblScreen = new JLabel("Screen");
		lblScreen.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblScreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblScreen.setBounds(12, 81, 348, 27);
		contentPane.add(lblScreen);
		
		lblMovInfo = new JLabel(getInfo(timeNum));
		lblMovInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovInfo.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 15));
		getInfo(timeNum);
		
		lblMovInfo.setBounds(12, 10, 348, 61);
		contentPane.add(lblMovInfo);

		btnSeat1 = new JButton("1"); 
		btnSeat1.setBackground(setSeatColor(btnSeat1));
		btnSeat1.addActionListener((e)-> selectSeat(btnSeat1));
		btnSeat1.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		btnSeat1.setBounds(90, 118, 60, 40);
		contentPane.add(btnSeat1);
		
		btnSeat2 = new JButton("2");
		btnSeat2.setBackground(setSeatColor(btnSeat2));
		btnSeat2.addActionListener((e)-> selectSeat(btnSeat2));
		btnSeat2.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		btnSeat2.setBounds(207, 118, 60, 40);
		contentPane.add(btnSeat2);
		
		btnSeat3 = new JButton("3");
		btnSeat3.setBackground(setSeatColor(btnSeat3));
		btnSeat3.addActionListener((e)-> selectSeat(btnSeat3));
		btnSeat3.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		btnSeat3.setBounds(35, 171, 60, 40);
		contentPane.add(btnSeat3);
		
		btnSeat4 = new JButton("4");
		btnSeat4.setBackground(setSeatColor(btnSeat4));
		btnSeat4.addActionListener((e)-> selectSeat(btnSeat4)); 
		btnSeat4.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		btnSeat4.setBounds(154, 171, 60, 40);
		contentPane.add(btnSeat4);
		
		btnSeat5 = new JButton("5");
		btnSeat5.setBackground(setSeatColor(btnSeat5));
		btnSeat5.addActionListener((e)-> selectSeat(btnSeat5));
		btnSeat5.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		btnSeat5.setBounds(270, 171, 60, 40);
		contentPane.add(btnSeat5);

	}
	
	private java.awt.Color setSeatColor(JButton button) {
		seatNo = Integer.parseInt(button.getText());
		int key = ((timeNum-1) * 5 + seatNo);
		String state = dao.findState(key);
		Color color = new Color();
		java.awt.Color col = color.setColor(state, key);
		return col;
	}
	
	
	
	private void selectSeat(JButton button ) {
		// TODO 좌석 상태 바꾸고 메세지 창 띄우기
		seatNo = Integer.parseInt(button.getText()); //버튼을 아규먼트로 받자!
		int key = ((timeNum-1) * 5 + seatNo); //좌석수 늘리면 * 5를 바꾸면 되긴 하는데 음 테이블을 다시 만들어야하긴 함
		//좌석 상태가 on인지 off인지 확인해야
		String state = dao.findState(key);
		if (state.equals("ON")) {
			String info = getInfo(timeNum);
			int result = JOptionPane.showConfirmDialog(contentPane, info + "<html> <br> 선택한 좌석 : "+seatNo+"</html>", "좌석 확인", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				// 로그인 확인
				int login = MovieLogin.MEMNO;
				if (login == 0) {
					JOptionPane.showMessageDialog(contentPane, "로그인하고 예매하세요.");
					MovieLogin.showLogin();
				} else {
					//예약확정
					int updated = dao.updateStateToOff(key);
					// TODO 예약 테이블에 추가
					int reserv = dao.reservation(MovieLogin.MEMNO, timeNum, seatNo);
					if (updated == 1 && reserv ==1) {
						JOptionPane.showMessageDialog(contentPane, "예매 성공");
						dispose(); 	
					}
				}
			}
			
		} else {
			JOptionPane.showMessageDialog(contentPane, "예매할 수 없는 좌석입니다.", "경고", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	
	private String getInfo(int index) {
		//index+1에 해당하는 열의 영화 이름, 영화 시간 알아오기
		Movie movie = dao.readOneNameAndDate(index);
		String result = "<html>선택한 영화 : "+movie.getMname() + "<br> 상영시간 : " + movie.getMdate()+"</html>";
		return result;
	}
	
	

}

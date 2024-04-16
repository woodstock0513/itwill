package com.itwill.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppMain01 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//JRE에 의해 실행될 쓰레드 등록
		EventQueue.invokeLater(new Runnable() { //익명클래스
			@Override //run 메서드
			public void run() {
				try {
					AppMain01 window = new AppMain01(); //
					window.frame.setVisible(true); //JFrame 객체를 화면에 보여줌
					//                 false 되면 창이 안 뜨고, 프로그램이 그냥 끝남 -> 무조건 true여야!!
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
		frame = new JFrame();
		frame.setBounds(200, 200, 441, 433); //setter
		//		   	(x좌표, y좌표, 가로, 세로)
		
		//JFrame 우상단에 잇는 닫기 버튼(x)의 기능 설정. - 프로그램 종료 (exit이 기능
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblMessage = new JLabel("안녕하세요");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("D2Coding", Font.BOLD, 16));
		frame.getContentPane().add(lblMessage, BorderLayout.CENTER);
	}

}

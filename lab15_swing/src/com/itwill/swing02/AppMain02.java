package com.itwill.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

	private JFrame frame;
	private JTextField textInput;
	private JLabel lblMessage ;
	private JButton btnInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
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
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 426, 264);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);  //absolute layout 
		
		lblMessage = new JLabel("메시지를 입력하세요.");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("D2Coding", Font.PLAIN, 16));
		// contactpane의 좌상단(원점)을 기준으로 46,25만큼 떨어져있음.
		lblMessage.setBounds(35, 10, 342, 50);
		frame.getContentPane().add(lblMessage);
		
		textInput = new JTextField();
		textInput.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textInput.setBounds(35, 70, 342, 114);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		btnInput = new JButton("확인"); //JButton 객체 생성
		//버튼에 ActonListener 이벤트 핸들러를 설정(등록)
		btnInput.addActionListener(new ActionListener() { //액션리스너는 인터페이스이므로 객체 생성 불가 -> 익명클래스 생성
			@Override   //추상 메서드가 하나뿐임. -> 함수형 인터페이스
			//버튼이 클릭되었을 때 할 일 작성.
			//내부 클래스에서는 외부 클래스의 메서드를 사용할 수 있음.!!
			public void actionPerformed(ActionEvent e) {
				handleInputButtonClick();
			}

			
		});
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnInput.setBounds(138, 194, 147, 25);
		frame.getContentPane().add(btnInput);
	}

	private void handleInputButtonClick() { //protected, private 상관이 없음
//		System.out.println("hi");  //버튼 클릭할때마다 hi가 나옴 
		//1. JTextField에 입력된 문자열을 읽음
		String msg = textInput.getText();
		
		//2. (1)에서 읽은 내용을 JLabel에 씀.
		lblMessage.setText(msg);
		
		//3. JTextField를 비움(JTextField에 입력된 내용을 지움).
		textInput.setText(null);
		
	}
}

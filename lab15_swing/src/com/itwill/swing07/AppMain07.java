package com.itwill.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;
	private JButton btnMyFrame;
	
	public void notifyMessage(String msg) {
		btnMyFrame.setText(msg);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 450, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//메세지 다이얼로그 보여주기
//				JOptionPane.showMessageDialog(frame, "hi"); // 맨처음에 뜨는 창을 부모로 하겟다.
				//frame을 null로 주면, 부모컴포넌트가 없어서 화면 기준 정가운데에 뜸.
				//부모컴퍼넌트가 있으면 부모컴퍼넌트의 한가운데에 뜸.
				JOptionPane.showMessageDialog(frame, "hi~", "Message", JOptionPane.PLAIN_MESSAGE);
									//부모 컴퍼넌트, 다이얼로그 메세지, 다이얼로그 타이틀(제목), 메세지 타입
			}
		});
		btnMsgDlg.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnMsgDlg.setBounds(12, 10, 412, 69);
		frame.getContentPane().add(btnMsgDlg);
		
		btnConfirmDlg = new JButton("Confim Dialog");
		btnConfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//confirm(확인) dialog 보여주기
//				int result = JOptionPane.showConfirmDialog(frame, "정말 삭제할까요?");
				int result = JOptionPane.showConfirmDialog(
						frame, 						//부모 컴포넌트
						"정말 삭제하시나요??ㅜㅜ",  // 메세지
						"삭제 확인",				// 타이틀
						JOptionPane.OK_CANCEL_OPTION , //옵션(버튼 종류, 개수)
						JOptionPane.QUESTION_MESSAGE); //메세지 타입
				
				btnConfirmDlg.setText("confirm = "+result);
			}
		});
		btnConfirmDlg.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnConfirmDlg.setBounds(12, 98, 412, 69);
		frame.getContentPane().add(btnConfirmDlg);
		
		btnInputDlg = new JButton("Input Dialog");
		btnInputDlg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] selections = {"instagram","facebook","kakao","x"};
				Object input = JOptionPane.showInputDialog(
						frame, //부모 컴포넌트
						"입력하세요", //메세지
						"입력",   //타이틀
						JOptionPane.PLAIN_MESSAGE, //메세지 타입 - 기본 아이콘
						null, //icon
						selections, //선택할 값들
						selections[2]); //초기 선택값(기본값).
						
				btnInputDlg.setText("입력 : "+input);
			}
		});
		btnInputDlg.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnInputDlg.setBounds(12, 187, 412, 69);
		frame.getContentPane().add(btnInputDlg);
		
		btnCustomDlg = new JButton("Custom Dialog");
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//내가 만든 다이얼로그 보여주기
				MyDialog.showMyDialog(frame);
			}
		});
		btnCustomDlg.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnCustomDlg.setBounds(12, 275, 412, 69);
		frame.getContentPane().add(btnCustomDlg);
		
		btnMyFrame = new JButton("Custom Frame");
		btnMyFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//내가 만든 프레임 보여주기
				MyFrame.showMyFrame(frame,AppMain07.this); //appmain07의 주소값을 넘기는 것.
			}
		});
		btnMyFrame.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnMyFrame.setBounds(111, 354, 221, 37);
		frame.getContentPane().add(btnMyFrame);
	}

}

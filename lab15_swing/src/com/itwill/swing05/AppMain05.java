package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class AppMain05 {

	private JFrame frame;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private String name;
	private String phone;
	private String email;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 405, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 20, 82, 39);
		frame.getContentPane().add(lblName);
		
		textName = new JTextField();
		textName.setBounds(110, 20, 159, 39);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setBounds(12, 83, 82, 39);
		frame.getContentPane().add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(110, 83, 159, 39);
		frame.getContentPane().add(textPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(12, 146, 82, 39);
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(110, 146, 159, 39);
		frame.getContentPane().add(textEmail);
		
		JButton btnInput = new JButton("입력");
		btnInput.addActionListener(new ActionListener() { //익명클래스
			public void actionPerformed(ActionEvent e) {
				name = textName.getText();
				phone = textPhone.getText();
				email = textEmail.getText();
				String contact = String.format("Name : %s, Phone : %s, Email : %s\n", name,phone,email);
//				textArea.setText(contact);  //계속 새로 쓰는거
				textArea.append(contact);   //추가하는거
				//모든 JTextDield에 입력된 내용을 지움
				textName.setText(null);
				textPhone.setText(null);
				textEmail.setText(null);
				//이걸 다 묶어서 그냥 메서드 처리하고 해도 될 듯
			}
		});
		btnInput.setBounds(280, 162, 97, 23);
		frame.getContentPane().add(btnInput);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 218, 333, 123);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea);
	}
}

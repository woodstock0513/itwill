package com.itwill.movie.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.movie.controller.MemberDao;
import com.itwill.movie.controller.MovieDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class MovieLogin extends JFrame {
	
	public static interface notifyLogin{
		public void setText();
	}
	
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPassword;
	private JTextField textFieldId;
	private JButton btnCreate;
	private JButton btnOk;
	private String id;	
	private String password;
	private MemberDao dao = MemberDao.getInstance();
	public static int MEMBER_NO = 0;
	
	private notifyLogin app;
	private Component parentComponent;

	/**
	 * Launch the application.
	 */
	public static void showLogin(notifyLogin app, Component parentComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieLogin frame = new MovieLogin(app, parentComponent);
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
	public MovieLogin(notifyLogin app, Component parentComponent) {
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 700;
		int y = 300;
		if (parentComponent != null) {
			x=parentComponent.getX()+50;
			y=parentComponent.getY()+200;
		}
		setBounds(x, y, 353, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(12, 75, 93, 36);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setFont(new Font("더잠실 2 Light", Font.PLAIN, 15));
		textFieldId.setBounds(127, 75, 196, 36);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblPw = new JLabel("PASSWORD");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblPw.setBounds(12, 137, 93, 36);
		contentPane.add(lblPw);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("더잠실 2 Light", Font.PLAIN, 15));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(127, 137, 196, 36);
		contentPane.add(textFieldPassword);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblLogin.setBounds(51, 10, 238, 55);
		contentPane.add(lblLogin);
		
		btnCreate = new JButton("회원가입");
		btnCreate.addActionListener((e)-> CreateAccount.showCreateAccount(parentComponent));
		btnCreate.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		btnCreate.setBounds(22, 192, 126, 47);
		contentPane.add(btnCreate);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener((e)->checkLogin());
		btnOk.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		btnOk.setBounds(197, 192, 126, 47);
		contentPane.add(btnOk);
	}

	private void checkLogin() {
		// TODO 아디 비번 모두 입력헀는지 & 일치하는 지 확인, 
		// 예약할 때 현재 로그인 된 아이디로 
		id = textFieldId.getText();
		password = textFieldPassword.getText();
		MEMBER_NO = dao.findAccount(id, password);
		if (MEMBER_NO>0) {
			JOptionPane.showMessageDialog(contentPane, "로그인 성공!");
			// TODO main에 memno 넘기기
			app.setText();
			dispose();
		} else {
			JOptionPane.showMessageDialog(contentPane, "id와 password를 올바르게 입력했는지 확인하세요");
		}
		
	}


}

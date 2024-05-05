package com.itwill.movie.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.movie.controller.MemberDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldId;
	private JTextField textFieldPassword;
	private JTextField textFieldBirthdate;
	private JTextField textFieldPhone;
	private JButton btnOk;
	private JButton btnCheckId;
	
	private MemberDao dao = MemberDao.getInstance();
	private int isIdChecked = 0; //0인 경우는 사용 불가
	private String name;
	private String id;
	private String password;
	private String birthdate;
	private String phone;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void showCreateAccount() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		initialize();
	}
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 456, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("회원가입");
		lblTitle.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 415, 41);
		contentPane.add(lblTitle);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblName.setBounds(12, 73, 106, 41);
		contentPane.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		textFieldName.setBounds(130, 73, 297, 41);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblId.setBounds(12, 130, 106, 41);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		textFieldId.setColumns(10);
		textFieldId.setBounds(130, 130, 234, 41);
		contentPane.add(textFieldId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblPassword.setBounds(12, 189, 106, 41);
		contentPane.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(130, 189, 297, 41);
		contentPane.add(textFieldPassword);
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		lblBirthdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthdate.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblBirthdate.setBounds(12, 250, 106, 41);
		contentPane.add(lblBirthdate);
		
		textFieldBirthdate = new JTextField();
		textFieldBirthdate.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		textFieldBirthdate.setColumns(10);
		textFieldBirthdate.setBounds(130, 250, 297, 41);
		contentPane.add(textFieldBirthdate);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblPhone.setBounds(12, 328, 106, 41);
		contentPane.add(lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(130, 328, 297, 41);
		contentPane.add(textFieldPhone);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener((e)-> createAccount());
		btnOk.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		btnOk.setBounds(130, 379, 176, 46);
		contentPane.add(btnOk);
		
		btnCheckId = new JButton("V");
		btnCheckId.addActionListener((e)-> checkMultipleId(textFieldId.getText()));
		btnCheckId.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 14));
		btnCheckId.setBounds(376, 132, 52, 39);
		contentPane.add(btnCheckId);
		
		lblNewLabel = new JLabel("YY/MM/DD");
		lblNewLabel.setFont(new Font("더잠실 2 Light", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 287, 106, 31);
		contentPane.add(lblNewLabel);
	}

	private void createAccount() {
		if (isIdChecked == 0) {
			JOptionPane.showMessageDialog(contentPane, "id 중복 체크를 해야합니다.");
			return;
		}
		birthdate = textFieldBirthdate.getText();
		id = textFieldId.getText();
		name = textFieldName.getText();
		password = textFieldPassword.getText();
		phone = textFieldPhone.getText();
		
		if (birthdate.isBlank() || id.isBlank() || name.isBlank() || password.isBlank()
				|| phone.isBlank()) { // 공란인 정보가 하나라도 있을 때
			JOptionPane.showMessageDialog(contentPane, "모든 정보를 다 입력하세요.");
			return;
		}
		int result = dao.createNewAccount(name, id, password, birthdate, phone);
		if (result == 1) {
			JOptionPane.showMessageDialog(contentPane, "회원 가입에 성공했습니다.");
			dispose();
		}
	}

	private void checkMultipleId(String id) {
		String result = dao.isThereSameId(id);
		if (result.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "사용 가능한 id 입니다.");
			isIdChecked = 1;
		} else {
			JOptionPane.showMessageDialog(contentPane, "사용할 수 없는 id 입니다.");
			isIdChecked = 0;
		}
	} 

}

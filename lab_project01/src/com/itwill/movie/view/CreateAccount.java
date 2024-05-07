package com.itwill.movie.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.movie.controller.MemberDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.sql.SQLDataException;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CreateAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private static String[] COMBO_YEAR = new String[65];
	private static String[] COMBO_MONTH = new String[13];
	private static String[] COMBO_DAY = new String[32];
	

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldId;
	private JTextField textFieldPassword;
//	private JTextField textFieldBirthdate;
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
	
	private Component parentComponent;
	private JComboBox<String> comboBoxDay;
	private JComboBox<String> comboBoxMonth;
	private JComboBox<String> comboBoxYear;

	/**
	 * Launch the application.
	 */
	public static void showCreateAccount(Component parentComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount(parentComponent);
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
	public CreateAccount(Component parentComponent) {
		this.parentComponent = parentComponent;
		initialize();
	}
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 700;
		int y = 300;
		if (parentComponent != null) {
			x=parentComponent.getX();
			y=parentComponent.getY()+150;
		}
		setBounds(x,y, 456, 473);
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
		
//		textFieldBirthdate = new JTextField();
//		textFieldBirthdate.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
//		textFieldBirthdate.setColumns(10);
//		textFieldBirthdate.setBounds(130, 250, 297, 16);
//		contentPane.add(textFieldBirthdate);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblPhone.setBounds(12, 314, 106, 41);
		contentPane.add(lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(130, 314, 297, 41);
		contentPane.add(textFieldPhone);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener((e)-> createAccount());
		btnOk.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		btnOk.setBounds(130, 372, 176, 46);
		contentPane.add(btnOk);
		
		btnCheckId = new JButton("V");
		btnCheckId.addActionListener((e)-> checkMultipleId(textFieldId.getText()));
		btnCheckId.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 14));
		btnCheckId.setBounds(376, 132, 52, 39);
		contentPane.add(btnCheckId);
		
		
		COMBO_DAY[0] = "DD";
		for (int i = 1; i<32; i++) {
			COMBO_DAY[i] = Integer.toString(i);
		}
		COMBO_MONTH[0] = "MM";
		for (int i = 1; i<13; i++) {
			COMBO_MONTH[i] = Integer.toString(i);
		}
		COMBO_YEAR[0] = "YYYY";
		for (int i = 1; i<65; i++) {
			COMBO_YEAR[i] = Integer.toString(i+1959);
		}
	
		comboBoxYear = new JComboBox<>();
		DefaultComboBoxModel<String> yearModel = new DefaultComboBoxModel<>(COMBO_YEAR);
		comboBoxYear.setModel(yearModel);
		comboBoxYear.setBounds(130, 250, 95, 41);
		comboBoxYear.setFont(new Font("더잠실 2 Light", Font.PLAIN, 15));
		contentPane.add(comboBoxYear);
		
		comboBoxMonth = new JComboBox<>();
		DefaultComboBoxModel<String> monthModel = new DefaultComboBoxModel<>(COMBO_MONTH);
		comboBoxMonth.setModel(monthModel);
		comboBoxMonth.setBounds(237, 250, 89, 41);
		comboBoxMonth.setFont(new Font("더잠실 2 Light", Font.PLAIN, 15));
		contentPane.add(comboBoxMonth);
		
		comboBoxDay = new JComboBox<>();
		DefaultComboBoxModel<String> dayModel = new DefaultComboBoxModel<>(COMBO_DAY);
		comboBoxDay.setModel(dayModel);
		comboBoxDay.setBounds(338, 250, 89, 41);
		comboBoxDay.setFont(new Font("더잠실 2 Light", Font.PLAIN, 15));
		contentPane.add(comboBoxDay);
		
		UIManager.put("OptionPane.messageFont", new Font("더잠실 3 Regular", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("더잠실 3 Regular", Font.PLAIN, 14));
	}

	private void createAccount() {
		if (isIdChecked == 0) {
			JOptionPane.showMessageDialog(contentPane, "id 중복 체크를 해야합니다.");
			return;
		}
		
		if (comboBoxYear.getSelectedIndex()==0 || comboBoxMonth.getSelectedIndex()==0 || comboBoxDay.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(contentPane, "생년월일을 모두 선택하세요.");
			return;
		}
		int year = comboBoxYear.getSelectedIndex() +1960;
		int month = comboBoxMonth.getSelectedIndex() + 1;
		int day = comboBoxDay.getSelectedIndex()+1;
		birthdate = String.format("%d%02d%02d", year, month, day);
		id = textFieldId.getText();
		name = textFieldName.getText();
		password = textFieldPassword.getText();
		phone = textFieldPhone.getText();
		if (id.isBlank() || name.isBlank() || password.isBlank()
				|| phone.isBlank()) { // 공란인 정보가 하나라도 있을 때
			JOptionPane.showMessageDialog(contentPane, "모든 정보를 다 입력하세요.");
			return;
		}
		if (!checkNumberOrEnglish(password)) {
			JOptionPane.showMessageDialog(contentPane, "password는 영어로 입력해 주세요");
			return;
		}
		if (!isNumberic(birthdate)) { // 생일이 숫자인지 체크
			JOptionPane.showMessageDialog(contentPane, "생일은 숫자로만 입력하세요.");
			return;
		}
		String phonePattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
		if (!Pattern.matches(phonePattern, phone)) { //전번이 숫자인지 체크
			JOptionPane.showMessageDialog(contentPane, "전화번호는 010-0000-0000 형식으로 입력하세요.");
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
		if (checkNumberOrEnglish(id)) {
			if (result.equals("")) {
				JOptionPane.showMessageDialog(contentPane, "사용 가능한 id 입니다.");
				isIdChecked = 1;
			} else {
				JOptionPane.showMessageDialog(contentPane, "사용할 수 없는 id 입니다.");
				isIdChecked = 0;
			}
		} else {
			JOptionPane.showMessageDialog(contentPane, "id는 영어로 입력해 주세요");
		}
	} 
	
	//인터넷 참고
	private boolean checkNumberOrEnglish(String id) {
		boolean result = true;
		char idChar;
		for (int i = 0; i < id.length(); i++) { 
			idChar = id.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크
			if (idChar >= 0x61 && idChar <= 0x7A) {// 영문(소문자) OK!
		
			} else if (idChar >=0x41 && idChar <= 0x5A) {// 영문(대문자) OK!
		
			} else if (idChar >= 0x30 && idChar <= 0x39) {
				// 숫자 OK!
			} else {
				result = false;// 영문자도 아니고 숫자도 아님!
			}
			
		}
		return result;
	}


    public static boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
      }
}

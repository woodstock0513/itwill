package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ContactCreateFrame extends JFrame {
	//static 생략 가능
	public static interface CreateNotify{
		public void notifyContactCreated();
	}
	
	private CreateNotify app; //여기서 생성하면 안됨. 
	//(생성자는 호출할때마다 새로운 객체 만듦. 새로운 객체 말고 이미 만들어진 객체 main이 필요한거)
	//연락처 저장을 성공했을 때 저장 성공 사실을 알려줄 객체. app
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPanel;
	private JButton btnSave;
	private JButton btnCancel;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JPanel buttonPanel;
	
	private Component parentComponent; //CreateFrame의 부모 컴포넌트를 저장하기 위해
	
	private ContactDao dao = ContactDaoImpl.getInstance(); //두번째 호출이므로 바로 주소 리턴
	//싱글턴!!! 주소값이 같음!!!

	/**
	 * Launch the application.
	 */
	public static void showContactCreateFrame(Component pc, CreateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(pc, app);
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
	
	
	public ContactCreateFrame(Component pc, CreateNotify app) {
		this.parentComponent = pc;
		this.app = app;
		initialize();
	}
	
	
	public void initialize() {
		setTitle("새 연락처 저장");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x= 700;
		int y = 300;
		if (parentComponent != null) {
			//부모 컴퍼넌트와 같은 좌표(x,y)에 위치시킨다.
			x=parentComponent.getX();
			y=parentComponent.getY();
		} 
		setBounds(x, y, 360, 270);
		if (parentComponent == null) {
			//부모컴퍼넌트가 없으면 화면 중앙에 위치시킴
			setLocationRelativeTo(null);
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPanel = new JPanel();
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setEnabled(true);
		lblName.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblName.setBounds(12, 21, 76, 41);
		contentPanel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		textName.setBounds(100, 21, 211, 41);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblPhone.setEnabled(true);
		lblPhone.setBounds(12, 76, 76, 41);
		contentPanel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		textPhone.setColumns(10);
		textPhone.setBounds(100, 76, 211, 41);
		contentPanel.add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblEmail.setEnabled(true);
		lblEmail.setBounds(12, 127, 76, 41);
		contentPanel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		textEmail.setColumns(10);
		textEmail.setBounds(100, 127, 211, 41);
		contentPanel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener((e)->saveContact());
		btnSave.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		buttonPanel.add(btnSave);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener((e)-> dispose()); //JFrame이 가지고 있는 메서드 호출. 현재 창만 닫음
		btnCancel.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		buttonPanel.add(btnCancel);
	}

	private void saveContact() {
		//1. JTextField에서 저장할 이름, 전화번호, 이메일을 읽음
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		//2. Contact 타입 객체 생성
		Contact con = new Contact(0, name, phone, email);
		
		//3. DAO를 이용해 파일에 저장
		int result = dao.create(con);
		if (result == 1) { //연락처 저장 성공
			//dispose 먼저 쓴 이유. 실행했을 때 이게 더 깔끔해서 
			dispose(); //현재창 닫기
			
			//contactmain에게 연락처 저장이 성공했음을 알림
			app.notifyContactCreated(); //app에 contactmain의 주소가 있으면 좋겟음..
//			JOptionPane.showMessageDialog(parentComponent, "저장 성공", "성공", JOptionPane.PLAIN_MESSAGE);
			
			
		}else { //연락처 저장 실패
			//사용자에게 저장 실패 메세지 보여주기
			JOptionPane.showMessageDialog(parentComponent,"저장 실패", "경고", JOptionPane.WARNING_MESSAGE);
		}
		
	}
}

package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;
import com.itwill.ver05.view.ContactCreateFrame.CreateNotify;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
	
	public interface UpdateNotify{
		void notifyContactUpdated();
	}

	private UpdateNotify app;
	
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
	
	private ContactDao dao = ContactDaoImpl.getInstance();
	private int index; //업데이트할 연락처의 인덱스 저장하기 위해서 (굳이 초기화할 필요 없음)
	private Component parentComponent; // 부모컴포넌트를 저장하기 위해서ㅏ 

	/**
	 * Launch the application.
	 */
	public static void showContactUpdateFrame(Component pc,int index, UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(pc, index, app);
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
	public ContactUpdateFrame(Component pc,int index, UpdateNotify app) {
		this.index = index;
		this.parentComponent = pc;
		this.app = app;
		initialize();
		initializeTextField();
	}
	
	private void initializeTextField() { 
		// 3개의 텍스트 필드에 해당 인덱스의 연락처 정보를 채움
		// (내가 만든 updateContact랑 같은 거인듯. 아닌가..?)
		//근데이건수정후꺼를 보여주는거아닌가
		Contact contact = dao.read(index);
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
		
	}
	
	public void initialize() {
		setTitle("연락처 수정");
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
		textName.setText(dao.read(index).getName());
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
		textPhone.setText(dao.read(index).getPhone());
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
		textEmail.setText(dao.read(index).getEmail());
		contentPanel.add(textEmail);
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener((e) -> updateContact());
		btnSave.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		buttonPanel.add(btnSave);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener((e)->dispose());
		btnCancel.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		buttonPanel.add(btnCancel);
	}

	private void updateContact() {
		//업데이트할 내용을 읽음
		
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		//2. Contact 타입 객체 생성
		Contact con = new Contact(0, name, phone, email);
		
		//3. DAO를 이용해 파일에 저장
		int result = dao.update(index, con);
		if (result==1) {
			// 현재창 닫기
			dispose();
			
			//메인 쓰레드에게 업데이트 성공을 알려줌 -> main의 주소를 알아야함
			app.notifyContactUpdated();
		} else {
			//실패 알림
		}
		
		
	}
}

package com.itwill.swing07;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MyFrame extends JFrame {
	
	public interface Notifiable{
		public void notifyMessage(String msg);
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnButton;
	private JTextField textField;
	
	private Component parentComponent; //부모 컴포넌트를 저장하기 위한 필드
//	private AppMain07 app; //메인 쓰레드 주소
	private Notifiable app; //notifyMessage(String msg) 메서드를 갖는 객체의 주소를 저장.
	
	/**
	 * Launch the application.
	 * @param app 
	 */
	public static void showMyFrame(Component parentComponent, Notifiable app) {
		//Component
		//|__JFrame, JDialog
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame(parentComponent,app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MyFrame(Component parentComponent, Notifiable app) {
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();
	}
	
	/**
	 * Create the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			int x=700;
			int y=300;
			if (parentComponent != null) {
				x = parentComponent.getX(); //부모 컴포넌트의 x 좌표 
				y = parentComponent.getY();   //부모 컴포넌트의 y 좌표
			}
			setBounds(x,y, 450, 300);
			
			if (parentComponent == null) { //부모 컴포넌트 정보가 없을 때, 화면 중앙에 띄우겟다.
				setLocationRelativeTo(null);
			}
	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MyFrame");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(23, 34, 79, 73);
		contentPane.add(lblNewLabel);
		
		btnButton = new JButton("확인");
		btnButton.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JTextField의 내용을 읽음.
				String msg = textField.getText();
				
				//main클래스.메서드(msg)를 하면 메인에 읽은 값을 저장할 수 있지 않을까?
				//-> main에 가서 하나 만들기~ public으로!
				
				app.notifyMessage(msg);
				
			}
		});
		btnButton.setBounds(61, 149, 308, 50);
		contentPane.add(btnButton);
		
		textField = new JTextField();
		textField.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textField.setBounds(114, 30, 289, 81);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

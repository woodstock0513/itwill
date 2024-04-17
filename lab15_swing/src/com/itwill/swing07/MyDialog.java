package com.itwill.swing07;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JPanel buttonPanel;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	// 부모 컴포넌트를 저장하기 위한 필드
	private Component parentComponent;

	/**
	 * Launch the application.
	 */
	public static void showMyDialog(Component parentComponent) {
		try {
			MyDialog dialog = new MyDialog(parentComponent);
			// dialog.parentComponent = parentComponent;는 안됨. 위의 코드가 끝나고 들어가는건데,
			// 위의 코드에 이미 initialize가 있고, initialize안에서 사용되는 값이기 때문에
			// initialize 전에 무조건!!!!!! parentcomponent를 저장해야함.

//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); //dispose->내 창만 닫겟다 전체 종료 X(exit)
			dialog.setVisible(true); // true여야 화면에 보여지는 것. JFrame이랑 똑가틈
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param parentComponent
	 */
	public MyDialog(Component parentComponent) {
		this.parentComponent = parentComponent;
		initialize();
	}
	// 생성자를 간단하게 쓰기 위해 바꾼 것.

	private void initialize() {
		// 상속받음. AppMain은 상속받은게 아니라서 ㅇㅇ.set~을 함.
		// dialog의 좌표와 크기 설정
		setBounds(700, 300, 502, 431);
		// setBounds에 (x,y)좌표를 무시하고 항상 스크린의 가운데에 띄울 수도 있음
		// setLocationRelativeTo(null);

		// setBounds에 (x,y)좌표를 무시하고 항상 부모 컴포넌트의 가운데에 위치
		setLocationRelativeTo(parentComponent);

		// 다이얼로그의 닫기 버튼(x)의 기본 동작을 설정
//		DISPOSE_ON_CLOSE : 현재 다이얼로그만 닫고, 메인 프로세스는 계속 실행
//		EXIT_ON_CLOSE : 현재 다이얼로그와 함께 메인 프로세스까지 종료 -> 기능 사라짐 ㄷㄷ
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 여기서 설정해도 괜찮음

		// getContentPane() : content영역 & button 영역
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(32, 35, 83, 37);
		contentPanel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(127, 35, 213, 37);
		contentPanel.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(352, 35, 97, 37);
		contentPanel.add(btnNewButton);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("D2Coding", Font.PLAIN, 16));
		cancelButton.setActionCommand("Cancel");
		buttonPanel.add(cancelButton);

		okButton = new JButton("OK");
		okButton.setFont(new Font("D2Coding", Font.PLAIN, 16));
		okButton.setActionCommand("OK");
		buttonPanel.add(okButton);
		getRootPane().setDefaultButton(okButton);

	}
}

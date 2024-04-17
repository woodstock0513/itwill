package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbStatic;
	private JCheckBox cbFinal;
	private JCheckBox cbAbstract;
	private JComboBox<String> comboBox;
	private JButton btnInfo;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(700, 300, 432, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rbPrivate = new JRadioButton("Private");
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e); //어떤 버튼인지 알아야하니까
			}
		});
		buttonGroup.add(rbPrivate);
		rbPrivate.setBounds(22, 20, 83, 28);
		frame.getContentPane().add(rbPrivate);
		
		rbPackage = new JRadioButton("Package");
		rbPackage.setSelected(true);
		rbPackage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPackage); //버튼 그룹에 라디오 버튼 추가!
		rbPackage.setBounds(109, 20, 83, 28);
		frame.getContentPane().add(rbPackage);
		
		rbProtected = new JRadioButton("Protected");
		rbProtected.addActionListener((e)->handleRadioButtonClick(e));
		buttonGroup.add(rbProtected);
		rbProtected.setBounds(215, 20, 83, 28);
		frame.getContentPane().add(rbProtected);
		
		rbPublic = new JRadioButton("Public");
		rbPublic.addActionListener(this::handleRadioButtonClick);
		buttonGroup.add(rbPublic);
		rbPublic.setBounds(320, 20, 83, 28);
		frame.getContentPane().add(rbPublic);
		
		cbAbstract = new JCheckBox("Abstract");
		cbAbstract.setFont(new Font("굴림", Font.PLAIN, 16));
		cbAbstract.setBounds(22, 81, 100, 42);
		cbAbstract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
				
			}
		});
		frame.getContentPane().add(cbAbstract);
		
		cbFinal = new JCheckBox("Final");
		cbFinal.addActionListener((e)->handleCheckBoxClick(e));
		cbFinal.setFont(new Font("굴림", Font.PLAIN, 16));
		cbFinal.setBounds(145, 81, 76, 42);
		frame.getContentPane().add(cbFinal);
		
		cbStatic = new JCheckBox("Static");
		cbStatic.addActionListener(this::handleCheckBoxClick);
		cbStatic.setFont(new Font("굴림", Font.PLAIN, 16));
		cbStatic.setBounds(233, 81, 100, 42);
		frame.getContentPane().add(cbStatic);
		
		comboBox = new JComboBox<>(); //new JComboBox<String>(); 으로 써도 됨
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleComboBoxClick(e);
			}
		});
		comboBox.setFont(new Font("굴림", Font.PLAIN, 16));
		final String[] emails = {"naver.com", "gmail.com", "daum.net", "kakao.com"};
		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(emails);
		comboBox.setModel(model);
		//디폴트콤보박스모델의 아규먼트 - 문자열 배열
		comboBox.setBounds(22, 129, 245, 35);
		frame.getContentPane().add(comboBox);
		
		btnInfo = new JButton("확인");
		btnInfo.addActionListener((ActionEvent e) -> { //ActionEvent는 생략해도 됨
			handleButtonClick();
		});
		btnInfo.setBounds(279, 129, 112, 35);
		frame.getContentPane().add(btnInfo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 196, 369, 198);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea);
	}

	private void handleButtonClick() {
		// JTextArea 출력할 문자열들을 append 하기 위한 문자열 버퍼
		StringBuffer buffer = new StringBuffer(); //문자열들을 덧붙여나갈 버퍼
		// 어떤 라디오 버튼이 선택되었는지
		if(rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText());
		}else if (rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		}else if (rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		}else if (rbPublic.isSelected()) {
			buffer.append(rbPublic.getText());
		}
		buffer.append(" 라디오 버튼 선택됨.\n");
		
		// 어떤 체크 박스들이 선택되었는지
		if (cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText()).append(" ");
		}
		if(cbFinal.isSelected()) {
			buffer.append(cbFinal.getText()).append(" ");
		}
		if (cbStatic.isSelected()) {
			buffer.append(cbStatic.getText()).append(" ");
		}
		buffer.append("체크 박스 선택됨.\n");
		
		// 콤보박스에서 선택된 아이템
		Object selectedItem = comboBox.getSelectedItem();
		buffer.append(selectedItem).append(" 콤보박스 아이템 선택됨.");
				
		textArea.setText(buffer.toString());
	}

	private void handleComboBoxClick(ActionEvent e) {
		@SuppressWarnings("unchecked")
		JComboBox<String> cb = (JComboBox<String>) e.getSource(); //이벤트가 발생한 컴퍼넌트(JCombiBox)찾기
		String item = (String) cb.getSelectedItem(); //콤보박스에서 선택된 아이템 찾기
		int index= cb.getSelectedIndex();     //콤보박스에서 선택된 인덱스
		textArea.setText(index +" : "+ item);
	}

	private void handleCheckBoxClick(ActionEvent e) {
		JCheckBox cb = (JCheckBox) e.getSource();  //3개의 체크박스 중에서 누가 클릭됐는지
		String text = cb.getText();
		boolean selected = cb.isSelected();
		textArea.setText(text+ " : " +selected);
	}

	private void handleRadioButtonClick(ActionEvent e) {
		JRadioButton rb = (JRadioButton) e.getSource(); //4개의 라디오 버튼 중 누가 클릭 됐는지 찾기 위해
		String text = rb.getText(); //이벤트가 발생한 라디오 버튼의 텍스트
		boolean selected = rb.isSelected();  //이벤트가 발생한 라디오 버튼의 선택여부
		textArea.setText(text+ " : " +selected);
	}


}

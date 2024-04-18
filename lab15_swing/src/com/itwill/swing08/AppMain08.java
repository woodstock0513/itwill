package com.itwill.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {
	
	private static final String[] COLUMN_NAMES = {"국어", "수학", "영어", "총점", "평균"};

	private JFrame frame;
	private JTextField textKorean;
	private JLabel lblKorean;
	private JTextField textMath;
	private JTextField textEnglish;
	private JButton btnEnter;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblMath;
	private JLabel lbEnglish;
	
	private DefaultTableModel model;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain08 window = new AppMain08();
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
	public AppMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblKorean = new JLabel("국어");
		lblKorean.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 20));
		lblKorean.setHorizontalAlignment(SwingConstants.CENTER);
		lblKorean.setBounds(24, 23, 120, 50);
		frame.getContentPane().add(lblKorean);
		
		textKorean = new JTextField();
		textKorean.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 20));
		textKorean.setBounds(159, 23, 250, 50);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		lblMath = new JLabel("수학");
		lblMath.setHorizontalAlignment(SwingConstants.CENTER);
		lblMath.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 20));
		lblMath.setBounds(24, 88, 120, 50);
		frame.getContentPane().add(lblMath);
		
		textMath = new JTextField();
		textMath.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 20));
		textMath.setColumns(10);
		textMath.setBounds(159, 88, 250, 50);
		frame.getContentPane().add(textMath);
		
		lbEnglish = new JLabel("영어");
		lbEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		lbEnglish.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 20));
		lbEnglish.setBounds(24, 152, 120, 50);
		frame.getContentPane().add(lbEnglish);
		
		textEnglish = new JTextField();
		textEnglish.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 20));
		textEnglish.setColumns(10);
		textEnglish.setBounds(159, 152, 250, 50);
		frame.getContentPane().add(textEnglish);
		
		btnEnter = new JButton("입력");
		btnEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputScoreToTable();
			}
		});
		btnEnter.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 20));
		btnEnter.setBounds(24, 212, 181, 50);
		frame.getContentPane().add(btnEnter);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 272, 385, 226);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);//컬럼 이름
			
		table.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteScoreFromTable();
			}
		});
		btnDelete.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 20));
		btnDelete.setBounds(228, 212, 181, 50);
		frame.getContentPane().add(btnDelete);
	}

	private void deleteScoreFromTable() {
		// JTable에서 선택된 행의 인덱스를 찾음.
		int index = table.getSelectedRow();
		if (index==-1) { //선택된 행이 없음
			JOptionPane.showMessageDialog(frame, "삭제할 행을 선택하세요!!", "경고", JOptionPane.WARNING_MESSAGE);
			return; //메서드 끝내기
		}
		int result = JOptionPane.showConfirmDialog(frame, "정말 삭제할까요?", "확인", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			model.removeRow(index); //해당 인덱스의 행(row)을 삭제
		}
	}

	private void inputScoreToTable() {
		// 1. JTextField에서 세 과목의 점수를 읽음
		int korean = 0;
		int english = 0;
		int math = 0;
	 
		try {
			korean = Integer.parseInt(textKorean.getText());
			english = Integer.parseInt(textEnglish.getText());
			math = Integer.parseInt(textMath.getText());
		} catch (NumberFormatException e) {
			// todo 메세지 다이얼로그 띄우기
			JOptionPane.showMessageDialog(frame, "숫자로 입력하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
			
			clearAllFields();
			return; //inputScoreToTable 메서드 종료 -> 4.가 실행이 안됨.
		}
		// 2. 읽은 점수를 Score 타입 객체에 저장.
		Score score = new Score(korean, english, math);
		
		// 3. JTable에 행(row)추가
		Object[] row = {
				score.getKorean(), score.getMath(), score.getEnglish(), score.getTotal(), score.getMean()
		};
		model.addRow(row);
		
		
		// 4. JTextField의 내용을 모두 지운다.
		clearAllFields();
		
	}
	
	private void clearAllFields() {
		textEnglish.setText(null);
		textKorean.setText(null);
		textMath.setText(null);
	}
}

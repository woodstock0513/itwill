package com.itwill.swing03;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain03 {
	
	private static final String[] IMAGES = {
			"images/image1.jpg",
			"images/image2.jpg",
			"images/image3.jpg",
			"images/image4.jpg",
			"images/image5.jpg"
	};

	private int curIndex=0;
	private JFrame frame;
	private JLabel lblImage;
	private JButton btnNext;
	private JButton btnPrev;
	private JLabel lblImageName;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain03 window = new AppMain03();
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
	public AppMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600,400, 511, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblImage = new JLabel(new ImageIcon(IMAGES[curIndex])); //절대경로로 써도 됨 
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblImage.setBounds(46, 10, 400, 400);
		frame.getContentPane().add(lblImage);
		
		btnPrev = new JButton("<");
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showPrevImage();
			}
		});
		btnPrev.setFont(new Font("D2Coding", Font.BOLD, 22));
		btnPrev.setBounds(63, 434, 106, 52);
		frame.getContentPane().add(btnPrev);
		
		btnNext = new JButton(">");
		btnNext.addActionListener((e)->showNextImage()); //람다 표현식 이용
		// 다음 이미지 보여주기
		btnNext.setFont(new Font("D2Coding", Font.BOLD, 22));
		btnNext.setBounds(314, 434, 106, 52);
		frame.getContentPane().add(btnNext);
		
		lblImageName = new JLabel(IMAGES[curIndex]);
		lblImageName.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageName.setBounds(181, 455, 121, 15);
		frame.getContentPane().add(lblImageName);
	}

	private void showNextImage() {
		if (curIndex < IMAGES.length - 1) { // 현재 인덱스가 마지막 인덱스보다 작으면 = 마지막 이미지가 아닌 경우
			curIndex++;
		} else { //현재 인덱스가 배열의 마지막 인덱스이면
			curIndex =0;
		}
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
		lblImageName.setText(IMAGES[curIndex]);
	}

	private void showPrevImage() {
		if(curIndex>0) { //현재 이미지의 인덱스가 0보다 크면 
			curIndex--; //인덱스를 1 감소
		} else { //현재 이미지의 인덱스가 0인 경우( 첫번째 이미지인 경우)
			curIndex=IMAGES.length - 1; //배열의 마지막 인덱스로 바꾼다
		}
		//JLabel의 이미지 아이콘을 이전 아이콘으로 변경
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
		lblImageName.setText(IMAGES[curIndex]);
	}

}

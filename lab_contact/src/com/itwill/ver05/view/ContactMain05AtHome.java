package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;
import com.itwill.ver05.view.ContactCreateFrame.CreateNotify;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactMain05 implements CreateNotify {

	private static final String[] COLUNM_NAMES = {"이름", "전화번호"};  // static final 필수
	
	private ContactDao dao = ContactDaoImpl.getInstance(); //싱글턴
	// 처음 생성된 impl의 주소 저장
	private JFrame frame;
	private JPanel buttonPanel;
	private JButton btnCreate;
	private JButton btnUpdate;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	
	private DefaultTableModel model;
	private JButton btnSearch;
	private JButton btnDelete;
	private List<Integer> indexes ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain05 window = new ContactMain05();
					//생성자 호출( initialize,load~~까지 실행완) 하고 나면 이제 frame을 보여준다.
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
	public ContactMain05() {
		//intialize 전에 필드 변수들 내용들이 실행됨 (=으로 저장하는 애들)
		//위의 싱글턴 구문이 먼저 실행되는 것(생성자 호출 등등) 그 이후에 initialize 실행
		initialize(); //UI 컴포넌트들을 초기화
		loadContactData(); //ContactDao를 사용해서 파일에 저장된 연락처 데이터들 불러오기
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 561, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("연락처 v0.5");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		
		btnCreate = new JButton("연락처 추가");
		btnCreate.addActionListener((e) ->	ContactCreateFrame.showContactCreateFrame(frame,this)); //람다
		btnCreate.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		buttonPanel.add(btnCreate);
		
		btnUpdate = new JButton("연락처 수정");
		btnUpdate.addActionListener((e) -> updateContact());
		btnUpdate.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		buttonPanel.add(btnUpdate);
		
		btnSearch = new JButton("연락처 검색");
		btnSearch.addActionListener((e)->searchContact(frame));
		btnSearch.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		buttonPanel.add(btnSearch);
		
		btnDelete = new JButton("연락처 삭제");
		btnDelete.addActionListener((e) -> deleteContact());
		btnDelete.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		buttonPanel.add(btnDelete);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 21, 490, 312);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 12));
		model = new DefaultTableModel(null, COLUNM_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
	
	private void searchContact(JFrame frame) {
		ContactSearchFrame.showContactSearchFrame(frame);

		
	}

	private void updateContact() {
		int index = table.getSelectedRow();
		//수정할래말래 무러보기
		if (index == -1) {
			JOptionPane.showMessageDialog(frame, "수정할 연락처를 선택하세요");
			return;
		}
		ContactUpdateFrame.showContactUpdateFrame(frame, index);
		resetTable(); //도대체 왜 안되는거야.....
	}

	private void deleteContact() {
		int index = table.getSelectedRow();
		if (index == -1) { //선택이 안되어있을 때
			JOptionPane.showMessageDialog(frame, "삭제할 연락처를 선택하세요", "경고", JOptionPane.WARNING_MESSAGE);
			return; //메서드 종료
		}
		
		int confirm = JOptionPane.showConfirmDialog(frame, "선택한 연락처를 삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		
		if (confirm == JOptionPane.YES_OPTION) {
			//dao를 사용해서 선택된 연락처를 삭제하고 파일에 저장
			int result = dao.delete(index);
			
			if (result ==1) {
				//삭제 성공 알림
				JOptionPane.showMessageDialog(frame, "삭제 성공");
				
				//테이블 새로 그리기
				resetTable();
				
				//해당 행만 지우기
				//model.removeRow(index);
				
			}else {
				//삭제 실패 알림
				JOptionPane.showMessageDialog(frame,"삭제 실패", "경고", JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	
	private void loadContactData() {
		//dao를 사용해서 파일에 저장된 데이터를 읽어옴
		List<Contact> list = dao.read();
		
		//list의 연락처들을 테이블에 행으로 추가
		for (Contact c : list) {
			Object[] row = {c.getName(),c.getPhone()};
			model.addRow(row);
		}
	}

	@Override //CreateNotify의 인터페이스 재정의
	public void notifyContactCreated() {
		resetTable(); //table을 처음부터 다시 그림
		//사용자에게 알림
		JOptionPane.showMessageDialog(frame, "새 연락처 저장 성공");
	}
	
	
	private void resetTable() {
		//테이블 데이터 다시 로딩하기
		model = new DefaultTableModel(null, COLUNM_NAMES);
		loadContactData();
		//새 연락처가 추가된 data를 로딩
		table.setModel(model);
	}
}

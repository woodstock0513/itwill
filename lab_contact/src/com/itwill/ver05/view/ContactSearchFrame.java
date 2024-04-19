package com.itwill.ver05.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ContactSearchFrame extends JFrame {

	private static final String[] COLUMN_NAMES = { "이름", "전화번호", "이메일"};
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Component parentComponent;
	private JTextField textField;
	private JTable table;
	private JButton btnSearch;
	
	private DefaultTableModel model ;
	private ContactDao dao = ContactDaoImpl.getInstance();  //싱글턴 가져오기

	/**
	 * Launch the application.
	 */
	public static void showContactSearchFrame(Component parentComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactSearchFrame frame = new ContactSearchFrame(parentComponent);
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
	public ContactSearchFrame(Component parentComponent) {
		this.parentComponent = parentComponent;
		initialize();
	}
	
	public void initialize() {
		setTitle("연락처 검색");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 700;
		int y = 300;
		if (parentComponent != null) {
			x=parentComponent.getX();
			y=parentComponent.getY();	
		}
		setBounds(x, y, 374, 349);
		if (parentComponent == null) {
			setLocationRelativeTo(null);
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		contentPane.add(headerPanel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		headerPanel.add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener((e)->searchByKeyword());
		btnSearch.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		headerPanel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		//테이블 컬럼 이름의 폰트 설정
		table.getTableHeader().setFont(new Font("더잠실 3 Regular", Font.PLAIN, 15));
		
		// 테이블의 폰트 설정
		table.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 15));
		
		//테이블의 행 높이 설정
		table.setRowHeight(20);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

	private void searchByKeyword() {
		String keyword = textField.getText();
		List<Contact> list = dao.search(keyword);
		
		//비어있는 모델 다시 만들기
		model = new DefaultTableModel(null,COLUMN_NAMES);
		
		//결과를 데이틀에 쓰기
		for (Contact c : list) {
			Object row[] = {c.getName(), c.getPhone(), c.getEmail()};
			model.addRow(row);
		}
		//테이블에 테이블 모델을 다시 세팅
		table.setModel(model);

	}
}

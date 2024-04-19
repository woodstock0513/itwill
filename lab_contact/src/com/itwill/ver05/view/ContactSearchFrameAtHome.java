package com.itwill.ver05.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ContactSearchFrameAtHome extends JFrame {

	private static final String[] COLUNM_NAMES = {"이름", "전화번호", "이메일"};
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JButton btnEnter;
	
	private ContactDao dao = ContactDaoImpl.getInstance();

	private DefaultTableModel model;
	
	private Component parentComponent;
	/**
	 * Launch the application.
	 */
	public static void showContactSearchFrame(Component pc) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactSearchFrameAtHome frame = new ContactSearchFrameAtHome(pc);
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
	public ContactSearchFrameAtHome(Component pc) {
		this.parentComponent = pc;
		initialize();
	}
	
	public void initialize() {
		setTitle("연락처 검색");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x=700;
		int y=300;
		if (parentComponent != null) {
			x=parentComponent.getX();
			y=parentComponent.getY();
		}
		setBounds(x, y, 441, 381);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 14));
		textField.setBounds(22, 10, 295, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnEnter = new JButton("검색");
		btnEnter.addActionListener((e)->searchContact());
		btnEnter.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 14));
		btnEnter.setBounds(329, 10, 84, 35);
		contentPane.add(btnEnter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 55, 378, 247);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 13));
		model = new DefaultTableModel(null, COLUNM_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
		

	}

	private void searchContact() {
		String search = textField.getText();
		if (search.equals("")) {
			JOptionPane.showMessageDialog(table, "no.");
			return;
		}
		List<Contact> list = dao.read();
		List<Integer> indexes = new ArrayList<Integer>();
		for (int i =0; i<list.size();i++) {
			if (list.get(i).getName().contains(search)
				|| list.get(i).getPhone().contains(search)
				|| list.get(i).getEmail().contains(search)
				) {
				indexes.add(i);
			}

		}
		List<Contact> searched = new ArrayList<>();
		for (int i : indexes) {
			searched.add(dao.read(i));
		}
		if (searched.equals(null)) {
			JOptionPane.showMessageDialog(table, "no.");
			return;
		}
		for (Contact c : searched) {
			Object[] row = {c.getName(),c.getPhone(),c.getEmail()};
			model.addRow(row);
		}
		table.setModel(model);

	}
	
}

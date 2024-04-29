package com.itwill.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;
import com.itwill.jdbc.view.BlogCreateFrame.CreateNotify;

import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogMain implements CreateNotify {

	private static final String[] SEARCH_TYPES = { "제목", "내용", "제목+내용", "작성자" };
	private static final String[] COLUMN_NAMES = { "블로그 번호", "블로그 제목", "작성자", "수정시간" };

	private JFrame frame;
	private JPanel searchPanel;
	private JComboBox<String> comboBox;
	private JTextField textSearchKeyword;
	private JButton btnSearch;
	private JPanel buttonPanel;
	private JButton btnReadAll;
	private JButton btnCreate;
	private JButton btnDetails;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private BlogDao dao = BlogDao.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogMain window = new BlogMain();
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
	public BlogMain() {
		initialize();
		initializeTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 481, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("블로그 메인");

		searchPanel = new JPanel();
		frame.getContentPane().add(searchPanel, BorderLayout.NORTH);

		comboBox = new JComboBox<>();
		final DefaultComboBoxModel<String> comboboxmodel = new DefaultComboBoxModel<>(SEARCH_TYPES);
		comboBox.setModel(comboboxmodel);
		comboBox.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 17));
		searchPanel.add(comboBox);

		textSearchKeyword = new JTextField();
		textSearchKeyword.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 17));
		searchPanel.add(textSearchKeyword);
		textSearchKeyword.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener((e) -> search());
		btnSearch.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 17));
		searchPanel.add(btnSearch);

		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		btnReadAll = new JButton("목록보기");
		btnReadAll.addActionListener((e)->initializeTable());
		btnReadAll.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 17));
		buttonPanel.add(btnReadAll);

		btnCreate = new JButton("새 블로그");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 새 블로그 작성 창 띄우기
				BlogCreateFrame.showBlogCreateFrame(frame, BlogMain.this);

			}
		});
		btnCreate.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 17));
		buttonPanel.add(btnCreate);

		btnDetails = new JButton("상세보기");
		btnDetails.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 17));
		buttonPanel.add(btnDetails);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener((e) -> deleteBlog());
		btnDelete.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 17));
		buttonPanel.add(btnDelete);

		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

	}

	private void search() {
		// search type 찾기 by combobox
		int type = comboBox.getSelectedIndex(); //콤보박스에서 선택된 아이템의 인덱스
		String keyword = textSearchKeyword.getText();
		if (keyword.equals("")) {
			JOptionPane.showMessageDialog(frame, "검색어를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			textSearchKeyword.requestFocus(); //->검색어 입력 필드에 포커스를 줌 (커서 깜박깜박)
			return;
		}
		//dao 메서드를 호출해서 검색결과를 가져옴
		List<Blog> blogs = dao.search(type, keyword);
		resetTable(blogs);
	}

	private void deleteBlog() {
		//TODO 행이 선택되ㅓ잇는지 확인, 그 후 아이디 확인 
		//테이블에서 선택된 행의 index
		 int index = table.getSelectedRow();
		 if (index == -1) { //Jtable에서 선택된 행이 없을 때
			 JOptionPane.showMessageDialog(frame, "삭제할 행을 먼저 고르시오", "경고", JOptionPane.WARNING_MESSAGE);
			 return;
		 }
		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제할까요?", "삭제 확인", JOptionPane.OK_CANCEL_OPTION);
		if (confirm == JOptionPane.OK_OPTION) {
			//선택된 행에서 블로그 번호(id)를 읽음
			Integer id = (Integer) tableModel.getValueAt(index, 0); //얘가 object 반환해서 인티저로 하는거
			// 인티저.파스인트 못 씀@  ㅜㅜ
			int result = dao.deleteBlog(id);
			if (result == 1) {
				initializeTable();
				JOptionPane.showMessageDialog(frame, "삭제 성공");
			} else {
				JOptionPane.showMessageDialog(frame, "삭제 실패");
			}
		} 
	}

	private void initializeTable() {
		// dao를 사용해서 db테이블에서 검색
		List<Blog> blogs = dao.read();
		resetTable(blogs);

	}
	
	private void resetTable(List<Blog> blogs) {
		// 검색한 내용을 Jtable에 보여줌 - Jtable의 테이블 모델을 재설정(리셋)
		tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델리셋
		for (Blog b : blogs) {
			// db 테이블에서 검색한 레코드를 jtable에서 사용할 수 있는 행 데이터로 변환
			Object[] row = { b.getId(), b.getTitle(), b.getWriter(), b.getModifiedTime() };
			tableModel.addRow(row); // 테이블 모델에 행 데이터 추가
		}
		table.setModel(tableModel);// jtable에 모델을 다시 설정
	}

	@Override
	public void notifyCreateSuccess() {
		// 테이블에 insert 성공 시 BlogCreateFrame이 호출할 메서드
		initializeTable(); 
		JOptionPane.showMessageDialog(frame, "새 블로그 등록 성공");
	}

}

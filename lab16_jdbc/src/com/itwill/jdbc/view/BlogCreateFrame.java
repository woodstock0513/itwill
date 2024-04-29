package com.itwill.jdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class BlogCreateFrame extends JFrame {
	
	public interface CreateNotify{
		void notifyCreateSuccess();
	}

	private static final long serialVersionUID = 1L;
	private BlogDao dao = BlogDao.getInstance();
	private JPanel contentPane;
	private JTextField textTitle;
	private JLabel lblTitle;
	private JLabel lblContent;
	private JScrollPane scrollPane;
	private JTextArea textContent;
	private JTextField textWriter;
	private JLabel lblWriter;
	private JButton btnSave;
	private JButton btnCancel;
	
	private Component parent;
	private CreateNotify app;
	
	/**
	 * Launch the application.
	 */
	public static void showBlogCreateFrame(Component parent, CreateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogCreateFrame frame = new BlogCreateFrame(parent,app);
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
	private BlogCreateFrame(Component parent,CreateNotify app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}

	public void initialize() {
		setTitle("새 블로그 작성");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 700;
		int y = 300;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 378, 502);
		if (parent != null) {
			setLocationRelativeTo(null);
		}

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("제목을 입력하세요");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblTitle.setBounds(12, 10, 338, 29);
		contentPane.add(lblTitle);

		textTitle = new JTextField();
		textTitle.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		textTitle.setBounds(12, 49, 338, 52);
		contentPane.add(textTitle);
		textTitle.setColumns(10);

		lblContent = new JLabel("내용을 입력하세요");
		lblContent.setHorizontalAlignment(SwingConstants.LEFT);
		lblContent.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblContent.setBounds(12, 111, 338, 29);
		contentPane.add(lblContent);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 150, 338, 145);
		contentPane.add(scrollPane);

		textContent = new JTextArea();
		textContent.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		scrollPane.setViewportView(textContent);

		textWriter = new JTextField();
		textWriter.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		textWriter.setColumns(10);
		textWriter.setBounds(12, 348, 338, 52);
		contentPane.add(textWriter);

		lblWriter = new JLabel("작성자를 입력하세요");
		lblWriter.setHorizontalAlignment(SwingConstants.LEFT);
		lblWriter.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		lblWriter.setBounds(12, 309, 338, 29);
		contentPane.add(lblWriter);

		btnSave = new JButton("저장");
		btnSave.addActionListener((e) -> createNewBlog());
		btnSave.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		btnSave.setBounds(12, 410, 151, 43);
		contentPane.add(btnSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("더잠실 3 Regular", Font.PLAIN, 16));
		btnCancel.setBounds(199, 410, 151, 43);
		contentPane.add(btnCancel);
	}

	private void createNewBlog() {
		//제목 내용 작성자에 입력된 내용을 blog 객체로 만들어서 dao를 이용하여 db에 저장.(insert)
		String title = textTitle.getText();
		String content = textContent.getText();
		String writer = textWriter.getText();
		if (title.equals("")||content.equals("")||writer.equals("")) {
			JOptionPane.showMessageDialog(BlogCreateFrame.this, 
					"제목, 내용, 작성자를 모두 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		Blog blog = new Blog(0, title, content, writer, null, null);
		int result = dao.create(blog);
		//BlogMain에게 삽입 성공 실패 여부를 알려주고 현재창 닫기
		if (result ==1) {
			app.notifyCreateSuccess();
			dispose();
		} else {
			JOptionPane.showMessageDialog(BlogCreateFrame.this, "insert 실패");
		}
	}
}

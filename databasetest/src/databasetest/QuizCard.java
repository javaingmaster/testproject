package databasetest;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class QuizCard {
	private JFrame frame;//窗口
	private JPanel mainPanel;//主镶嵌板
	private Font bigFont;//文字区域的字体
	private JButton cardPlayer;//显示播放器
	private JButton cardBuilder;//显示builder

	//Builder的变量
	private JTextArea display;// 显示问题或者答案的文字区域
	private List<QuizCardBean> cardListDisplay;// 从文件加载的卡片组
	private QuizCardBean currentCard;// 当前卡片
	private int currentCardIndex;// 当前卡片在容器中的索引
	private JButton nextButton;// 显示下一张卡片
	private boolean isToShowAnswer;// 标志按钮的下一步事件是否为展示答案

	//Player的变量
	private JTextArea questionArea;// 问题区域
	private JTextArea answerArea;// 答案区域
	private JButton next;// 下一个
	private List<QuizCardBean> cardList;// 卡片列表

	public static void main(String[] args) {
		new QuizCard().start();
	}

	public QuizCard() {
		frame = new JFrame("QuizCard");
		mainPanel = new JPanel();
		bigFont = new Font("sanserif", Font.BOLD, 20);// 应用于JTextArea的字体
		cardPlayer = new JButton("Card Player");
		cardBuilder = new JButton("Card Builder");

		display = new JTextArea(15, 20);
		cardListDisplay = new ArrayList<QuizCardBean>();//player里面展示card的list
		nextButton = new JButton();

		questionArea = new JTextArea(6, 20);
		answerArea = new JTextArea(6, 20);
		next = new JButton("Show Question");
		cardList = new ArrayList<QuizCardBean>();
	}

	/**
	 * 启动界面
	 */
	public void start() {
		frame.setTitle("Quiz Card");
		cardBuilder.addActionListener(new BuilderListener());
		cardPlayer.addActionListener(new PlayerListener());

		mainPanel.add(cardBuilder);
		mainPanel.add(cardPlayer);

		// frame相关设置
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);// 设置窗口大小不可变
		frame.requestFocus();
		frame.setVisible(true);
		
	}

	/**
	 * 加载builder窗口，程序开始
	 */
	public void builder() {
		frame.setTitle("Builder");
		// questionArea的设置
		questionArea.setLineWrap(true);
		questionArea.setWrapStyleWord(true);
		questionArea.setFont(bigFont);

		// 问题区域的滚动条设置
		JScrollPane qScrollPane = new JScrollPane(questionArea);// 为文字区域增加滚动镶嵌板
		qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// answerArea的设置
		answerArea.setLineWrap(true);
		answerArea.setWrapStyleWord(true);
		answerArea.setFont(bigFont);

		// 回答区域的滚动条设置
		JScrollPane aScrollPane = new JScrollPane(answerArea);//
		aScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// nextButton用于写下一张卡片
		nextButton.setText("Next card");
		nextButton.addActionListener(new NextListener());

		// 为两个文字区域的用途作指示的JLaber
		JLabel qLabel = new JLabel("English");
		JLabel aLabel = new JLabel("Translation");

		// 将组件加入到mainPanel中
		mainPanel.add(qLabel);
		mainPanel.add(qScrollPane);
		mainPanel.add(aLabel);
		mainPanel.add(aScrollPane);
		mainPanel.add(nextButton);

		// 设置frame左上角的菜单
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");

		// 设置菜单中的事件
		JMenuItem newMenuItem = new JMenuItem("New card list");
		JMenuItem saveMenuItem = new JMenuItem("Save current list");
		JMenuItem returnMenuItem = new JMenuItem("Return");

		newMenuItem.addActionListener(new NewListener());
		saveMenuItem.addActionListener(new SaveListener());
		returnMenuItem.addActionListener(new ReturnMenuListener());

		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(returnMenuItem);

		menuBar.add(fileMenu);

		// frame相关设置
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);// 设置窗口大小不可变
		frame.setVisible(true);
	}

	/**
	 * 保存文件
	 * 
	 * @param file
	 */
	private void saveFile(File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			for (QuizCardBean quizCardBean : cardList) {
				writer.write(quizCardBean.getQuestion() + "/");// 问题和答案之间使用/隔开
				writer.flush();
				writer.write(quizCardBean.getAnswer() + "\r\n");// 换行
				writer.flush();
			}

			writer.close();// 关闭流

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 清空文字区域，为下一张卡片做准备
	 */
	private void clear() {
		questionArea.setText("");
		answerArea.setText("");
		questionArea.requestFocus();
	}

	/**
	 * 加载播放器窗口
	 */
	public void player() {
		frame.setTitle("Player");
		//展示区域的相关设置
		display.setFont(bigFont);
		display.setLineWrap(true);
		display.setWrapStyleWord(true);
		display.setEditable(false);// 设置该区域不能编辑

		//设置滚动条
		JScrollPane qScrollPane = new JScrollPane(display);
		qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		next.addActionListener(new NextButtonListener());

		//主镶嵌板添加组件
		mainPanel.add(qScrollPane);
		mainPanel.add(next);

		//添加菜单的时间
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		JMenuItem returnMenuItem = new JMenuItem("Return");

		loadMenuItem.addActionListener(new OpenMenuListener());
		returnMenuItem.addActionListener(new ReturnMenuListener());

		menu.add(loadMenuItem);
		menu.add(returnMenuItem);

		menuBar.add(menu);

		//窗口设置
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	/**
	 * 将字符串按要求分隔，制作成卡片
	 * 
	 * @param string
	 */
	private void makeCard(String string) {
		String[] result = string.split("/");//分割
		QuizCardBean card = new QuizCardBean(result[0], result[1]);
		cardListDisplay.add(card);
	}

	/**
	 * 下一张卡片
	 */
	private void showNextCard() {
		currentCard = cardListDisplay.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		next.setText("Show Answer");
		isToShowAnswer = true;
	}

	/**
	 * 加载文件
	 * 
	 * @param file
	 */
	private void loadFile(File file) {
		cardListDisplay.removeAll(cardListDisplay);//先清空list
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = reader.readLine()) != null) {
				makeCard(line);
			}

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * next的事件监听
	 * 
	 * @author Administrator
	 *
	 */
	private class NextListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			QuizCardBean card = new QuizCardBean(questionArea.getText(), answerArea.getText());
			cardList.add(card);
			clear();//清空文字区域
			frame.requestFocus();
		}
	}

	/**
	 * 监听播放器界面的next
	 * 
	 * @author Administrator
	 *
	 */
	private class NextButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (isToShowAnswer) {
				display.setText(currentCard.getAnswer());
				next.setText("Next Card");
				isToShowAnswer = false;
			} else {
				if (currentCardIndex < cardListDisplay.size()) {
					showNextCard();
				} else {
					display.setText("That was the last question");
					next.setEnabled(false);
				}
			}

			frame.requestFocus();
		}
	}

	/**
	 * 监听菜单loadCardSet
	 * 
	 * @author Administrator
	 *
	 */
	private class OpenMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			next.setEnabled(true);

			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);// 显示对话框

			if (null != fileOpen.getSelectedFile()) {// 当选择路径不为空才进行加载
				loadFile(fileOpen.getSelectedFile());
			}
		}
	}

	/**
	 * new菜单事件监听
	 * 
	 * @author Administrator
	 *
	 */
	private class NewListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardList.clear();
			clear();
		}
	}

	/**
	 * save菜单的事件监听
	 * 
	 * @author Administrator
	 *
	 */
	private class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (questionArea.getText().length() != 0 && answerArea.getText().length() != 0) {// 防止为空
				QuizCardBean card = new QuizCardBean(questionArea.getText(), answerArea.getText());
				cardList.add(card);
			}

			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);// 显示选择路径的界面

			if (fileSave.getSelectedFile() != null) {// 避免空指针
				saveFile(fileSave.getSelectedFile());
			}
		}
	}

	/**
	 * 监听cardBuilder
	 * 
	 * @author Administrator
	 *
	 */
	private class BuilderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().remove(mainPanel);
			mainPanel.removeAll();

			builder();
			frame.repaint();
			frame.setVisible(true);

			frame.requestFocus();
		}
	}

	/**
	 * 监听cardPlayer
	 * 
	 * @author Administrator
	 *
	 */
	private class PlayerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
			mainPanel.removeAll();//清空（初始化）

			player();
			frame.repaint();
			frame.setVisible(true);

			frame.requestFocus();
		}
	}

	/**
	 * 监听Return
	 * 
	 * @author Administrator
	 *
	 */
	private class ReturnMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!cardList.isEmpty()) {
				cardList.removeAll(cardList);
			}
			if (!cardListDisplay.isEmpty()) {
				cardListDisplay.removeAll(cardListDisplay);
			}

			next.setEnabled(true);

			frame.getContentPane().removeAll();
			mainPanel.removeAll();
			frame.setJMenuBar(null);
			start();
			frame.repaint();
			frame.setVisible(true);
		}
	}
}

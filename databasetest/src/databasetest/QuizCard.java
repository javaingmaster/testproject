package databasetest;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class QuizCard {
	private JFrame frame;//����
	private JPanel mainPanel;//����Ƕ��
	private Font bigFont;//�������������
	private JButton cardPlayer;//��ʾ������
	private JButton cardBuilder;//��ʾbuilder

	//Builder�ı���
	private JTextArea display;// ��ʾ������ߴ𰸵���������
	private List<QuizCardBean> cardListDisplay;// ���ļ����صĿ�Ƭ��
	private QuizCardBean currentCard;// ��ǰ��Ƭ
	private int currentCardIndex;// ��ǰ��Ƭ�������е�����
	private JButton nextButton;// ��ʾ��һ�ſ�Ƭ
	private boolean isToShowAnswer;// ��־��ť����һ���¼��Ƿ�Ϊչʾ��

	//Player�ı���
	private JTextArea questionArea;// ��������
	private JTextArea answerArea;// ������
	private JButton next;// ��һ��
	private List<QuizCardBean> cardList;// ��Ƭ�б�

	public static void main(String[] args) {
		new QuizCard().start();
	}

	public QuizCard() {
		frame = new JFrame("QuizCard");
		mainPanel = new JPanel();
		bigFont = new Font("sanserif", Font.BOLD, 20);// Ӧ����JTextArea������
		cardPlayer = new JButton("Card Player");
		cardBuilder = new JButton("Card Builder");

		display = new JTextArea(15, 20);
		cardListDisplay = new ArrayList<QuizCardBean>();//player����չʾcard��list
		nextButton = new JButton();

		questionArea = new JTextArea(6, 20);
		answerArea = new JTextArea(6, 20);
		next = new JButton("Show Question");
		cardList = new ArrayList<QuizCardBean>();
	}

	/**
	 * ��������
	 */
	public void start() {
		frame.setTitle("Quiz Card");
		cardBuilder.addActionListener(new BuilderListener());
		cardPlayer.addActionListener(new PlayerListener());

		mainPanel.add(cardBuilder);
		mainPanel.add(cardPlayer);

		// frame�������
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);// ���ô��ڴ�С���ɱ�
		frame.requestFocus();
		frame.setVisible(true);
		
	}

	/**
	 * ����builder���ڣ�����ʼ
	 */
	public void builder() {
		frame.setTitle("Builder");
		// questionArea������
		questionArea.setLineWrap(true);
		questionArea.setWrapStyleWord(true);
		questionArea.setFont(bigFont);

		// ��������Ĺ���������
		JScrollPane qScrollPane = new JScrollPane(questionArea);// Ϊ�����������ӹ�����Ƕ��
		qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// answerArea������
		answerArea.setLineWrap(true);
		answerArea.setWrapStyleWord(true);
		answerArea.setFont(bigFont);

		// �ش�����Ĺ���������
		JScrollPane aScrollPane = new JScrollPane(answerArea);//
		aScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// nextButton����д��һ�ſ�Ƭ
		nextButton.setText("Next card");
		nextButton.addActionListener(new NextListener());

		// Ϊ���������������;��ָʾ��JLaber
		JLabel qLabel = new JLabel("English");
		JLabel aLabel = new JLabel("Translation");

		// ��������뵽mainPanel��
		mainPanel.add(qLabel);
		mainPanel.add(qScrollPane);
		mainPanel.add(aLabel);
		mainPanel.add(aScrollPane);
		mainPanel.add(nextButton);

		// ����frame���ϽǵĲ˵�
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");

		// ���ò˵��е��¼�
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

		// frame�������
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);// ���ô��ڴ�С���ɱ�
		frame.setVisible(true);
	}

	/**
	 * �����ļ�
	 * 
	 * @param file
	 */
	private void saveFile(File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			for (QuizCardBean quizCardBean : cardList) {
				writer.write(quizCardBean.getQuestion() + "/");// ����ʹ�֮��ʹ��/����
				writer.flush();
				writer.write(quizCardBean.getAnswer() + "\r\n");// ����
				writer.flush();
			}

			writer.close();// �ر���

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * �����������Ϊ��һ�ſ�Ƭ��׼��
	 */
	private void clear() {
		questionArea.setText("");
		answerArea.setText("");
		questionArea.requestFocus();
	}

	/**
	 * ���ز���������
	 */
	public void player() {
		frame.setTitle("Player");
		//չʾ������������
		display.setFont(bigFont);
		display.setLineWrap(true);
		display.setWrapStyleWord(true);
		display.setEditable(false);// ���ø������ܱ༭

		//���ù�����
		JScrollPane qScrollPane = new JScrollPane(display);
		qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		next.addActionListener(new NextButtonListener());

		//����Ƕ��������
		mainPanel.add(qScrollPane);
		mainPanel.add(next);

		//��Ӳ˵���ʱ��
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		JMenuItem returnMenuItem = new JMenuItem("Return");

		loadMenuItem.addActionListener(new OpenMenuListener());
		returnMenuItem.addActionListener(new ReturnMenuListener());

		menu.add(loadMenuItem);
		menu.add(returnMenuItem);

		menuBar.add(menu);

		//��������
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	/**
	 * ���ַ�����Ҫ��ָ��������ɿ�Ƭ
	 * 
	 * @param string
	 */
	private void makeCard(String string) {
		String[] result = string.split("/");//�ָ�
		QuizCardBean card = new QuizCardBean(result[0], result[1]);
		cardListDisplay.add(card);
	}

	/**
	 * ��һ�ſ�Ƭ
	 */
	private void showNextCard() {
		currentCard = cardListDisplay.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		next.setText("Show Answer");
		isToShowAnswer = true;
	}

	/**
	 * �����ļ�
	 * 
	 * @param file
	 */
	private void loadFile(File file) {
		cardListDisplay.removeAll(cardListDisplay);//�����list
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
	 * next���¼�����
	 * 
	 * @author Administrator
	 *
	 */
	private class NextListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			QuizCardBean card = new QuizCardBean(questionArea.getText(), answerArea.getText());
			cardList.add(card);
			clear();//�����������
			frame.requestFocus();
		}
	}

	/**
	 * ���������������next
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
	 * �����˵�loadCardSet
	 * 
	 * @author Administrator
	 *
	 */
	private class OpenMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			next.setEnabled(true);

			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);// ��ʾ�Ի���

			if (null != fileOpen.getSelectedFile()) {// ��ѡ��·����Ϊ�ղŽ��м���
				loadFile(fileOpen.getSelectedFile());
			}
		}
	}

	/**
	 * new�˵��¼�����
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
	 * save�˵����¼�����
	 * 
	 * @author Administrator
	 *
	 */
	private class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (questionArea.getText().length() != 0 && answerArea.getText().length() != 0) {// ��ֹΪ��
				QuizCardBean card = new QuizCardBean(questionArea.getText(), answerArea.getText());
				cardList.add(card);
			}

			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);// ��ʾѡ��·���Ľ���

			if (fileSave.getSelectedFile() != null) {// �����ָ��
				saveFile(fileSave.getSelectedFile());
			}
		}
	}

	/**
	 * ����cardBuilder
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
	 * ����cardPlayer
	 * 
	 * @author Administrator
	 *
	 */
	private class PlayerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
			mainPanel.removeAll();//��գ���ʼ����

			player();
			frame.repaint();
			frame.setVisible(true);

			frame.requestFocus();
		}
	}

	/**
	 * ����Return
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

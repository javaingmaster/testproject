package Play;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 23, 2017
 * @description The subframe to be showed when the game is over.
 *
 */
public class EndFrame extends JDialog {
	public static final int YES_OPTION = 1; // the option when the player
	// chooses yes
	public static final int NO_OPTION = 0;
	private static final long serialVersionUID = 14564384251L;
	
	private static Font font;// the font of the label
	private static int option = 0; // the option that the player chooses

	/**
	 * Private constructor prevents instantiating this class.
	 * 
	 * @param width
	 * @param height
	 */
	private EndFrame(int width, int height, int time, int score) {
		super();
		init(time, score);
		setModal(true);
		setSize(width, height);
	}

	/**
	 * initialize this frame
	 */
	private void init(int time, int score) {
		Container container = getContentPane();

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel timeLabel = new JLabel("Time: " + time);
		timeLabel.setBounds(100, 130, 300, 50);
		timeLabel.setFont(font);

		JLabel scoreLabel = new JLabel("Score: " + score);
		scoreLabel.setBounds(100, 230, 300, 50);
		scoreLabel.setFont(font);

		JButton yes = new JButton("Yes");
		yes.setBounds(50, 400, 70, 30);
		yes.addActionListener((e) -> {
			option = YES_OPTION;
			this.dispose();
		});

		JButton no = new JButton("no");
		no.setBounds(380, 400, 70, 30);
		no.addActionListener((e) -> {
			option = NO_OPTION;
			this.dispose();
		});

		panel.add(timeLabel);
		panel.add(scoreLabel);
		panel.add(yes);
		panel.add(no);

		container.add(panel);
		this.setTitle("A new Game?");
	}

	/**
	 * show a confirm dialog
	 * 
	 * @param relativeTo
	 *            the component this is relative to
	 * @param time
	 *            the string represent for the time
	 * @param score
	 *            the score the player has got
	 * @return YES_OPTION means the player wants to start a new game. NO_OPTION
	 *         means the player don't want to start a new game.
	 */
	public static int showDialog(Component relativeTo, int time, int score) {
		if (null == font) {
			font = new Font("serif", Font.BOLD, 40);
		}
		EndFrame subframe = new EndFrame(500, 500, time, score);
		subframe.setLocationRelativeTo(relativeTo);
		subframe.setVisible(true);
		int opt = option;
		option = NO_OPTION;
		return opt;
	}
}

package play;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.TimerTask;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 8, 2017
 * @description The notice that shows when something is happening.It inherits
 *              the class TimerTask for the timing.
 *
 */
public class Notice extends TimerTask implements Drawable {
	private int xpos;
	private int ypos;
	private Font font;
	private Color color;
	private String notice;
	private List<Drawable> objects;

	public Notice(int xpos, int ypos, Font font, Color color, String notice, List<Drawable> objects) {
		super();
		this.xpos = xpos;
		this.ypos = ypos;
		this.font = font;
		this.color = color;
		this.notice = notice;
		this.objects = objects;
	}

	@Override
	public void drawSelf(Graphics g) {
		// save the previous font and color
		Font pFont = g.getFont();
		Color pColor = g.getColor();

		g.setFont(font);
		g.setColor(color);

		g.drawString(notice, xpos, ypos);

		// recover the previous font and color
		g.setFont(pFont);
		g.setColor(pColor);
	}

	@Override
	public void run() {
		objects.remove(this);
	}

	@Override
	public Rectangle getRectangle() {
		return null;
	}

	/**
	 * It is not necessary to do something for notice and plane.
	 */
	@Override
	public void affect(Plane plane) {

	}
}

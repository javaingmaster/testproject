package play;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * 
 * @author Zhou TingYu
 * @date Jun 8, 2017
 * @description A prop that change the fire
 *
 */
public class ChangeFireProp extends Prop implements Drawable{

protected List<Prop> props;
	
	public ChangeFireProp(int xpos, int ypos, BufferedImage image,  List<Prop> props) {
		super(xpos, ypos, image);
		this.props = props;
	}

	@Override
	public void affect(Plane plane) {
		plane.bulletStyle++;
		props.remove(this); 
	}
	
	public void outDetection() {
		if (xpos < 0 || xpos > 630) {
			props.remove(this);
		}
		if (ypos < 0 || ypos > 900) {
			props.remove(this);
		}
	}
	@Override
	public Rectangle getRectangle() {
		return new Rectangle(xpos, ypos, image.getWidth(), image.getHeight());
	}

	@Override
	public void drawSelf(Graphics g) {
		g.drawImage(image, xpos,ypos,null);
		ypos+=Constants.PLANE_SPEED;
		outDetection();
	}
}

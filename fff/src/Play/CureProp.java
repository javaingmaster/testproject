package Play;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 8, 2017
 * @description A prop that increase the life
 *
 */
public class CureProp extends Prop{
	protected List<Prop> props;
	
	public CureProp(int xpos, int ypos, BufferedImage image,  List<Prop> props) {
		super(xpos, ypos, image);
		this.props = props;
	}

	@Override
	public void affect(Plane plane) {
		plane.decreaseLife(-500);
		props.remove(this); 
	}
}

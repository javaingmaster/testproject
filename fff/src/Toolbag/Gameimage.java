package Toolbag;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Gameimage  
{
	public static Image getimage(String path)         //º”‘ÿÕº∆¨
	{
		URL u=Gameimage.class.getClassLoader().getResource(path);
		BufferedImage imag=null;
		try {
			imag=ImageIO.read(u);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return imag;
	}

}

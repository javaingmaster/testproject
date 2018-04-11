package pointmove;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

	public class Pointstudy extends JFrame
	{
	    private final static int SPEED= 50;// 控制移动速度
	    private static int BANJIN = 30;
	    private static Point newLocationPoint = new Point(0, 0);
	    private static Point oldLocationPoint = new Point(1, 1);
	    private static Point moveLocationPoint = new Point(50, 50);
	    private static double xielv = 0.0;
	    private static double W = 0.0, H = 0.0;
	    private static int LEFTorRIGHT = 0, UPorDOWN = 0;
	    // LEFTorRIGHT=-1的时候向左，=1的时候向右，UPorDOWN=1的时候下，-1的时候向上
	    JLabel huaban = new huaban();
	    public Pointstudy() {
	        this.setTitle("圆的移动");
	        this.setLocation(300, 100);
	        this.setSize(500, 400);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	        setLayout(null);
	        huaban.setLocation(50, 50);
	        add(huaban);
	        addMouseListener(new MouseListener() {
	            @Override
	            public void mouseReleased(MouseEvent arg0) {
	            }
	            @Override
	            public void mousePressed(MouseEvent arg0) {
	            }
	            @Override
	            public void mouseExited(MouseEvent arg0) {
	            }
	            @Override
	            public void mouseEntered(MouseEvent arg0) {
	            }
	            @Override
	            public void mouseClicked(MouseEvent arg0) {
	                newLocationPoint.setLocation(arg0.getPoint());
	                new Timer().schedule(new TimerTask() 
	                {
	                    @Override
	                    public void run() {
	                        move();
	                    }
	                }, SPEED, SPEED);
	            }
	        });
	    }
	    private void move() {
	        double temp=0.0;
	        oldLocationPoint.setLocation(huaban.getLocation());
	        oldLocationPoint.x+=15;
	        oldLocationPoint.y+=15;
	        W=Math.abs((newLocationPoint.x - oldLocationPoint.x ));
	        H=Math.abs((newLocationPoint.y - oldLocationPoint.y ));
	        temp=Math.sqrt(W*W+H*H);
	        try {
	            UPorDOWN = (newLocationPoint.y - oldLocationPoint.y)
	                    / Math.abs(newLocationPoint.y - oldLocationPoint.y);
	        } catch (Exception e) {
	            UPorDOWN = 0;
	        }
	        try {
	            LEFTorRIGHT = (newLocationPoint.x - oldLocationPoint.x)
	                    / Math.abs(newLocationPoint.x - oldLocationPoint.x);
	            xielv = Math.abs((newLocationPoint.y - oldLocationPoint.y)
	                    / (newLocationPoint.x - oldLocationPoint.x));
	        } catch (Exception e) {
	            LEFTorRIGHT = 0;
	            moveLocationPoint.y +=UPorDOWN;
	            huaban.setLocation(moveLocationPoint.x-15, moveLocationPoint.y-15);
	            return;
	        }
	        //误差在下面的四舍五入出现
	        moveLocationPoint.x += (int) Math.round(W/temp) * LEFTorRIGHT;
	        moveLocationPoint.y += (int) Math.round(H/temp )* UPorDOWN;
	        huaban.setLocation(moveLocationPoint.x-15, moveLocationPoint.y-15);
	    }
	    private void drawCirlce(Graphics g) {
	        g.setColor(Color.blue);
	        g.fillOval(0, 0, BANJIN, BANJIN);
	    }
	    public static void main(String[] args) {
	    	Pointstudy frame = new Pointstudy();
	    }
	    public class huaban extends JLabel {
	        public huaban() {
	            setSize(BANJIN, BANJIN);
	        }
	        public void paint(Graphics g) {
	            super.paint(g);
	            Image image = createImage(getWidth(), getHeight());
	            drawCirlce(image.getGraphics());
	            g.drawImage(image, 0, 0, null);
	        }
	    }
	}



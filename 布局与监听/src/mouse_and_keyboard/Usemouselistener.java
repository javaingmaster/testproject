package mouse_and_keyboard;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

	public class Usemouselistener {

	    public static void main(String[] args) {
	        new FramePoints();
	    }
	}
	class FramePoints extends Frame{

	    private static final long serialVersionUID = 1L;
	    ArrayList<Point> points;
	    
	    public FramePoints() {
	        points=new ArrayList<Point>();
	        this.addMouseListener(new MonitorPoint());
	        //this.addWindowListener(new WindowClose(this));
	        setSize(500,400);
	        setVisible(true);
	    }
	    
	    @Override
	    public void paint(Graphics g) {
	        g.setColor(Color.GREEN);
	        Iterator<Point> iterator=points.iterator();
	        while (iterator.hasNext()) {
	            Point point = (Point) iterator.next();
	            g.fillOval(point.x, point.y, 10, 10);
	        }
	    }
	    
	    //监听鼠标事件:MouseAdapter implements MouseListener
	    class MonitorPoint extends MouseAdapter{
	        @Override
	        public void mousePressed(MouseEvent e) {
	            FramePoints f=(FramePoints)e.getSource();
	            points.add(new Point(e.getX(), e.getY()));
	            f.repaint();
	        }
	    }
	    
	    //监听窗口事件:WindowAdapter implements WindowListener
//	    class MonitorWindow extends WindowAdapter{
//	        public void windowClosing(WindowEvent e) {
//	            setVisible(false);
//	            System.exit(0);
//	        }
//	    }
	}


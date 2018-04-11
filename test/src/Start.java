import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Start {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EventQueue.invokeLater(new Runnable() {           
            @Override
            public void run() {
                // TODO Auto-generated method stub
                JFrame frame = new ImageViewerFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class ImageViewerFrame extends JFrame{
	String name;
	File file;
	BufferedImage img;
	int type_=-1;
	int count;
	BufferedImage[] sub;
	int[][] pixel=new int[1000][1000];
    public ImageViewerFrame(){
        setTitle("ImageViewer");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new BorderLayout(5,5)); 
        label = new JLabel();
		JTextArea jta; 
		 jta = new JTextArea(10, 15);
        add(label,BorderLayout.WEST);
		add(jta,BorderLayout.EAST);
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu menu = new JMenu("文件");
        menubar.add(menu);
        JMenu type = new JMenu("类型");
        menubar.add(type);
        JMenuItem openItem = new JMenuItem("打开");
        menu.add(openItem);
        JMenuItem grayItem = new JMenuItem("灰度化");
        menu.add(grayItem);
        JMenuItem ThresholdingItem = new JMenuItem("二值化");
        menu.add(ThresholdingItem);
        JMenuItem denoiseItem = new JMenuItem("去噪");
        menu.add(denoiseItem);
        JMenuItem divisionItem = new JMenuItem("分割和归一");
        menu.add(divisionItem); 
        JMenuItem recogItem = new JMenuItem("识别");
        menu.add(recogItem);   
        JMenuItem exitItem = new JMenuItem("关闭");
        menu.add(exitItem);
        JMenuItem securitycodeItem = new JMenuItem("验证码");
        type.add(securitycodeItem);
        JMenuItem textcodeItem = new JMenuItem("文本");
        type.add(textcodeItem);
        securitycodeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                type_=0;
            }
        });
        textcodeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                type_=1;
            }
        });
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                int result = chooser.showOpenDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    name = chooser.getSelectedFile().getPath();
                    file=chooser.getSelectedFile();
                    try {
						img=ImageIO.read(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    label.setIcon(new ImageIcon(img));
                }
            }
        });
        grayItem.addActionListener(new ActionListener() {         
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Gray gray=new Gray(img);
                label.setIcon(new ImageIcon(img));
                label.setVisible(true);
            }
        });
        ThresholdingItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Thresholding thresholding=new Thresholding(img);
                label.setIcon(new ImageIcon(img));
                label.setVisible(true);
            }
        });
        denoiseItem.addActionListener(new ActionListener() {
    
        		@Override
    	public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        			Denoise denoise=new Denoise(img);
                    label.setIcon(new ImageIcon(img));
                    count=denoise.getCount();
                    pixel=denoise.getPixel();
                    label.setVisible(true);
    	}
        });
        divisionItem.addActionListener(new ActionListener() {
            
    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO Auto-generated method stub
    			if(type_==0){
    				
    				Separate denoise=new Separate(img,count,pixel);
    				JOptionPane.showMessageDialog(null, "生成成功 ", "成功 ", JOptionPane.ERROR_MESSAGE);
    				sub=denoise.separate();
 				    Newframe frame=new Newframe(sub,count);
    				
    			}
    			else if(type_==1){
    				Division denoise=new Division(img,count,pixel);
    				JOptionPane.showMessageDialog(null, "生成成功 ", "成功 ", JOptionPane.ERROR_MESSAGE);
//    				SubImage si=new SubImage();   				
    			}
    			else{
    				JOptionPane.showMessageDialog(null, "你未选择类型 ", "警告 ", JOptionPane.ERROR_MESSAGE);
    			}
    		}
        });
        recogItem.addActionListener(new ActionListener() {        
    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO Auto-generated method stub
    			if(type_==0){
    				
    				for(int i=0;i<sub.length;i++)
    				{
    				Train train=new Train(sub,i);
    				train.traink();
    				train.exerecognize();
    				}
    			
    			}
    			else if(type_==1){
    				String path = "D:\\e.jpg"; 
    				String valCode;		
						try {
							valCode = new OCR().recognizeText(new File(path), "jpg");
			   				jta.setText(valCode);  
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		  				
    				}
    		}
        });
        exitItem.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });
    }
    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 1600;
    private static final int DEFAULT_HEIGHT = 800;
}
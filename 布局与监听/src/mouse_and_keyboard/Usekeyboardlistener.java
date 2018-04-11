package mouse_and_keyboard;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Usekeyboardlistener {

    public static void main(String[] args) {
        new FrameKey().lanch();
    }
}

class FrameKey extends Frame {
    private static final long serialVersionUID = 1L;

    void lanch() {
        setSize(300, 200);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                /**
                 * getKeyCode()�����õ��ǰ������������,
                 * �簴A�����۴�Сд����65����ʽ���̲��֣�,���Ҹ����̲���Ҳ�йء�
                 * �������ϼ��Ļ�,�ἤ����keyPressed�¼�,
                 * ��shift+A��ϼ�getKeyCode()�����ͻ�õ�������ֵ,��getKeyChar()����ֻ��õ�һ���ַ�('a')
                 * ����keyPressed�¼���ú�getKeyCode()�������ʹ��
                 * ������� ���ڱ��水���˼����ϵ��ĸ�����������һ�λ��μ���������ɵ��ַ����� "A" ���� shift �� "a" ���ɵģ��� 
                 * ���磬���� Shift �������� keyCode Ϊ VK_SHIFT �� KEY_PRESSED �¼���
                 * ������ 'a' �������� keyCode Ϊ VK_A �� KEY_PRESSED �¼���
                 * �ͷ� 'a' ���󣬻ἤ�� keyCode Ϊ VK_A �� KEY_RELEASED �¼���
                 * ���⣬��������һ�� keyChar ֵΪ 'A' �� KEY_TYPED �¼���
                 */
                System.out.println(keyCode);
                System.out.println(e.getKeyChar());
                switch (keyCode) {
                case KeyEvent.VK_UP:
                    System.out.println("up");
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("down");
                    break;
                case KeyEvent.VK_LEFT:
                    System.out.println("left");
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("right");
                    break;
                default:
                    break;
                }
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
        setVisible(true);
    }
}

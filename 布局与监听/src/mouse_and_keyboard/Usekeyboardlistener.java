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
                 * getKeyCode()方法得到是按键的虚拟键码,
                 * 如按A键无论大小写都是65（美式键盘布局）,而且跟键盘布局也有关。
                 * 如果按组合键的话,会激活多个keyPressed事件,
                 * 如shift+A组合键getKeyCode()方法就会得到两个键值,但getKeyChar()方法只会得到一个字符('a')
                 * 所以keyPressed事件最好和getKeyCode()方法结合使用
                 * 虚拟键码 用于报告按下了键盘上的哪个键，而不是一次或多次键击组合生成的字符（如 "A" 是由 shift ＋ "a" 生成的）。 
                 * 例如，按下 Shift 键会生成 keyCode 为 VK_SHIFT 的 KEY_PRESSED 事件，
                 * 而按下 'a' 键将生成 keyCode 为 VK_A 的 KEY_PRESSED 事件。
                 * 释放 'a' 键后，会激发 keyCode 为 VK_A 的 KEY_RELEASED 事件。
                 * 另外，还会生成一个 keyChar 值为 'A' 的 KEY_TYPED 事件。
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

package test;
import javax.swing.JFrame;

import zty.java.junit.*;

/**
 * @author Administrator
 */
public class CoolUiClassETest extends CoolUiClass
{

    /* (non-Javadoc)
     * @see org.lhj.cool.uiunit.CoolUiClass#appendText()
     */
    @Override
    protected void appendText()
    {
        // call the super method twice
        super.appendText();
        super.appendText();
    }

    /**
     * test the calss in main,use your eye to test.So this method calls Eye Test.
     * the eyt test method's idea is extends the test calss and overrride somemethod so 
     * that you can expect what you need.
     * @param args
     */
    public static void main(String[] args)
    {
        JFrame frm = new JFrame("CoolUiClassETest");
        frm.getContentPane().add(new CoolUiClassETest());
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.pack();
        frm.setVisible(true);
    }

}
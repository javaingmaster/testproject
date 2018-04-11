package Strategy;
/**
 * À„∑®∏®÷˙¿‡
 * @author ÷‹Õ¢”Ó
 *
 */
public abstract class CalculatorUtil {
	public double[] processExp(String exp,String split){
		double[] args=new double[2];
		String[] str=exp.split(split);
		args[0]=Double.parseDouble(str[0]);
		args[1]=Double.parseDouble(str[1]);
		return args;
	}
}

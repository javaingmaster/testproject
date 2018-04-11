package Strategy;

public class Sub extends CalculatorUtil implements Calculator{

	@Override
	public double basicCalculate(String exp) {
		double[] args=this.processExp(exp, "-");
		return args[0]-args[1];
	}

}

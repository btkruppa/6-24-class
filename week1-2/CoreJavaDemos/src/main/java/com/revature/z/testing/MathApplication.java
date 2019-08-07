package com.revature.z.testing;

public class MathApplication {

	private Calculator calc = new Calculator();

	public double modulus(double one, double two) {
		double sign = Math.copySign(1, one);
		one = Math.abs(one);
		two = Math.abs(two);
		while (one > two) {
			one = calc.subtract(one, two);
		}

		return calc.multiply(one, sign);
	}
}

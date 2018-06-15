package com.el.calculator.models;

public class Calculator {

	private static int numDecimalPlaces = 2;
	private static double tolerance = 0.00001;

	private static double add(double a, double b) {
		return a + b;
	}

	private static double subtract(double a, double b) {
		return a - b;
	}

	private static double multiply(double a, double b) {
		return a * b;
	}

	private static double divide(double a, double b) throws ArithmeticException {
		if (b < tolerance)
			throw new ArithmeticException("Division by zero.");
		else
			return a / b;
	}

	public static String calculate(String operation, double a, double b) {
		double result = 0.0;
		switch (operation) {
		case "+":
			result = add(a, b);
			break;
		case "-":
			result = subtract(a, b);
			break;
		case "*":
			result = multiply(a, b);
			break;
		case "/":
			try {
				result = divide(a, b);
			} catch (ArithmeticException e) {
				return "Cannot divide by zero.";
			}
			break;
		}
		String format = "%." + numDecimalPlaces + "f";
		return String.format(format, result);

	}
}

package com.el.calculator.models;

public class Calculator {

	private static int numDecimalPlaces = 2;
	private static double tolerance = 0.01;

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
		if (Math.abs(b) < tolerance)
			throw new ArithmeticException("Cannot divide by zero.");
		else
			return a / b;
	}

	private static double root(double a, double b) throws ArithmeticException {
		if (Math.abs(b) < tolerance)
			throw new ArithmeticException("Cannot take a zero root.");
		else
			return (double) Math.round(Math.pow(a, b));
	}

	private static double power(double a, double b) {
		return Math.pow(a, b);
	}

	private static double log(double a, double b) {
		if ((Math.abs(b) < tolerance) || (Math.abs(a) < tolerance))
			throw new ArithmeticException("Invalid logarithm.");
		else
			return Math.log(a) / Math.log(b);
	}

	private static double natlog(double a) {
		if (Math.abs(a) < tolerance)
			throw new ArithmeticException("Invalid logarithm.");
		else
			return Math.log(a);
	}

	private static double expt(double a) {
		return Math.exp(a);
	}

	// Trig functions used in Math.*

	public static String calculate(String operation, double a, double b) {
		double result = 0.0;
		try {
			switch (operation) {
			case "+":
				result = add(a, b);
				break;
			case "-":
				result = subtract(a, b);
				break;
			case "x":
				result = multiply(a, b);
				break;
			case "/":
				result = divide(a, b);
				break;
			case "root":
				result = root(a, b);
				break;
			case "log":
				result = log(a, b);
				break;
			case "ln":
				result = natlog(a);
				break;
			case "^":
				result = power(a, b);
				break;
			case "e^x":
				result = expt(a);
				break;
			case "sin":
				result = Math.sin(a);
				break;
			case "cos":
				result = Math.cos(a);
				break;
			case "tan":
				result = Math.tan(a);
				break;
			case "sinh":
				result = Math.sinh(a);
				break;
			case "cosh":
				result = Math.cosh(a);
				break;
			case "tanh":
				result = Math.tanh(a);
			default:
				return "Operation not recognized.";
			}
		} catch (ArithmeticException e) {
			return e.getMessage();
		}
		result = (result<tolerance) ? 0.0 : result;
		String format = "%." + numDecimalPlaces + "f";
		return String.format(format, result);

	}
}

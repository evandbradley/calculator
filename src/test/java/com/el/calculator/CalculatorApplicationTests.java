package com.el.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.el.calculator.models.Calculator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorApplicationTests {
	
//	@Parameters
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][] {
//        	{2,2,'+',4},
//        });
//    }
    
    private double a = 2;
    private double b = 2;
    private String operator = "+";
    private String expectedOutput = "4.00";

//    public CalculatorApplicationTests(double a, double b, String operator, String expectedOutput) {
//        this.a = a;
//        this.b = b;
//        this.operator = operator;
//        this.expectedOutput = expectedOutput;
//    }
    
    @ParameterizedTest(name = "{index} => op={0}, first={1}, second={2}, expected= {3}")
    @CsvFileSource(resources = "test_cases.csv")
	void testAll(String op, double first, double second, String expected) {
	  System.out.println("hello");
	  System.out.println(expected);
	  String actual = Calculator.calculate(op, first, second);
	  assertEquals(expected,actual);
  }
 
    
	@Test
	public void contextLoads() {
        assertEquals(Calculator.calculate(operator,a,b),expectedOutput);
        System.out.println("hello");
	}

}

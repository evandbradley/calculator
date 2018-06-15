package com.el.calculator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.el.calculator.models.Calculator;

import junit.framework.Assert;

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

	@Test
	public void contextLoads() {
        assertEquals(Calculator.calculate(operator,a,b),expectedOutput);
	}

}

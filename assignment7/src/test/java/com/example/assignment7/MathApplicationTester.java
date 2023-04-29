package com.example.assignment7;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

public class MathApplicationTester {
	
   private MathApplication mathApplication;
   private CalculatorService calcService;

   @Test
   public void testAddAndSubtract(){
	   
	   mathApplication = new MathApplication();
	   calcService = mock(CalculatorService.class);
	   mathApplication.setCalculatorService(calcService);

       when(calcService.add(20.0,10.0)).thenReturn(30.0);
       when(calcService.subtract(20.0,10.0)).thenReturn(10.0);

       Assert.assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0);
       Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);

       verify(calcService).add(20.0,10.0);
       verify(calcService).subtract(20.0,10.0);
   }
   
   
   
   @Test
   public void testMultiplyAndDivide(){
		   
	   mathApplication = new MathApplication();
	   Calculator calculator = new Calculator();
	   calcService = spy(calculator);
	   mathApplication.setCalculatorService(calcService);
	   
       Assert.assertEquals(mathApplication.multiply(9.0, 10.0),90.0,0);
       Assert.assertEquals(mathApplication.divide(90.0, 10.0),9.0,0);
   }

   class Calculator implements CalculatorService {
	   
       @Override
       public double add(double input1, double input2) {
    	   throw new UnsupportedOperationException("Method not implemented yet!");
       }

       @Override
       public double subtract(double input1, double input2) {
           throw new UnsupportedOperationException("Method not implemented yet!");
       }

       @Override
       public double multiply(double input1, double input2) {
    	   return input1 * input2;
       }

       @Override
       public double divide(double input1, double input2) {
    	   return input1 / input2;
       }
   }
}
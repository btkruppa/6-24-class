package com.revature.z.testing;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTests {
	
	@Mock
	private Calculator calc;
	
	@InjectMocks
	private MathApplication mathApp = new MathApplication();
	
	@Before
	public void beforeEach() {
		System.out.println("some setup can be done before each test");
	}
	
	@Test
	public void modulusTest1() {
		
		when(calc.subtract(11, 5)).thenReturn(6d);
		when(calc.subtract(6, 5)).thenReturn(1d);
		when(calc.multiply(1, 1)).thenReturn(1d);
		double result = mathApp.modulus(11, 5);
		
		Assert.assertEquals(1, result, 0.0);
	}
	
	@Test
	public void modulusTest2() {
		
		when(calc.subtract(11, 5)).thenReturn(6d);
		when(calc.subtract(6, 5)).thenReturn(1d);
		when(calc.multiply(1, -1)).thenReturn(-1d);
		
		double result = mathApp.modulus(-11, -5);
		
		Assert.assertEquals(-1, result, 0.0);
	}
}

package com.sample;

import org.testng.annotations.Test;

public class Employee {
	@Test(priority=3)
	private void test3() {
	}
	
	@Test(priority=-3)
	private void test8() {
	
	}
	
	@Test(priority=-2)
	private void test1() {
		
	}
	
	@Test(priority=7)
	private void test7() {
		
	}
		
}

package com.sample;

import org.testng.annotations.Test;

public class Company {
	@Test(priority=5)
	private void test3() {
	}
	
	@Test(priority=1)
	private void test4() {
	
	}
	
	@Test(priority=-2)
	private void test1() {
		
	}
	
	@Test(priority=-4)
	private void test7() {
		
	}
		
	
}

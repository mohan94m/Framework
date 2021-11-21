package org.practice;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ExecuteAll {
	@Test
	public void test() {
          JUnitCore.runClasses(Adactin.class,Facebook.class);
	
	}

}

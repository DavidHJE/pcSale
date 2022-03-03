package com.cda.pc.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cda.pc.HelloController;

public class HelloControllerTest {

	@Test
	void hello() {
		HelloController controller = new HelloController();
		String response = controller.hello("david");
		assertEquals("Hello, david", response);
	}
	
}

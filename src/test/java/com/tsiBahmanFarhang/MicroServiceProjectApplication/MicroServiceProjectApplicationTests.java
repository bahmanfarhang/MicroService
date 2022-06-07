package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest

class MicroServiceProjectApplicationTests {
	MicroServiceProjectApplication actorRepository;
	@Autowired
	@Test
	//"PENELOPE" is a name in the database
	public void testName(){
		Assertions.assertEquals("PENELOPE", actorRepository.actorRepository.findAll());
	}


	@Test
	void contextLoads() {
	}

}

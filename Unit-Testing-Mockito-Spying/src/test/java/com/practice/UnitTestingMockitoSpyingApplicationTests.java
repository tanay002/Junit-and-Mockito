package com.practice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
//@TestPropertySource(locations = "{classpath:test-configuration.properties}")
//These configuration has higher priority 
// whatever configuration is in here override all
// the other configuration which is made to run this application
class UnitTestingMockitoSpyingApplicationTests {

	@Test
	void contextLoads() {
	}

}

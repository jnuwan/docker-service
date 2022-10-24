package com.synclones.dockerservice;


import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class DockerServiceApplicationTests {

	public static Logger logger = LoggerFactory.getLogger(DockerServiceApplicationTests.class);
	
	@Test
	void contextLoads() {
		Assert.state(true);
	}

}

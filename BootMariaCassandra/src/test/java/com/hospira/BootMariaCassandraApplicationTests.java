package com.hospira;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.demo.BootMariaCassandraApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootMariaCassandraApplication.class)
@WebAppConfiguration
public class BootMariaCassandraApplicationTests {

	@Test
	public void contextLoads() {
	}

}

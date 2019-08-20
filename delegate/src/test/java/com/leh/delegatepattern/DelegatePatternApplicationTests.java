package com.leh.delegatepattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DelegatePatternApplicationTests {

	@Test
	public void contextLoads() throws InterruptedException {

		System.out.println(Math.abs("uipipi".hashCode()) % 3);
		System.out.println(Math.abs("hghdf;g;djg".hashCode()) % 3);
		System.out.println(Math.abs("nhgnghn".hashCode()) % 3);
		Thread t = new Thread();
		t.join(10000);
	}

}

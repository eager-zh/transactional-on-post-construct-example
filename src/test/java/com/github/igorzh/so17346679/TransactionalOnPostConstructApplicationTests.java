package com.github.igorzh.so17346679;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.igorzh.so17346679.service.TransactionalOnPostConstructService;

@SpringBootTest
public class TransactionalOnPostConstructApplicationTests {
	
	@Autowired
	private TransactionalOnPostConstructService transactionalOnPostConstructService;

	@Test
	public void transactionalOnPostConstruct() {
		assertThat(transactionalOnPostConstructService.isExecutedInsideTransaction()).isTrue();
	}

}

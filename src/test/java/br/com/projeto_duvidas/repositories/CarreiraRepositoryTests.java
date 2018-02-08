package br.com.projeto_duvidas.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class CarreiraRepositoryTests {
	
	@Autowired CarreiraRepository repository;
	@Before
	public void Before() {}
	
	@Test
	public void countExample() {
		
		
	}
}

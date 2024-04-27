package com.apu.mongodemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthorTest {

	@Autowired private AuthorRepository repository;
	@Autowired private QueryRepository repository2;

	@Test
	void contextLoads() {
	}

	@Test void simpleQuery(){
		var a2 = repository.findNameAndExcludeId("F. Scott Fitzgerald");
		System.out.println(a2);
		var a3 = repository2.getAuthors("^F");
		System.out.println(a3);
		var a4 = repository2.getAuthors(1800, 1900);
		System.out.println(a4);
	}

}

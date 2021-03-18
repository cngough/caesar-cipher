package uk.chrisgough.caesercipher;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.chrisgough.caesarcipher.controller.DecryptController;

@SpringBootTest
class CaesarCipherApplicationTests {

	@Autowired
	private DecryptController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}

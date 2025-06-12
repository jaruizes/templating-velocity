package com.jaruiz.velocity.demo;

import java.util.Map;

import com.jaruiz.velocity.demo.services.TemplateService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TemplateEngineTests {

	private static final Logger logger = LoggerFactory.getLogger(TemplateEngineTests.class);

	@Autowired TemplateService templateService;

	@Test
	void template1Test() {
		String resultado = templateService.renderTemplate("template1.vm", generateData());

		assertNotNull(resultado);
		assertFalse(resultado.isEmpty());

		logger.info(resultado);
	}

	@Test
	void template2Test() {
		String resultado = templateService.renderTemplate("template2.vm", generateData());

		assertNotNull(resultado);
		assertFalse(resultado.isEmpty());

		logger.info(resultado);
	}

	@Test
	void template3Test() {
		String resultado = templateService.renderTemplate("template3.vm", generateData());

		assertNotNull(resultado);
		assertFalse(resultado.isEmpty());

		logger.info(resultado);
	}

	private Map<String, Object> generateData() {
		return Map.of(
			"nombre", "Pepe",
			"empresa", "Empresa líder en sector",
			"rol", "Arquitecto de Software",
			"departamento", "Desarrollo"
		);
	}

}

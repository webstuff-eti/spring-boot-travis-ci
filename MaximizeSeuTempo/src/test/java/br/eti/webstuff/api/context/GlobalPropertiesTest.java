package br.eti.webstuff.api.context;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class GlobalPropertiesTest {
	
	private static final String EMAIL = "tibaestiago@gmail.com";
	
	 @Autowired
	 private GlobalProperties  globalProperties;

	
	
	@Test
	public void verificaValorDosAtributosDeAcordoComValoresDoArquivoDePropriedades () {
		
		if( globalProperties.getEmail().equals("tibaestiago@gmail.com")) {
			Assert.assertEquals(EMAIL, globalProperties.getEmail());
			log.info("Testando buscar variaveis do arquivo global.properties: SUCCESS");
			
		}
		
	}

}

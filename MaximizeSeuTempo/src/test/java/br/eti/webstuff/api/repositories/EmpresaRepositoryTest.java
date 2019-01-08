package br.eti.webstuff.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.eti.webstuff.api.entities.Empresa;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {
	
	@Autowired
	private EmpresaRepository repository;
	
	private static final String CNPJ = "33637290000138";
	
	@Before
	public void setUp() throws Exception {
		Empresa empresa = new Empresa();
		empresa.setCnpj(CNPJ);
		empresa.setRazaoSocial("Web Stuff");
		this.repository.save(empresa);
	}
	
	@After
	public final void affterDown() {
		this.repository.deleteAll();
	}
	
	@Test
	public void buscarPorCNPJ() {
		Empresa empresa = this.repository.findByCnpj(CNPJ);
		assertEquals(CNPJ, empresa.getCnpj());
	}
}

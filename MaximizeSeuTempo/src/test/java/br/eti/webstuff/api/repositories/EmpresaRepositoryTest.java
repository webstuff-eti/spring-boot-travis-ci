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
import br.eti.webstuff.api.repositories.builder.DadosComuns;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {
	
	@Autowired
	private EmpresaRepository repository;
	
	
	@Before
	public void setUp() throws Exception {
		Empresa empresa = new Empresa();
		empresa.setCnpj(DadosComuns.getCnpj());
		empresa.setRazaoSocial(DadosComuns.getRazaoSocial());
		this.repository.save(empresa);
	}
	
	@After
	public final void affterDown() {
		this.repository.deleteAll();
	}
	
	@Test
	public void buscarPorCNPJ() {
		Empresa empresa = this.repository.findByCnpj(DadosComuns.getCnpj());
		assertEquals(DadosComuns.getCnpj(), empresa.getCnpj());
	}
}

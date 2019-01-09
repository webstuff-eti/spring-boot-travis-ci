package br.eti.webstuff.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.repositories.EmpresaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {
	
	
	@Autowired
	private EmpresaService service;
	
	@MockBean
	private EmpresaRepository repository;
	
	private static final String CNPJ = "33637290000138";
	
	
	@Before
	public void setUp() throws Exception {
		
		BDDMockito.given(this.repository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(this.repository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}
	
	
	
	@Test
	public void persistirEmpresa() {
		Empresa empresa = this.service.persistir(new Empresa());
		assertNotNull(empresa);
	}
	
	@Test
	public void buscarEmpresaPorCnpj() {
		Optional<Empresa> empresa = this.service.buscarPorCnpj(CNPJ);
		assertTrue(empresa.isPresent());
	}
	

}

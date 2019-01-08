package br.eti.webstuff.api.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.repositories.builder.DadosComuns;
import br.eti.webstuff.api.repositories.builder.EmpresaBuilder;
import br.eti.webstuff.api.repositories.builder.FuncionarioBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	private static final String EMAIL = "tibaestiago@gmail.com";

	@Before
	public void setUp() throws Exception {

		EmpresaBuilder build = new EmpresaBuilder();
		FuncionarioBuilder buildF = new FuncionarioBuilder();

		Empresa empresa = this.empresaRepository.save(build.criaEmpresa());
		this.funcionarioRepository.save(buildF.buscaFuncionarioPelaEmpresa(empresa));
	}

	@After
	public final void affterDown() {
		this.empresaRepository.deleteAll();
		this.funcionarioRepository.deleteAll();
	}

	@Test
	public void buscaFuncionararioPorEmail() {

		Funcionario funcionario = this.funcionarioRepository.findByEmail(DadosComuns.getEmail());
		assertEquals(EMAIL, funcionario.getEmail());
	}

	@Test
	public void buscaFuncionararioPorCPF() {
		Funcionario funcionario = this.funcionarioRepository.findByCpf(DadosComuns.getCpf());
		assertEquals(DadosComuns.getCpf(), funcionario.getCpf());
	}

	@Test
	public void buscaFuncionararioPoreMailOrCPF() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(DadosComuns.getCpf(),
				DadosComuns.getEmail());
		assertNotNull(funcionario);
	}

	@Test
	public void testBuscarFuncionarioPorEmailOuCpfParaEmailInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(DadosComuns.getCpf(),
				DadosComuns.getEmailInvalido());

		assertNotNull(funcionario);
	}

	@Test
	public void testBuscarFuncionarioPorEmailECpfParaCpfInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(DadosComuns.getCpfInvalido(),
				DadosComuns.getEmail());
		assertNotNull(funcionario);
	}

}

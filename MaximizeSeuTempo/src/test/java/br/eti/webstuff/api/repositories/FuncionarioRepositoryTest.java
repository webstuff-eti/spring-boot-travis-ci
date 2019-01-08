package br.eti.webstuff.api.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.security.NoSuchAlgorithmException;

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
import br.eti.webstuff.api.enumerations.TipoPerfilUsuario;
import br.eti.webstuff.api.security.PasswordSecurity;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	private static final String EMAIL = "tibaestiago@gmail.com";
	private static final String CPF = "20134865022";
	private static final String SENHA = "12345678";
	private static final String NOME = "Tiago Tibaes";

	@Before
	public void setUp() throws Exception {
		
		Empresa empresa = this.empresaRepository.save(criaEmpresa());
		this.funcionarioRepository.save(buscaFuncionarioPelaEmpresa(empresa));
	}
	
	
	@After
	public final void affterDown() {
		this.empresaRepository.deleteAll();
		this.funcionarioRepository.deleteAll(); //TODO: Testar
	}
	
	
	@Test
	public void buscaFuncionararioPorEmail() {
		
		Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);
		assertEquals(EMAIL, funcionario.getEmail());
	}
	
	@Test
	public void buscaFuncionararioPorCPF() {
		Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);
		assertEquals(CPF, funcionario.getCpf());
	}
	
	@Test
	public void buscaFuncionararioPoreMailOrCPF() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, EMAIL);
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscarFuncionarioPorEmailOuCpfParaEmailInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, "email@invalido.com");

		assertNotNull(funcionario);
	}

	@Test
	public void testBuscarFuncionarioPorEmailECpfParaCpfInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail("12345678901", EMAIL);
		assertNotNull(funcionario);
	}
	
	
	
	

	// TODO: Criar classe builder de suporte aos testes:
	private Empresa criaEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("33637290000138");
		empresa.setRazaoSocial("Web Stuff");
		return empresa;
	}
	
	private Funcionario buscaFuncionarioPelaEmpresa(Empresa empresa) throws NoSuchAlgorithmException {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(NOME);
		funcionario.setPerfil(TipoPerfilUsuario.ROLE_USUARIO);
		funcionario.setSenha(PasswordSecurity.gerarBCrypt(SENHA));
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setEmpresa(empresa);
		return funcionario;
	}

}

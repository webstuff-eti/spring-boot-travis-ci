package br.eti.webstuff.api.repositories;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.entities.Lancamento;
import br.eti.webstuff.api.repositories.builder.EmpresaBuilder;
import br.eti.webstuff.api.repositories.builder.FuncionarioBuilder;
import br.eti.webstuff.api.repositories.builder.LancamentosBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private Long funcionarioId;
	
	
	@Before
	public void setUp() throws NoSuchAlgorithmException {
		
		EmpresaBuilder builder = new EmpresaBuilder();
		FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
		LancamentosBuilder  lancamentosBuilder = new LancamentosBuilder();
		
		Empresa empresa = empresaRepository.save(builder.criaEmpresa());
		
		Funcionario funcionario = funcionarioRepository.save(funcionarioBuilder.buscaFuncionarioPelaEmpresa(empresa));
		this.funcionarioId = funcionario.getId();
	
		this.lancamentoRepository.save(lancamentosBuilder.obterDadosLancamentos(funcionario));
		this.lancamentoRepository.save(lancamentosBuilder.obterDadosLancamentos(funcionario));
	}
	
	@After
	public void tearDown() throws Exception {
		this.empresaRepository.deleteAll();
		this.funcionarioRepository.deleteAll();
		this.lancamentoRepository.deleteAll();
	}
	
	
	@Test
	public void buscaLancamentosPeloIdDoFuncionario() {
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId);
		assertEquals(2, lancamentos.size());
	}
	
	
	@Test
	public void buscaLancamentosPeloIdDoFuncionarioComPaginas() {
		PageRequest page = new PageRequest(0, 10);
		Page<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId, page);
		assertEquals(2, lancamentos.getTotalElements());
	}
	
}

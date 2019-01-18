package br.eti.webstuff.api.web.controller.funcionario;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.validation.Valid;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.service.EmpresaService;
import br.eti.webstuff.api.service.FuncionarioService;
import br.eti.webstuff.api.web.controller.funcionario.converters.ConverterPessoaFisica;
import br.eti.webstuff.api.web.controller.funcionario.utils.IFuncionarioPessoaFisicaUtil;
import br.eti.webstuff.api.web.controller.responses.Response;
import br.eti.webstuff.api.web.dto.request.PessoaFisicaRequestDto;
import br.eti.webstuff.api.web.dto.response.PessoaFisicaResponseDto;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/pessoa/fisica")
@CrossOrigin("*")
@Slf4j
public class FuncionarioPessoaFisicaController implements IFuncionarioPessoaFisicaController, IFuncionarioPessoaFisicaUtil {
	
	//private static final Logger log = LoggerFactory.getLogger(FuncionarioPessoaFisicaController.class);
	

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private EmpresaService empresaService;
	
	public FuncionarioPessoaFisicaController() {
		
	}
	
	
   /**
	* Cadastra um funcionário pessoa física no sistema.
	* 
	* @param cadastroPFDto
	* @param result
	* @return ResponseEntity<Response<PessoaFisicaResponseDto>>
	* @throws NoSuchAlgorithmException
	*/
	@PostMapping
	@Override
	public ResponseEntity<Response<PessoaFisicaResponseDto>> cadastrarPessoaFisica(@Valid @RequestBody
			PessoaFisicaRequestDto pessoaFisicaRequestDto, BindingResult result) throws NoSuchAlgorithmException {
		
		log.info("Cadastro de Pessoa Física", pessoaFisicaRequestDto.toString());
	
		
		Response<PessoaFisicaResponseDto> response = new Response<PessoaFisicaResponseDto>();
		ConverterPessoaFisica convertePessoaFisica = new ConverterPessoaFisica();
		
		validarExistenciaDoFuncionarioPessoaFisicaParaCadastro(pessoaFisicaRequestDto, result);
		
		
		Funcionario funcionario = convertePessoaFisica.converterPessoaFisicaRequestDtoParaFuncionario(pessoaFisicaRequestDto, result);
		
		
		if(result.hasErrors()) {
			log.error("Erro ao validar dados de Pessoa Física: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(pessoaFisicaRequestDto.getCnpj());
		empresa.ifPresent(emp -> funcionario.setEmpresa(emp));
		this.funcionarioService.persistir(funcionario);
		
		response.setData(convertePessoaFisica.converterCadastroPFDto(funcionario));
		
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Response<PessoaFisicaResponseDto>> buscarPorCpf(@PathVariable("cpf") String documento) {  
		
		return null;
	}

	@Override
	public ResponseEntity<Response<PessoaFisicaResponseDto>> atualizarPessoaFisicaById(Long id, @Valid @RequestBody
			PessoaFisicaRequestDto pessoaFisicaRequestDto, BindingResult result) throws NoSuchAlgorithmException {
		
		return null;
	}


	@Override
	public void atualizaDadosFuncionarioPessoaFisica(Funcionario funcionario,
			@Valid @RequestBody PessoaFisicaRequestDto pessoaFisicaRequestDto, BindingResult result) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void validarExistenciaDoFuncionarioPessoaFisicaParaCadastro(PessoaFisicaRequestDto pessoaFisicaRequestDto,
			BindingResult result) {
		
		Optional<Empresa> empresa =  this.empresaService.buscarPorCnpj(pessoaFisicaRequestDto.getCnpj());
		
		if(!empresa.isPresent()) {
			result.addError(new ObjectError("empresa", "Empresa não cadastrada"));
		}
		this.funcionarioService.buscarPorCpf(pessoaFisicaRequestDto.getCpf())
				.ifPresent(func -> result.addError(new ObjectError("funcionario", "CPF já cadastrado")));
		this.funcionarioService.buscarPorEmail(pessoaFisicaRequestDto.getEmail())
				.ifPresent(func -> result.addError(new ObjectError("funcionario", "Email já cadastrado")));
	}


	@Override
	public void validarExistenciaDoFuncionarioPessoaFisicaParaAtualizacao(PessoaFisicaRequestDto pessoaFisicaRequestDto,
			BindingResult result) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	

}

package br.eti.webstuff.api.web.controller.funcionario;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.service.EmpresaService;
import br.eti.webstuff.api.service.FuncionarioService;
import br.eti.webstuff.api.web.controller.empresa.converters.ConverteEmpresa;
import br.eti.webstuff.api.web.controller.funcionario.converters.ConverterPessoaJuridica;
import br.eti.webstuff.api.web.controller.funcionario.utils.IFuncionarioPessoaJuridicaUtil;
import br.eti.webstuff.api.web.controller.responses.Response;
import br.eti.webstuff.api.web.dto.request.EmpresaRequestDto;
import br.eti.webstuff.api.web.dto.request.PessoaJuridicaRequestDto;
import br.eti.webstuff.api.web.dto.response.PessoaJuridicaResponseDto;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/pessoa/juridica")
@CrossOrigin("*")
@Slf4j
public class FuncionarioPessoaJuridicaController
		implements IFuncionarioPessoaJuridicaController, IFuncionarioPessoaJuridicaUtil {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private EmpresaService empresaService;

	public FuncionarioPessoaJuridicaController() {

	}

	

	/**
	 * Cadastra um funcionário pessoa Jurídica.
	 * 
	 * @param pessoaJuridicaRequestDto
	 * @param result
	 * @return ResponseEntity<Response<PessoaJuridicaResponseDto>>
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping
	@Override
	public ResponseEntity<Response<PessoaJuridicaResponseDto>> cadastrarPessoaJuridica(
			@Valid @RequestBody PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result)
			throws NoSuchAlgorithmException {

		log.info("Cadastro de Pessoa Jurídica", pessoaJuridicaRequestDto.toString());

		EmpresaRequestDto empresaDto = null;
		ConverteEmpresa converteEmpresa = null;
		Empresa empresa = null;
		ConverterPessoaJuridica converterPessoaJuridica = null;

		Response<PessoaJuridicaResponseDto> response = new Response<PessoaJuridicaResponseDto>();

		validarExistenciaDoFuncionarioPessoaJuridicaParaCadastro(pessoaJuridicaRequestDto, result);

		if (pessoaJuridicaRequestDto != null) {
			empresaDto = new EmpresaRequestDto();
			empresaDto.setCnpj(pessoaJuridicaRequestDto.getCnpj());
			empresaDto.setRazaoSocial(pessoaJuridicaRequestDto.getRazaoSocial());
		}

		if (empresaDto != null) {
			empresa = new Empresa();
			converteEmpresa = new ConverteEmpresa();
			empresa = converteEmpresa.converteEmpresaRequestDtoParaEmpresa(empresaDto);
		}

		converterPessoaJuridica = new ConverterPessoaJuridica();

		Funcionario funcionario = converterPessoaJuridica
				.converterPessoaJuridicaRequestDtoParaFuncionario(pessoaJuridicaRequestDto, result);

		if (result.hasErrors()) {
			log.error("Erro ao validar dados de cadastro de Pessoa Jurídica: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		this.empresaService.persistir(empresa);
		funcionario.setEmpresa(empresa);
		this.funcionarioService.persistir(funcionario);

		response.setData(converterPessoaJuridica.converterCadastroPFDto(funcionario));  
		return ResponseEntity.ok(response);
	}

	

	@Override
	public void validarExistenciaDoFuncionarioPessoaJuridicaParaCadastro(
			PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result) {

		this.empresaService.buscarPorCnpj(pessoaJuridicaRequestDto.getCnpj())
				.ifPresent(emp -> result.addError(new ObjectError("empresa", "Empresa já existe.")));
		this.funcionarioService.buscarPorCpf(pessoaJuridicaRequestDto.getCpf())
				.ifPresent(func -> result.addError(new ObjectError("funcionário", "Funcionário já existe.")));
		this.funcionarioService.buscarPorEmail(pessoaJuridicaRequestDto.getEmail())
				.ifPresent(func -> result.addError(new ObjectError("funcionário", "E-mail já existe.")));
	}
	
	
	
	@Override
	public ResponseEntity<Response<PessoaJuridicaResponseDto>> buscarPorCpf(String documento) {

		return null;
	}
	
	@Override
	public void atualizaDadosFuncionarioPessoaJuridica(Funcionario funcionario,
			PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result) throws NoSuchAlgorithmException {

	}

	@Override
	public ResponseEntity<Response<PessoaJuridicaResponseDto>> atualizarPessoaJuridicaById(Long id,
			PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result) throws NoSuchAlgorithmException {

		return null;
	}

	@Override
	public void validarExistenciaDoFuncionarioPessoaJuridicaParaAtualizacao(
			PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result) {

	}

}

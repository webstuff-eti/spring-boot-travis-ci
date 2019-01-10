package br.eti.webstuff.api.web.controller.empresa;


import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.security.NoSuchAlgorithmException;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.service.EmpresaService;
import br.eti.webstuff.api.web.controller.empresa.converters.ConverteEmpresa;
import br.eti.webstuff.api.web.controller.empresa.utils.IEmpresaUtils;
import br.eti.webstuff.api.web.controller.responses.Response;
import br.eti.webstuff.api.web.dto.EmpresaDto;



@RestController
@RequestMapping("/api/empresa")
@CrossOrigin(origins = "*")
public class EmpresaController  implements IEmpresaController, IEmpresaUtils { 

	private static final Logger log = LoggerFactory.getLogger(EmpresaController.class);

	@Autowired
	private EmpresaService empresaService;

	public EmpresaController() {

	}

	/**
	 * Dado um CNPJ, retorna uma empresa.
	 * 
	 * @param cnpj
	 * @return ResponseEntity<Response<EmpresaDto>>
	 */
	@GetMapping(value = "/cnpj/{cnpj}")
	@Override
	public ResponseEntity<Response<EmpresaDto>> buscarPorCnpj(@PathVariable("cnpj") String cnpj) {

		log.info("Dado um valor de CNPJ, retorna uma empresa", cnpj);

		Response<EmpresaDto> response = new Response<EmpresaDto>();

		Optional<Empresa> empresa = empresaService.buscarPorCnpj(cnpj);

		ConverteEmpresa conversor = new ConverteEmpresa();

		if (!empresa.isPresent()) {
			log.info("Não há empresa cadastrada com o CNPJ informado: {} ", cnpj);
			response.getErrors().add("Não há empresa cadastrada com o CNPJ informado: {} " + cnpj);

			return ResponseEntity.badRequest().body(response);
		}

		response.setData(conversor.converteEmpresaParaEmpresaDto(empresa.get()));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Cadastra uma empresa
	 * 
	 * @param empresaDto
	 * @param result
	 * @return ResponseEntity<Response<EmpresaDto>>
	 * @throws NoSuchAlgorithmException
	 */

	@PostMapping
	@Override
	public ResponseEntity<Response<EmpresaDto>> cadastrar(@Valid @RequestBody EmpresaDto empresaDto, BindingResult result)
			throws NoSuchAlgorithmException {
		
		log.info("Cadastra uma empresa: {}", empresaDto.toString());
		
		Response<EmpresaDto> response = new Response<EmpresaDto>();
		ConverteEmpresa converte = new ConverteEmpresa();
		
		validarExistenciaDaEmpresaParaCadastro(empresaDto, result);
		
		Empresa empr = converte.converteEmpresaDtoParaEmpresa(empresaDto);
		
		if(result.hasErrors()) {
			log.error("Erro de validação de dados da empresa a ser cadastrada", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Empresa empresa = this.empresaService.persistir(empr);
		
		response.setData(converte.converteEmpresaParaEmpresaDto(empresa));
		
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Response<EmpresaDto>> atualizaEmpresaById(Long id, EmpresaDto empresaDto,
			BindingResult result) throws NoSuchAlgorithmException {
		
		return null;
	}

	
	@Override
	public void atualizaDadosEmpresa(Empresa empresa, EmpresaDto empresaDto, BindingResult result)
			throws NoSuchAlgorithmException {
		

	}

	
	@Override
	public void validarExistenciaDaEmpresaParaCadastro(EmpresaDto empresaDto, BindingResult result) {

		String documento = empresaDto.getCnpj();

		if (documento != null) {

			Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(documento);
			if (empresa.isPresent()) {
				result.addError(new ObjectError("empresa", "Empresa já cadastrada."));
			}

		} else {
			result.addError(new ObjectError("empresa", "CNPJ NULO!."));
		}
	}

	
	@Override
	public void validarExistenciaDaEmpresaParaAtualizacao(EmpresaDto empresaDto, BindingResult result) {
		String documento = empresaDto.getCnpj();

		if (documento != null) {

			Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(documento);
			if (!empresa.isPresent()) {
				result.addError(new ObjectError("empresa", "Empresa não cadastrada."));
			}

		} else {
			result.addError(new ObjectError("empresa", "CNPJ NULO!."));
		}

	}
	
	
	
	//FIXME: Teste
	@GetMapping(value = "/teste")
	public String arquitetura() {
		log.info("Testando Verbo GET: SUCESSO!");
		 return "Testando Verbo GET: SUCESSO!";
	}

}

package br.eti.webstuff.api.web.controller.funcionario;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.eti.webstuff.api.web.controller.responses.Response;
import br.eti.webstuff.api.web.dto.request.EmpresaRequestDto;
import br.eti.webstuff.api.web.dto.request.PessoaFisicaRequestDto;
import br.eti.webstuff.api.web.dto.response.EmpresaResponseDto;
import br.eti.webstuff.api.web.dto.response.PessoaFisicaResponseDto;

public interface IFuncionarioPessoaFisicaController {
	
	
	public ResponseEntity<Response<PessoaFisicaResponseDto>> cadastrarPessoaFisica(@Valid @RequestBody PessoaFisicaRequestDto pessoaFisicaRequestDto,
			BindingResult result) throws NoSuchAlgorithmException;
	
	public ResponseEntity<Response<PessoaFisicaResponseDto>> buscarPorCpf(@PathVariable("cpf") String documento);
	
	
	public ResponseEntity<Response<PessoaFisicaResponseDto>> atualizarPessoaFisicaById(@PathVariable("id") Long id,
			@Valid @RequestBody PessoaFisicaRequestDto pessoaFisicaRequestDto, BindingResult result) throws NoSuchAlgorithmException;

}

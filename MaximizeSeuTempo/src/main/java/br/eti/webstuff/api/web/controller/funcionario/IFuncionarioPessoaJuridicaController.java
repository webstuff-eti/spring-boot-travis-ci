package br.eti.webstuff.api.web.controller.funcionario;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.eti.webstuff.api.web.controller.responses.Response;
import br.eti.webstuff.api.web.dto.request.PessoaJuridicaRequestDto;
import br.eti.webstuff.api.web.dto.response.PessoaJuridicaResponseDto;

public interface IFuncionarioPessoaJuridicaController {
	
	public ResponseEntity<Response<PessoaJuridicaResponseDto>> cadastrarPessoaFisica(@Valid @RequestBody PessoaJuridicaRequestDto pessoaJuridicaRequestDto,
			BindingResult result) throws NoSuchAlgorithmException;
	
	public ResponseEntity<Response<PessoaJuridicaResponseDto>> buscarPorCpf(@PathVariable("cpf") String documento);
	
	
	public ResponseEntity<Response<PessoaJuridicaResponseDto>> atualizarPessoaFisicaById(@PathVariable("id") Long id,
			@Valid @RequestBody PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result) throws NoSuchAlgorithmException;

}

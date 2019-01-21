package br.eti.webstuff.api.web.controller.funcionario.utils;

import java.security.NoSuchAlgorithmException;

import org.springframework.validation.BindingResult;

import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.web.dto.request.PessoaJuridicaRequestDto;


public interface IFuncionarioPessoaJuridicaUtil {
	
	
	public void atualizaDadosFuncionarioPessoaJuridica(Funcionario funcionario, PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result)
			throws NoSuchAlgorithmException;

	public void validarExistenciaDoFuncionarioPessoaJuridicaParaCadastro(PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result);

	public void validarExistenciaDoFuncionarioPessoaJuridicaParaAtualizacao(PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result);

}

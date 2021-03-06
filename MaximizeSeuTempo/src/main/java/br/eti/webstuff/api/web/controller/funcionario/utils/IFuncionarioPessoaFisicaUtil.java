package br.eti.webstuff.api.web.controller.funcionario.utils;

import java.security.NoSuchAlgorithmException;

import org.springframework.validation.BindingResult;

import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.web.dto.request.PessoaFisicaRequestDto;


public interface IFuncionarioPessoaFisicaUtil {
	
	public void atualizaDadosFuncionarioPessoaFisica(Funcionario funcionario, PessoaFisicaRequestDto pessoaFisicaRequestDto, BindingResult result)
			throws NoSuchAlgorithmException;

	public void validarExistenciaDoFuncionarioPessoaFisicaParaCadastro(PessoaFisicaRequestDto pessoaFisicaRequestDto, BindingResult result);

	public void validarExistenciaDoFuncionarioPessoaFisicaParaAtualizacao(PessoaFisicaRequestDto pessoaFisicaRequestDto, BindingResult result);

}

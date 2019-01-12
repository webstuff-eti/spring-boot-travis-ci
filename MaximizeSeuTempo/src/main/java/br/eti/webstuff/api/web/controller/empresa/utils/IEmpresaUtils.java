package br.eti.webstuff.api.web.controller.empresa.utils;

import java.security.NoSuchAlgorithmException;

import org.springframework.validation.BindingResult;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.web.dto.request.EmpresaRequestDto;
import br.eti.webstuff.api.web.dto.response.EmpresaResponseDto;

public interface IEmpresaUtils {

	public void atualizaDadosEmpresa(Empresa empresa, EmpresaRequestDto empresaRequestDto, BindingResult result)
			throws NoSuchAlgorithmException;

	public void validarExistenciaDaEmpresaParaCadastro(EmpresaRequestDto empresaRequestDto, BindingResult result);

	public void validarExistenciaDaEmpresaParaAtualizacao(EmpresaRequestDto empresaRequestDto, BindingResult result);

}

package br.eti.webstuff.api.web.controller.empresa.utils;

import java.security.NoSuchAlgorithmException;

import org.springframework.validation.BindingResult;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.web.dto.EmpresaDto;

public interface IEmpresaUtils {

	public void atualizaDadosEmpresa(Empresa empresa, EmpresaDto empresaDto, BindingResult result)
			throws NoSuchAlgorithmException;

	public void validarExistenciaDaEmpresaParaCadastro(EmpresaDto empresaDto, BindingResult result);

	public void validarExistenciaDaEmpresaParaAtualizacao(EmpresaDto empresaDto, BindingResult result);

}

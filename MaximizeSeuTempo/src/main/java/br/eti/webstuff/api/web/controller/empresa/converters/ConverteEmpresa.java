package br.eti.webstuff.api.web.controller.empresa.converters;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.web.dto.EmpresaDto;

public class ConverteEmpresa {
	
	/**
	 * Converte Empresa para EmpresaDto.
	 * 
	 * @param empresa
	 * 
	 * @return EmpresaDto
	 */
	 public EmpresaDto converteEmpresaParaEmpresaDto(Empresa empresa) {
		
		EmpresaDto empresaDto = new EmpresaDto();
		
		if(empresa != null) {
			empresaDto.setId(empresa.getId());
			empresaDto.setCnpj(empresa.getCnpj());
			empresaDto.setRazaoSocial(empresa.getRazaoSocial());
		}
		return empresaDto;
	}
	 
	 /**
		 * Converte EmpresaDto para Empresa.
		 * 
		 * @param EmpresaDto
		 *
		 * @return empresa
		 */
	public Empresa converteEmpresaDtoParaEmpresa(EmpresaDto empresaDto) {
		
		Empresa empresa = new Empresa();
		
		empresa.setCnpj(empresaDto.getCnpj());
		empresa.setRazaoSocial(empresaDto.getRazaoSocial());
		if(empresaDto.getId() != null) {
			empresa.setId(empresaDto.getId());
		}
		return empresa;
	}
	
	
	
	

}

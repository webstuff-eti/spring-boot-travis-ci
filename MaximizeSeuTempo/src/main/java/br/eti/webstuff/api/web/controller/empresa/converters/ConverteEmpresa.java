package br.eti.webstuff.api.web.controller.empresa.converters;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.web.dto.EmpresaDto;

public class ConverteEmpresa {
	
	/**
	 * Converte Converte Empresa para EmpresaDto.
	 * 
	 * @param empresa
	 * @return 
	 * @return EmpresaDto
	 */
	 public EmpresaDto converteEmpresaParaEmpresaDto(Empresa empresa) {
		
		EmpresaDto empresaDto = new EmpresaDto();
		empresaDto.setId(empresa.getId());
		empresaDto.setCnpj(empresa.getCnpj());
		empresaDto.setRazaoSocial(empresa.getRazaoSocial());

		return empresaDto;
	}
	
	
	
	

}

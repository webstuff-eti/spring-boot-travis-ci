package br.eti.webstuff.api.web.dto.converters;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.web.dto.EmpresaDto;

public class ConverterObjectToDto {
	
	
	
	/**
	 * Preenche EmpresaDto com os dados de uma empresa recebida por parâmetro.
	 * 
	 * @param  empresa
	 * @return EmpresaDto
	 */
	private EmpresaDto converterEmpresaDto(Empresa empresa) {
		EmpresaDto empresaDto = new EmpresaDto();
		empresaDto.setId(empresa.getId());
		empresaDto.setCnpj(empresa.getCnpj());
		empresaDto.setRazaoSocial(empresa.getRazaoSocial());

		return empresaDto;
	}

}

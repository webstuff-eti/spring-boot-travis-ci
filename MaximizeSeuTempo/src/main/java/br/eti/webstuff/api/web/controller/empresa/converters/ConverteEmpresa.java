package br.eti.webstuff.api.web.controller.empresa.converters;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.web.dto.request.EmpresaRequestDto;
import br.eti.webstuff.api.web.dto.response.EmpresaResponseDto;

public class ConverteEmpresa {
	
	/**
	 * Converte Empresa para EmpresaDto.
	 * 
	 * @param empresa
	 * 
	 * @return EmpresaDto
	 */
	 public EmpresaResponseDto converteEmpresaParaEmpresaResponseDto(Empresa empresa) {
		
		 EmpresaResponseDto empresaResponseDto = new EmpresaResponseDto();
		
		if(empresa != null) {
			empresaResponseDto.setId(empresa.getId());
			empresaResponseDto.setCnpj(empresa.getCnpj());
			empresaResponseDto.setRazaoSocial(empresa.getRazaoSocial());
		}
		return empresaResponseDto;
	}
	 
	 /**
		 * Converte EmpresaDto para Empresa.
		 * 
		 * @param EmpresaDto
		 *
		 * @return empresa
		 */
	public Empresa converteEmpresaRequestDtoParaEmpresa(EmpresaRequestDto empresaRequestDto) {
		
		Empresa empresa = new Empresa();
		
		empresa.setCnpj(empresaRequestDto.getCnpj());
		empresa.setRazaoSocial(empresaRequestDto.getRazaoSocial());
		
		return empresa;
	}
	
	
	
	

}

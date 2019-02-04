package br.eti.webstuff.api.repositories.builder;

import br.eti.webstuff.api.entities.Empresa;

public class EmpresaBuilder {
	
	
	public Empresa criaEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("33637290000138");
		empresa.setRazaoSocial("Web Stuff");
		return empresa;
	}
	
	public static Empresa obterEmpresa() {
		
		Empresa empresa = new Empresa();
		
		empresa.setId(DadosComuns.ID);
		empresa.setRazaoSocial(DadosComuns.RAZAO_SOCIAL_ADV);
		empresa.setCnpj(DadosComuns.CNPJ_ADV);
		
        return empresa;		
	}

}

package br.eti.webstuff.api.repositories.builder;

import br.eti.webstuff.api.entities.Empresa;

public class EmpresaBuilder {
	
	
	public Empresa criaEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("33637290000138");
		empresa.setRazaoSocial("Web Stuff");
		return empresa;
	}

}

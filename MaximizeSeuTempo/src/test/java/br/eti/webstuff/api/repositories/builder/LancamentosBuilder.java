package br.eti.webstuff.api.repositories.builder;

import java.util.Date;

import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.entities.Lancamento;
import br.eti.webstuff.api.enumerations.TipoEnum;

public class LancamentosBuilder {
	
	public Lancamento obterDadosLancamentos(Funcionario funcionario) {
		
		Lancamento lancameto = new Lancamento();
		
		lancameto.setData(new Date());
		lancameto.setTipo(TipoEnum.INICIO_ALMOCO);
		lancameto.setFuncionario(funcionario);
		return lancameto;
	}

}

package br.eti.webstuff.api.repositories.builder;

import java.security.NoSuchAlgorithmException;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.enumerations.TipoPerfilUsuario;
import br.eti.webstuff.api.security.PasswordSecurity;

public class FuncionarioBuilder {

	private static final String NOME = "Tiago Tibaes";

	public Funcionario buscaFuncionarioPelaEmpresa(Empresa empresa) throws NoSuchAlgorithmException {

		Funcionario funcionario = new Funcionario();
		funcionario.setNome(NOME);
		funcionario.setPerfil(TipoPerfilUsuario.ROLE_USUARIO);
		//funcionario.setSenha(PasswordSecurity.gerarBCrypt(DadosComuns.getSenha()));
		funcionario.setSenha("12312432423432423");
		funcionario.setCpf(DadosComuns.getCpf());
		funcionario.setEmail(DadosComuns.getEmail());
		funcionario.setEmpresa(empresa);
		return funcionario;
	}

}

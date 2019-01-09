package br.eti.webstuff.api.service;

import java.util.Optional;

import br.eti.webstuff.api.entities.Funcionario;

public interface FuncionarioService {

	Funcionario persistir(Funcionario funcionario);

	Optional<Funcionario> buscarPorCpf(String cpf);

	Optional<Funcionario> buscarPorEmail(String email);

	Optional<Funcionario> buscarPorId(Long id);

}

package br.eti.webstuff.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.repositories.FuncionarioRepository;
import br.eti.webstuff.api.service.FuncionarioService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private FuncionarioRepository  funcionarioRepository;
	
	

	@Override
	public Funcionario persistir(Funcionario funcionario) {
		log.info("Persistindo Funcionário: {}", funcionario);
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		log.info("Buscando funcionário pelo CPF {}", cpf);
		return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
	}

	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		log.info("Buscando funcionário pelo email {}", email);
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
	}

	@Override
	public Optional<Funcionario> buscarPorId(Long id) {
		log.info("Buscando funcionário pelo IDl {}", id);
		return Optional.ofNullable(this.funcionarioRepository.findOne(id));
	}

}

package br.eti.webstuff.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.eti.webstuff.api.entities.Lancamento;
import br.eti.webstuff.api.repositories.LancamentoRepository;
import br.eti.webstuff.api.service.LancamentoService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LancamentoServiceImpl implements LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Buscando lançamentos para o funcionário com ID {}", funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	@Override
	public Optional<Lancamento> buscarPorId(Long id) {
		log.info("Buscando um lançamento pelo ID {}", id);
		return Optional.ofNullable(this.lancamentoRepository.findOne(id));
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persistindo o lançamento: {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		log.info("Excluindo o lançamento ID {}", id);
		this.lancamentoRepository.delete(id);
	}

}

package br.eti.webstuff.api.web.dto;

import java.util.Optional;

import org.hibernate.validator.constraints.NotEmpty;

public class LancamentoDto {

	private Optional<Long> id = Optional.empty();

	@NotEmpty(message = "Data não pode ser vazia.")
	private String data;

	private String tipo;
	private String descricao;
	private String localizacao;
	private Long funcionarioId;

	public LancamentoDto() {

	}

	@Override
	public String toString() {
		return "LancamentoDto [id=" + id + ", data=" + data + ", tipo=" + tipo + ", descricao=" + descricao
				+ ", localizacao=" + localizacao + ", funcionarioId=" + funcionarioId + "]";
	}

}

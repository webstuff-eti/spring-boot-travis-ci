package br.eti.webstuff.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "empresa")
@Data
@ToString
public class Empresa implements Serializable {

	private static final long serialVersionUID = 7382917350137342982L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String razaoSocial;
	private String cnpj;

	public Empresa() {

	}

	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;

	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;

	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Funcionario> funcionarios;

	
	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getRazaoSocial() {
//		return razaoSocial;
//	}
//
//	public void setRazaoSocial(String razaoSocial) {
//		this.razaoSocial = razaoSocial;
//	}
//
//	public String getCnpj() {
//		return cnpj;
//	}
//
//	public void setCnpj(String cnpj) {
//		this.cnpj = cnpj;
//	}
//
//	public Date getDataCriacao() {
//		return dataCriacao;
//	}
//
//	public void setDataCriacao(Date dataCriacao) {
//		this.dataCriacao = dataCriacao;
//	}
//
//	public Date getDataAtualizacao() {
//		return dataAtualizacao;
//	}
//
//	public void setDataAtualizacao(Date dataAtualizacao) {
//		this.dataAtualizacao = dataAtualizacao;
//	}
//
//	public List<Funcionario> getFuncionarios() {
//		return funcionarios;
//	}
//
//	public void setFuncionarios(List<Funcionario> funcionarios) {
//		this.funcionarios = funcionarios;
//	}
//
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
//
//	@Override
//	public String toString() {
//		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao
//				+ ", dataAtualizacao=" + dataAtualizacao + ", funcionarios=" + funcionarios + "]";
//	}

}

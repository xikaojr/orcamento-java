package team.java.domain;

import java.sql.Date;

public class Requisicao {
	
	private Long Id;
	private Long DepartamentoId;
	private Long FuncionarioLancadorId;
	private Long FuncionarioAprovadorId;
	private Integer Numero;
	private Date DataRequisicao;
	private Date DataAprovacao;
	private String Nome;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getDepartamentoId() {
		return DepartamentoId;
	}
	public void setDepartamentoId(Long departamentoId) {
		DepartamentoId = departamentoId;
	}
	public Long getFuncionarioLancadorId() {
		return FuncionarioLancadorId;
	}
	public void setFuncionarioLancadorId(Long funcionarioLancadorId) {
		FuncionarioLancadorId = funcionarioLancadorId;
	}
	public Long getFuncionarioAprovadorId() {
		return FuncionarioAprovadorId;
	}
	public void setFuncionarioAprovadorId(Long funcionarioAprovadorId) {
		FuncionarioAprovadorId = funcionarioAprovadorId;
	}
	public Integer getNumero() {
		return Numero;
	}
	public void setNumero(Integer numero) {
		Numero = numero;
	}
	public Date getDataRequisicao() {
		return DataRequisicao;
	}
	public void setDataRequisicao(Date dataRequisicao) {
		DataRequisicao = dataRequisicao;
	}
	public Date getDataAprovacao() {
		return DataAprovacao;
	}
	public void setDataAprovacao(Date dataAprovacao) {
		DataAprovacao = dataAprovacao;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	
}

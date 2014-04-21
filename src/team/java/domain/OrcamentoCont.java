package team.java.domain;

public class OrcamentoCont {
	
	private Long Id;
	private Long OrcamentoId;
	private Long DepartamentoId;
	private Long RubricaId;
	private Long PeriodoId;
	private Float ValorOrcado;
	private Float Saldo;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getOrcamentoId() {
		return OrcamentoId;
	}
	public void setOrcamentoId(Long orcamentoId) {
		OrcamentoId = orcamentoId;
	}
	public Long getDepartamentoId() {
		return DepartamentoId;
	}
	public void setDepartamentoId(Long departamentoId) {
		DepartamentoId = departamentoId;
	}
	public Long getRubricaId() {
		return RubricaId;
	}
	public void setRubricaId(Long rubricaId) {
		RubricaId = rubricaId;
	}
	public Long getPeriodoId() {
		return PeriodoId;
	}
	public void setPeriodoId(Long periodoId) {
		PeriodoId = periodoId;
	}
	public Float getValorOrcado() {
		return ValorOrcado;
	}
	public void setValorOrcado(Float valorOrcado) {
		ValorOrcado = valorOrcado;
	}
	public Float getSaldo() {
		return Saldo;
	}
	public void setSaldo(Float saldo) {
		Saldo = saldo;
	}
	
	
}

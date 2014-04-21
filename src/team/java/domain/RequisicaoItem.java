package team.java.domain;

public class RequisicaoItem {
	
	private Long Id;
	private Long ItemId;
	private Long RequisicaoId;
	private Float Quantidade;
	private Float Valor;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getItemId() {
		return ItemId;
	}
	public void setItemId(Long itemId) {
		ItemId = itemId;
	}
	public Long getRequisicaoId() {
		return RequisicaoId;
	}
	public void setRequisicaoId(Long requisicaoId) {
		RequisicaoId = requisicaoId;
	}
	public Float getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(Float quantidade) {
		Quantidade = quantidade;
	}
	public Float getValor() {
		return Valor;
	}
	public void setValor(Float valor) {
		Valor = valor;
	}
	
	
	
	
}

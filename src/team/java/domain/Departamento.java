package team.java.domain;

public class Departamento {
	
	private Long Id;
	private String Nome;
	private String Descricao;
	private Long Chefe_id;
	private String Chefe_Nome;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}
	
	public Long getChefeId() {
		return Chefe_id;
	}

	public void setChefeId(Long Chefe_id) {
		this.Chefe_id = Chefe_id;
	}
	
	public String getChefeNome(){
		return Chefe_Nome;
	}
	
	public void setChefeNome(String ChefeNome){
		this.Chefe_Nome = ChefeNome;
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	public String getDescricao(){
		return Descricao;
	}
	
	public void setDescricao(String Descricao){
		this.Descricao = Descricao;
	}
	
}

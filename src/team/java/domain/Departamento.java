package team.java.domain;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

public class Departamento {
	
	private Long Id;
	private String Nome;
	private Text Descricao;
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
	
	public Text getDescricao(){
		return Descricao;
	}
	
	public void setDescricao(Text Descricao){
		this.Descricao = Descricao;
	}
	
}

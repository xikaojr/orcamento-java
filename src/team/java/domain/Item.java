package team.java.domain;

public class Item {
	
	private Long Id;
	private Long RubricaId;
	private String Nome;
	private String RubricaNome;
	private String RubricaTipo;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}
	
	public Long getRubricaId() {
		return RubricaId;
	}

	public void setRubricaId(Long RubricaId) {
		this.RubricaId = RubricaId;
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getRubricaNome() {
		return RubricaNome;
	}

	public void setRubricaNome(String rubricaNome) {
		RubricaNome = rubricaNome;
	}

	public String getRubricaTipo() {
		return RubricaTipo;
	}

	public void setRubricaTipo(String rubricaTipo) {
		
		RubricaTipo = rubricaTipo;
	}
}

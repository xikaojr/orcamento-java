package team.java.domain;

public class Rubrica {
	
	private Long Id;
	private String Nome;
	private String Tipo;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getTipo() {
		return Tipo;
	}
	
	public void setTipoAdd(String tipo){
		Tipo = tipo;
	}
	
	public void setTipo(String tipo) {
		
		switch (tipo) {
		case "D":
			tipo = "Despesa";
			break;
		case "I":
			tipo = "Investimento";
			break;
		case "R":
			tipo = "Receitas";
			break;
		default:
			break;
		}
		
		Tipo = tipo;
	}
			
	
}

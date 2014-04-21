package team.java.domain;

import java.util.Calendar;

public class Funcionario {
	
	private Long Id;
	private Long Departamento_id;
	private String Nome;
	private Boolean Chefe_dpto;
	private String Email;
	private String Endereco;
	private Calendar Nascimento;
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}
	
	public Long getDeptoId(){
		return Departamento_id;
	}
	
	public Long setDeptoId(Long Departamento_id){
		return this.Departamento_id = Departamento_id; 
	}
	
	public Boolean getChefeDepto(){
		return Chefe_dpto;
	}
	
	public Boolean setChefeDepto(Boolean Chefe_dpto){
		return this.Chefe_dpto = Chefe_dpto; 
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String Endereco) {
		this.Endereco = Endereco;
	}

	public Calendar getDataNascimento() {
		return Nascimento;
	}

	public void setDataNascimento(Calendar Nascimento) {
		this.Nascimento = Nascimento;
	}
	
}

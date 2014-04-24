package team.java.domain;

import java.sql.Date;
import java.util.Calendar;

public class Funcionario {
	
	private Long Id;
	private String Login;
	private String Senha;
	private Long Departamento_id;
	private String Nome;
	private Boolean Chefe_dpto;
	private String Email;
	private String Endereco;
	private Date Nascimento;
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getLogin() {
		return Login;
	}

	public void setLogin(String Login) {
		this.Login = Login;
	}
	
	public String getSenha(){
		return Senha;
	}
	
	public void setSenha(String Senha){
		this.Senha = Senha;
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

	public Date getDataNascimento() {
		return Nascimento;
	}

	public void setDataNascimento(Date Nascimento) {
		this.Nascimento = Nascimento;
	}
	
}

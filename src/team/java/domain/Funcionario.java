package team.java.domain;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

public class Funcionario {

	private Long Id;
	private String Login;
	private String Senha;
	private Long Departamento_id;
	private String Departamento;
	private String Nome;
	private String Email;
	private String Endereco;
	private Date Nascimento;
	private String Cpf;

	public Funcionario() {

	}

	public Funcionario(HttpServletRequest request) throws ParseException {

		this.Nome = request.getParameter("nome").trim();
		this.Login = request.getParameter("login").trim();

		if (request.getParameter("password") != null
				&& !request.getParameter("password").isEmpty()) {
			this.Senha = request.getParameter("password");
		}

		this.Departamento_id = Long.parseLong(request
				.getParameter("departamento_id"));

		this.Email = request.getParameter("email").trim();

		if (request.getParameter("nascimento") != null
				&& !request.getParameter("nascimento").isEmpty()) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date = format.parse(request
					.getParameter("nascimento"));
			java.sql.Date nascimento = new java.sql.Date(date.getTime());
			this.Nascimento = nascimento;
		}

		this.Cpf = request.getParameter("cpf").trim();
		this.Endereco = request.getParameter("endereco").trim();
	}

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

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String Senha) {
		this.Senha = Senha;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public Long getDeptoId() {
		return Departamento_id;
	}

	public Long setDeptoId(Long Departamento_id) {
		return this.Departamento_id = Departamento_id;
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

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}

}

package wsb.com.cadastroFuncionarios.Model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Alunos")
public class Alunos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 50)
	private String nome;

	
	@NotNull
	@Email
	private String email;

	@NotNull
	@CPF
	private String cpf;

	@NotNull
	@JsonFormat(pattern = "00000-000")
	private String cep;

	@NotNull
	private String rg;

	@NotNull
	@JsonFormat(pattern = "00-0000-0000")
	private String telefone;

	@NotNull
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date dataNascimento;

	private long matricula;// gera a matricula automaticamente.

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	/*
	 * private String logradouro; private String bairro; private String cidade;
	 * private String uf;
	 */// api externa traz o endereço

	

}

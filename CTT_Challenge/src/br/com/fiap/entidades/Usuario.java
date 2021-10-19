package br.com.fiap.entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_usuario")
@SequenceGenerator(name="usuario", sequenceName = "SQ_TB_USUARIO", allocationSize = 1)

public class Usuario {

	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	private int codigo;
	
	@Column(name="username", length = 30, nullable = false)
	private String username;
	
	@Column(name="senha", length = 20, nullable = false)
	private String senha;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Calendar dataNascimento;
	
	@Column(name="cpf", length = 12, nullable = false)
	private String cpf;
	
	@Column(name="creditos")
	private int creditos;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Livro> livros;
	
	public void addLivro(Livro livro) {
		if (livros == null)
			livros = new ArrayList<>();
		livros.add(livro);
		livro.setUsuario(this);
	}
	
	public Usuario() {}
	
	public Usuario(int codigo, String username, String senha, Calendar dataNascimento, String cpf, int creditos) {
		super();
		this.codigo = codigo;
		this.username = username;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.creditos = creditos;
	}
	
	public Usuario(String username, String senha, Calendar dataNascimento, String cpf, int creditos) {
		super();
		this.username = username;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.creditos = creditos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getDataNascimento() {
		
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
}

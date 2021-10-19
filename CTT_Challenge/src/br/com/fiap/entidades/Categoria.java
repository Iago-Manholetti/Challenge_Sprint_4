package br.com.fiap.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
@Table(name="tb_categoria")
@SequenceGenerator(name="categoria", sequenceName = "SQ_TB_CATEGORIA", allocationSize = 1)

public class Categoria {

//nome varchar2(30),
//generos varchar2(50)
//id_livro FK
	
	@Id
	@Column(name="id_categoria")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria")
	private int codigo;
	
	@Column(name="nome", length = 30, nullable = false)
	private String nome;
	
	@Column(name="generos", length = 50, nullable = false)
	private String generos;
	
		@ManyToMany(cascade = CascadeType.PERSIST)
		@JoinTable(name="tb_livro_categoria",
				joinColumns = @JoinColumn(name="id_categoria"),
				inverseJoinColumns = @JoinColumn(name="id_livro"))
		private List<Livro> livros;
	
	public Categoria() {
		
	}
	
	public Categoria(int codigo, String nome, String generos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.generos = generos;
	}
	
	public Categoria(String nome, String generos) {
		super();
		this.nome = nome;
		this.generos = generos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGeneros() {
		return generos;
	}

	public void setGeneros(String generos) {
		this.generos = generos;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
}

package br.com.fiap.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tb_livro")
@SequenceGenerator(name="livro", sequenceName = "SQ_TB_LIVRO", allocationSize = 1)

public class Livro {

	//titulo varchar2(30),
	//autor varchar2(30), 
	//valor integer
	
	
	@Id
	@Column(name="id_livro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro")
	private int codigo;
	
	@Column(name="titulo", length = 30, nullable = false)
	private String titulo;
	
	@Column(name="autor", length = 30, nullable = false)
	private String autor;
	
	@Column(name="valor")
	private int valor;
	
	@ManyToOne
	@JoinColumn(name="tb_usuario")
	private Usuario usuario;
	
	@ManyToMany(mappedBy = "livros")
	private List<Categoria> categorias;
	
	public Livro() {}
	
	public Livro(int codigo, String titulo, String autor, int valor) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.valor = valor;
	}
	
	public Livro(String titulo, String autor, int valor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	
}

package br.com.fiap.entidades;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_historico")
@SequenceGenerator(name="historico", sequenceName = "SQ_TB_HISTORICO", allocationSize = 1)

public class Historico {

//	nomePessoa varchar2(30),
//	tituloLivro varchar2(30), 
//	quantidade integer,
//	quando date
	
	
	@Id
	@Column(name="id_historico")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico")
	private int codigo;
	
	@Column(name="nomePessoa", length = 30, nullable = false)
	private String nomePessoa;
	
	@Column(name="tituloLivro", length = 30, nullable = false)
	private String tituloLivro;
	
	@Column(name="quantidade")
	private int quantidade;
	
	@Temporal(TemporalType.DATE)
	@Column(name="quando")
	private Calendar quando;
	
	public Historico() {}
	
	public Historico(int codigo, String nomePessoa, String tituloLivro, int quantidade, Calendar quando) {
		super();
		this.codigo = codigo;
		this.nomePessoa = nomePessoa;
		this.tituloLivro = tituloLivro;
		this.quantidade = quantidade;
		this.quando = quando;
	}

	public Historico(String nomePessoa, String tituloLivro, int quantidade, Calendar quando) {
		super();
		this.nomePessoa = nomePessoa;
		this.tituloLivro = tituloLivro;
		this.quantidade = quantidade;
		this.quando = quando;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Calendar getQuando() {
		return quando;
	}

	public void setQuando(Calendar quando) {
		this.quando = quando;
	}
	

}

package br.com.fiap.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@Table(name="tb_local")
@SequenceGenerator(name="local", sequenceName = "SQ_TB_LOCAL", allocationSize = 1)

public class Local {

	//cidade varchar2(20),
	//pontoReferencia varchar2(50), 
	//localExato varchar2(50)
	
	@Id
	@Column(name="id_local")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "local")
	private int codigo;
	
	@Column(name="cidade", length = 20, nullable = false)
	private String cidade;
	
	@Column(name="pontoReferencia", length = 50, nullable = false)
	private String pontoReferencia;
	
	@Column(name="localExato", length = 50, nullable = false)
	private String localExato;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "local", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Box box;
	
	
	public Local() {}
	
	public Local(int codigo, String cidade, String pontoReferencia, String localExato) {
		super();
		this.codigo = codigo;
		this.cidade = cidade;
		this.pontoReferencia = pontoReferencia;
		this.localExato = localExato;
	}
	
	public Local(String cidade, String pontoReferencia, String localExato) {
		super();
		this.cidade = cidade;
		this.pontoReferencia = pontoReferencia;
		this.localExato = localExato;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getLocalExato() {
		return localExato;
	}

	public void setLocalExato(String localExato) {
		this.localExato = localExato;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}
	

	
}

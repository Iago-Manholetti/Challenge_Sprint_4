package br.com.fiap.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name="tb_box")
@SequenceGenerator(name="box", sequenceName = "SQ_TB_BOX", allocationSize = 1)

public class Box {

	//estado varchar2(30),
	//quantidade integer 
	
	@Id
	@Column(name="id_box")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "box")
	private int codigo;
	
	@Column(name="estado", length = 30, nullable = false)
	private String estado;
	
	@Column(name="quantidade")
	private int quantidade;
	
	//Relacionamento um-para-um
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_local", nullable = false)
	private Local local;
	
	public Box() {
		
	}
	
	public Box(int codigo, String estado, int quantidade, Local local) {
		super();
		this.codigo = codigo;
		this.estado = estado;
		this.quantidade = quantidade;
		this.local = local;
	}	
	
	public Box(String estado, int quantidade, Local local) {
		super();
		this.estado = estado;
		this.quantidade = quantidade;
		this.local = local;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}

package br.com.fiap.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_avaliacao")
@SequenceGenerator(name="avaliacao", sequenceName = "SQ_TB_AVALIACAO", allocationSize = 1)

public class Avaliacao {
//	nota integer,
//	comentario varchar2(100) 
	
	@Id
	@Column(name="id_avaliacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avaliacao")
	private int codigo;
	
	@Column(name="nota")
	private int nota;
	
	@Column(name="comentario", length = 100, nullable = false)
	private String comentario;
	
	public Avaliacao() {
		
	}
	
	public Avaliacao(int codigo,int nota, String comentario) {
		super();
		this.codigo = codigo;
		this.nota = nota;
		this.comentario = comentario;
	}
	
	public Avaliacao(int nota, String comentario) {
		super();
		this.nota = nota;
		this.comentario = comentario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	
}

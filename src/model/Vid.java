package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vid")
public class Vid implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@OneToOne(cascade = {CascadeType.ALL} )
	@JoinColumn(name="id")
	Entrada entrada;
	private int cantidad;

	private int vidTipo;
	
	@ManyToOne(cascade = {CascadeType.ALL} )
	@JoinColumn(name="idBodega")
	Bodega bodega;
	@ManyToOne(cascade = {CascadeType.ALL} )
	@JoinColumn(name="idCampo")
	Campo campo;

	public enum Vidtipo {
		BLANCA, NEGRA
	}

	

	public Vid() {

	}



	public Vid(Entrada entrada, int cantidad, int vidTipo, Bodega bodega, Campo campo) {
		this.entrada = entrada;
		this.cantidad = cantidad;
		this.vidTipo = vidTipo;
		this.bodega = bodega;
		this.campo = campo;
	}
	
	public Vid(Entrada entrada, int cantidad, int vidTipo, Campo campo) {
		this.entrada = entrada;
		this.cantidad = cantidad;
		this.vidTipo = vidTipo;
		this.campo = campo;
	}

	public Vid(Entrada entrada, int cantidad, int vidTipo) {
		this.entrada = entrada;
		this.cantidad = cantidad;
		this.vidTipo = vidTipo;
	}



	public Entrada getEntrada() {
		return entrada;
	}



	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getVidTipo() {
		return vidTipo;
	}



	public void setVidTipo(int vidTipo) {
		this.vidTipo = vidTipo;
	}



	public Bodega getBodega() {
		return bodega;
	}



	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}



	public Campo getCampo() {
		return campo;
	}



	public void setCampo(Campo campo) {
		this.campo = campo;
	}



	@Override
	public String toString() {
		return "Vid [entrada=" + entrada + ", cantidad=" + cantidad + ", vidTipo=" + vidTipo + "]";
	}
	
	
	

}

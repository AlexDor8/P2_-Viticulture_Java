package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vid")
public class Vid {
	@Id
	private int id;
	private int cantidad;

	private Vidtipo vidTipo;
	
	Bodega bodega;
	
	Campo campo;

	public enum Vidtipo {
		BLANCA, NEGRA
	}

	

	public Vid() {

	}



	public Vid(int id, int cantidad, Vidtipo vidTipo) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.vidTipo = vidTipo;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public Vidtipo getVidTipo() {
		return vidTipo;
	}



	public void setVidTipo(Vidtipo vidTipo) {
		this.vidTipo = vidTipo;
	}

	

}

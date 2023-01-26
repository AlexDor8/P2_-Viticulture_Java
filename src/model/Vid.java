package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vid")
public class Vid {
	@Id
	private int id;
	private TipoVid tipoVid;
	private int cantidad;
	
	
	public Vid(int id, TipoVid tipoVid, int cantidad) {
		this.id = id;
		this.tipoVid = tipoVid;
		this.cantidad = cantidad;
	}
	
	public Vid() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public TipoVid getTipoVid() {
		return tipoVid;
	}


	public void setTipoVid(TipoVid tipoVid) {
		this.tipoVid = tipoVid;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "Vid [id=" + id + ", tipoVid=" + tipoVid + ", cantidad=" + cantidad + "]";
	}
	
	
}

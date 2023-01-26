package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bodega")
public class Bodega implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int id_bodega;
	private String nombre;
	private ArrayList<Vid> vids;
	
	public Bodega() {
		
	}
	
	public Bodega(int id_bodega, String nombre, ArrayList<Vid> vids) {
		this.id_bodega = id_bodega;
		this.nombre = nombre;
		this.vids = vids;
	}

	public int getId_bodega() {
		return id_bodega;
	}

	public void setId_bodega(int id_bodega) {
		this.id_bodega = id_bodega;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Vid> getVids() {
		return vids;
	}

	public void setVids(ArrayList<Vid> vids) {
		this.vids = vids;
	}

	@Override
	public String toString() {
		return "Bodega [id_bodega=" + id_bodega + ", nombre=" + nombre + ", vids=" + vids + "]";
	}
 	
	
	
}

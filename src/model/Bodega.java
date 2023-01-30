package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Bodega")
public class Bodega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id")
	Entrada entrada;
	@Column(name = "nombre")
	private String nombre;
	@Transient
	private ArrayList<Vid> vids;

	public Bodega() {

	}

	public Bodega(Entrada entrada, String nombre) {
		this.entrada = entrada;
		this.nombre = nombre;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
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
		return "Bodega [entrada=" + entrada + ", nombre=" + nombre + ", vids=" + vids + "]";
	}

}

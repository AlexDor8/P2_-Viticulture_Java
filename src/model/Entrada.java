package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the Entrada database table.
 * 
 */
@Entity
@NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e")
public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;

	private String instruccion;

	public Entrada() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstruccion() {
		return this.instruccion;
	}

	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", instruccion=" + instruccion + "]";
	}

}
package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Campo")
public class Campo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@OneToOne(cascade = {CascadeType.ALL} )
	@JoinColumn(name="id_campo")
	Entrada entrada;
	@Transient
	private ArrayList<Vid> vids;
	
	@OneToOne(cascade = {CascadeType.ALL} )
	@JoinColumn(name="id_bodega")
	private Bodega bodega;
	
	
	
	public Campo() {
		
	}



	public Campo(Entrada entrada, Bodega bodega) {
		this.entrada = entrada;
		this.bodega = bodega;
	}



	public Entrada getEntrada() {
		return entrada;
	}



	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}



	public ArrayList<Vid> getVids() {
		return vids;
	}



	public void setVids(ArrayList<Vid> vids) {
		this.vids = vids;
	}



	public Bodega getBodega() {
		return bodega;
	}



	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}



	@Override
	public String toString() {
		return "Campo [entrada=" + entrada + ", vids=" + vids + ", bodega=" + bodega + "]";
	}
	
	
	
	
	
}

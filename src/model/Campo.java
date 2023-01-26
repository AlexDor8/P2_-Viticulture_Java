package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Campo")
public class Campo {
	@Id
	private int id_campo;
	private ArrayList<Vid> vids;
	private Bodega bodega;
	
	public Campo(int id_campo, ArrayList<Vid> vids, Bodega bodega) {
		this.id_campo = id_campo;
		this.vids = vids;
		this.bodega = bodega;
	}
	
	public Campo() {
		
	}

	public int getId_campo() {
		return id_campo;
	}

	public void setId_campo(int id_campo) {
		this.id_campo = id_campo;
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
		return "Campo [id_campo=" + id_campo + ", vids=" + vids + ", bodega=" + bodega + "]";
	}
	
	
	
}

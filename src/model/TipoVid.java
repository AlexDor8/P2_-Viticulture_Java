package model;

public class TipoVid {
	
	private Vidtipo vidTipo;
	
	public enum Vidtipo {
		BLANCA, NEGRA
	}

	public TipoVid(Vidtipo vidTipo) {
		this.vidTipo = vidTipo;
	}

	public Vidtipo getVidTipo() {
		return vidTipo;
	}

	public void setVidTipo(Vidtipo vidTipo) {
		this.vidTipo = vidTipo;
	}
}

package manager;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Bodega;
import model.Campo;
import model.Entrada;
import model.Vid;
import model.Vid.Vidtipo;

public class Manager {

	EntityManager manager;

	EntityManagerFactory emf;

	ArrayList<Bodega> bodegas = new ArrayList<Bodega>();
	ArrayList<Campo> campos = new ArrayList<Campo>();

	private Campo ultimoCampoAnadido;

	public void manager() {
		emf = Persistence.createEntityManagerFactory("P2_Viticulture_AlejandroDoradoCasado");
		manager = emf.createEntityManager();
		ArrayList<Entrada> valores = valoresEntrada();
		intrucciones(valores);

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Entrada> valoresEntrada() {
		ArrayList<Entrada> valores = new ArrayList<Entrada>();
		valores = (ArrayList<Entrada>) manager.createQuery("from Entrada").getResultList();
		return valores;
	}

	public void intrucciones(ArrayList<Entrada> valores) {
		for (int i = 0; i < valores.size(); i++) {
			String instruccion = valores.get(i).getInstruccion();
			String[] instrucciones = instruccion.split(" ");
			String tipo = instrucciones[0];
			switch (tipo) {
			case "B":

				Bodega bodega = new Bodega(valores.get(i), instrucciones[1]);
				bodegas.add(bodega);
				if (manager.createQuery("from Bodega b where b.id = '" + bodega.getEntrada().getId() + "'")
						.getResultList().isEmpty()) {
					manager.getTransaction().begin();
					manager.persist(bodega);
					manager.getTransaction().commit();
				}
				break;
			case "C":
				Bodega ultimaAnadida = bodegas.get(bodegas.size() - 1);
				Campo campo = new Campo(valores.get(i), ultimaAnadida);
				campos.add(campo);
				if (manager.createQuery("from Campo c where c.id = '" + campo.getEntrada().getId() + "'")
						.getResultList().isEmpty()) {
					manager.getTransaction().begin();
					manager.persist(campo);
					manager.getTransaction().commit();
				}
				ultimoCampoAnadido = campos.get(campos.size() - 1);
				break;
			case "V":
				int tipoVid;
				if (instrucciones[1].equalsIgnoreCase(Vidtipo.BLANCA.toString())) {
					tipoVid = 0;
				} else {
					tipoVid = 1;
				}
				Vid vid = new Vid(valores.get(i), Integer.parseInt(instrucciones[2]), tipoVid, ultimoCampoAnadido);
				ultimoCampoAnadido.anadirVid(vid);
				break;
			case "#":
				ultimoCampoAnadido.getBodega().setVids(ultimoCampoAnadido.getVids());
				ArrayList<Vid> vidsbodega = ultimoCampoAnadido.getBodega().getVids();
				if (manager.createQuery("from Vid v where v.id = '" + vidsbodega.get(0).getEntrada().getId() + "'")
						.getResultList().isEmpty()) {
					manager.getTransaction().begin();
					for (int ii = 0; ii < vidsbodega.size(); ii++) {
						manager.persist(vidsbodega.get(ii));
						manager.find(Vid.class, vidsbodega.get(ii).getEntrada().getId());
						vidsbodega.get(ii).setBodega(ultimoCampoAnadido.getBodega());
					}
					manager.getTransaction().commit();
				}
				break;
			}

		}
	}

}

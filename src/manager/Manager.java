package manager;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Bodega;
import model.Campo;
import model.Entrada;

public class Manager {

	EntityManager manager;

	EntityManagerFactory emf;
	
	ArrayList<Bodega> bodegas = new ArrayList<Bodega>();

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
			System.out.println(tipo);
			
			
			switch (tipo) {
			case "B":
				Bodega bodega = new Bodega(valores.get(i), instrucciones[1]);
				bodegas.add(bodega);
				manager.getTransaction().begin();
				manager.persist(bodega);
				manager.getTransaction().commit();
				break;
			case "C":
				Bodega ultimaAnadida = bodegas.get(bodegas.size()-1);
				Campo campo = new Campo(valores.get(i), ultimaAnadida);
				manager.getTransaction().begin();
				manager.persist(campo);
				manager.getTransaction().commit();
				break;
			case "V":
				break;
			case "#":
				break;
			}
			
		}
	}

}

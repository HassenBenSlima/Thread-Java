package simulationTrafficRoutier;

import java.util.Vector;

public class Route {

	private int num;
	private String nom;
	private Vector<Vehicule> v;

	public Route(int num, String nom) {
		this.num = num;
		this.nom = nom;
		v = new Vector<Vehicule>();
	}

	public Vector<Vehicule> getVehicules() {
		return v;
	}

	public int getNum() {
		return num;
	}

	public String getString() {
		return nom;
	}

	public void addVehicule(Vehicule v1) {
		v.add(v1);
	}

}
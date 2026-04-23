package model;

public class CentraleReservation <E,F extends Formulaire>{

	private EntiteReservable<Formulaire>[] entiteAReserver;
	private int nbEntites=0;
	
	public CentraleReservation(EntiteReservable[] entites) {
		this.entiteAReserver=entites;
	}
	
	
	public int ajouterEntite(EntiteReservable<Formulaire> entite) {
		this.entiteAReserver[nbEntites]=entite;
		nbEntites++;
		entite.setNumero(nbEntites);

		return nbEntites;
	}
	
	public int[] donnerPossibilites(F formulaireUt) {
		int[] result = new int[nbEntites];
		for (int i = 0; i < entiteAReserver.length; i++) {
			if (entiteAReserver[i].estLibre(formulaireUt)) {
				result[i]=entiteAReserver[i].getNumero();
			}
			else {
				result[i]=0;
			}
		}
		return result;
	}
	
	public Reservation reserver(int numE,F formulaire) {
		EntiteReservable<Formulaire> entite = entiteAReserver[numE];
		return entite.reserver(formulaire);
		
	}

}

package model;

public class ReservationRestaurant extends Reservation {
	private int numeroService;
	private int numeroTable;
	
	public ReservationRestaurant(int jour, int mois, int numS, int numT) {
		super(jour, mois);
		this.numeroService=numS;
		this.numeroTable=numT;
	}

	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder("Le ");
		chaine.append(jour+"/"+mois+" : table n°"+numeroTable+" pour le ");
		if (numeroService==1) {
			chaine.append("premier ");
		}
		else {
			chaine.append("deuxième ");

		}
		chaine.append("service.");
		return chaine.toString();
	}

	
	
}

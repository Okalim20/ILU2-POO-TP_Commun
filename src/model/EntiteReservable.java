package model;

public abstract class EntiteReservable <F extends Formulaire>{

	protected CalendrierAnnuel carnetReservation;
	protected int numero;
	
	
	public EntiteReservable(CalendrierAnnuel carnet, int numero) {
		this.carnetReservation=carnet;
		this.numero=numero;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public boolean estLibre(F formulaire) {
		return carnetReservation.estLibre(formulaire.getJour(), formulaire.getMois());
	}
	
	public abstract boolean compatible(F formulaire);
	
	public abstract Reservation reserver(F formulaire);
	
}

package model;

public class ReservationHotel extends Reservation{
	
	private int nbLitSimple;
	private int nbLitDouble;
	
	public ReservationHotel(int jour, int mois,int nbLitSimple,int nbLitDouble) {
		super(jour, mois);
		this.nbLitSimple=nbLitSimple;
		this.nbLitDouble=nbLitDouble;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

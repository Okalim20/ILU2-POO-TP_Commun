package model;

public class ReservationSpectacle extends Reservation{

	private int numZone;
	private int numChaise;
	
	public ReservationSpectacle(int jour, int mois, int numzone, int numchaise) {
		super(jour, mois);
		this.numZone=numzone;
		this.numChaise=numchaise;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}

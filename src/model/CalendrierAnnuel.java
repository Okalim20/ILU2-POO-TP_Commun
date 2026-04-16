package model;

public class CalendrierAnnuel {

	private Mois[] calendrier;
	
	public CalendrierAnnuel() {
		calendrier = new Mois[12];
		calendrier[0]= new Mois("janvier", 31);
		calendrier[1]= new Mois("février", 28);
		calendrier[2]= new Mois("mars", 31);
		calendrier[3]= new Mois("avril", 30);
		calendrier[4]= new Mois("mai", 31);
		calendrier[5]= new Mois("juin", 30);
		calendrier[6]= new Mois("juillet", 31);
		calendrier[7]= new Mois("août", 31);
		calendrier[8]= new Mois("septembre", 30);
		calendrier[9]= new Mois("octobre", 31);
		calendrier[10]= new Mois("novembre", 30);
		calendrier[11]= new Mois("décembre", 31);

	}
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour-1);
	}
	
	public boolean reserver(int jour, int mois) {
		boolean libre = estLibre(jour, mois);
		if (libre) {
			calendrier[mois-1].reserver(jour-1);
		}
		return libre;
	}
	
	
	
	
	
	
	
	private class Mois{
		private String nom;
		private boolean[] jours;
		
		public Mois(String nom,int nbJour) {
			this.nom=nom;
			this.jours = new boolean [nbJour];
			for(int i =0;i<nbJour;i++) {
				jours[i]=false;
			}
		}
		
		private boolean estLibre(int jour) {
			return !jours[jour];
		}
		
		private void reserver(int jour){
			if(estLibre(jour)) {
				jours[jour]=true;
			}
			else {
				throw new IllegalStateException();
			}
		}
	}
	
}

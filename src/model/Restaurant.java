package model;

public class Restaurant implements IEtablissement<Formulaire>{

	private CentraleReservation<Formulaire, Formulaire> centrale;


	public void ajouterTable(int nbChaise) {
		CalendrierAnnuel cal = new CalendrierAnnuel();
		Table table = new Table(cal,1 , nbChaise);
		//centrale.ajouterEntite(table);
	}
	
	@Override
	public int[] donnerPossibilites(Formulaire formulaire) {
		return centrale.donnerPossibilites(formulaire);
	}

	@Override
	public Reservation reserver(int numEntite, Formulaire formulaire) {
		return centrale.reserver(numEntite, formulaire);
	}
	
	
	private static class Table extends EntiteReservable<FormulaireRestaurant>{
		private int nbChaises;
		private CalendrierAnnuel calendrierDeuxiemeService;
		public Table(CalendrierAnnuel carnet,int numero, int nbChaises) {
			super(carnet, numero);
			this.nbChaises=nbChaises;
		}
		@Override
		public boolean compatible(FormulaireRestaurant formulaire) {
			if((nbChaises==formulaire.getNombrePersonnes())||(nbChaises+1==formulaire.getNombrePersonnes())){
				if (estLibre(formulaire)) {
					return true;
				}
			}
			return false;
		}
		
		
		@Override
		public Reservation reserver(FormulaireRestaurant formulaire) {
			boolean resaReussie=false;
			if (formulaire.getNumService()==1) {
				resaReussie=this.carnetReservation.reserver(formulaire.getJour(), formulaire.getMois());
			}
			if(formulaire.getNumService()==2) {
				resaReussie=this.calendrierDeuxiemeService.reserver(formulaire.getJour(), formulaire.getMois());
			}
			if(resaReussie) {
				ReservationRestaurant resaResto = new ReservationRestaurant(formulaire.getJour(), formulaire.getMois(), formulaire.getNumService(),this.numero);
				return resaResto;
			}
			
			return null;
			
		}
		
		
	
	}

}

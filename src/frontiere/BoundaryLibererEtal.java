package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui ! \n");
		}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0].matches("true")) {
				StringBuilder etalOccupe = new StringBuilder("Vous avez vendu ");
				etalOccupe.append(donneesEtal[4]);
				etalOccupe.append(" sur ");
				etalOccupe.append(donneesEtal[3]);
				etalOccupe.append(" ");
				etalOccupe.append(donneesEtal[2]);
				etalOccupe.append("\n");
				System.out.println(etalOccupe.toString());
				etalOccupe.delete(0, -1);
				etalOccupe.append("En revoir ");
				etalOccupe.append(nomVendeur);
				etalOccupe.append(", passez une bonne journée");
			}
		}
	}

}

package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			StringBuilder vendeurInconnu = new StringBuilder("Je suis d�sol� ");
			vendeurInconnu.append(nomVendeur);
			vendeurInconnu.append("Mais il faut �tre un habitant du notre village pour commercer ici \n");
			System.out.println(vendeurInconnu.toString());
			return;
		}
		else {
			StringBuilder vendeurConnu = new StringBuilder("Bonjour ");
			vendeurConnu.append(nomVendeur);
			vendeurConnu.append(", je vais regarder si je peux vous trouver un �tal \n");
			System.out.println(vendeurConnu.toString());
			if(!controlPrendreEtal.resteEtals()) {
				StringBuilder etalIndisponible = new StringBuilder("D�sol� ");
				etalIndisponible.append(nomVendeur);
				etalIndisponible.append(" je n'ai plus d'�tal qui ne soit pas d�j� occup� \n");
				System.out.println(etalIndisponible.toString());
			}
			else {
				installerVendeur(nomVendeur);
				
			}
		}
			
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder etalDisponible = new StringBuilder("C'est parfait, il me reste un �tal pour vous !");
		etalDisponible.append("Il me faudrait quelques renseignements : \n");
		etalDisponible.append("Quel produit souhaitez vous en vendre ? \n");
		System.out.println(etalDisponible.toString());
		String produit = scan.next().toString();
		etalDisponible.delete(0, -1);
		etalDisponible.append("Combien souhaitez vous en vendre ? \n");
		System.out.println(etalDisponible.toString());
		int nbProduit = scan.nextInt();
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, 0);
		if(numeroEtal != -1) {
			StringBuilder installer = new StringBuilder("Le vendeur ");
			installer.append(nomVendeur );
			installer.append("s'est install� � l'�tal n�");
			installer.append(numeroEtal);
		}
	}
}

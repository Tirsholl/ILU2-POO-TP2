package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			System.out.println("La marcgé est vide, revenez plus tard");
		return;
		}
		StringBuilder StringMarche = new StringBuilder(nomAcheteur);
		StringMarche.append(", vous trouverez au marché \n");
		for(int i = 0; i<infosMarche.length; i++ ) {
			StringMarche.append("-");
			StringMarche.append(infosMarche[i]);
			i++;
			StringMarche.append(" qui vend ");
			StringMarche.append(infosMarche[i]);
			i++;
			StringMarche.append("");
			StringMarche.append(infosMarche[i]);
			StringMarche.append("\n");
		}
		System.out.println(StringMarche.toString());
	}
}

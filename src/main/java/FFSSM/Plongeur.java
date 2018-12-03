package FFSSM;

import java.util.Calendar;
import java.util.*;

public class Plongeur extends Personne{
	private int niveau;
        public List<Licence> myLicence = new LinkedList<>();
        
        public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance,int niveau){
            super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
            this.niveau = niveau;
        }
        
        public int getNiveau(){
            return niveau;
        }
        
        public void AjouteLicence(Licence licence){
           // Licence a = new Licence(this,numero,delivrance,this.getNiveau(),club);
            myLicence.add(licence);
        }

    public List<Licence> getMyLicence() {
        return myLicence;
    }
        
        
}

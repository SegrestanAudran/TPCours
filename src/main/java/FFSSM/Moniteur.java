/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public List<Embauche> myEmbauche = new LinkedList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance,int niveau, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau);
        this.numeroDiplome = numeroDiplome;
    }

    public Club employeur() {
         // TODO: Implémenter cette méthode
         Club a = null;
         if (myEmbauche.isEmpty()){
             return a;
         }
         if(myEmbauche.get(myEmbauche.size()-1).estTerminee()== false){
             a = myEmbauche.get(myEmbauche.size()-1).getEmployeur();
         }
         return a;
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }
    
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
         // TODO: Implémenter cette méthode
         Embauche e = new Embauche(debutNouvelle,this,employeur);
        myEmbauche.add(e);
         //throw new UnsupportedOperationException("Pas encore implémenté");	    
    }

    public List<Embauche> emplois() {
         // TODO: Implémenter cette méthode
         return myEmbauche;
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

}

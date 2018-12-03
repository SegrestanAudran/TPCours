/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;
    
    public List<Plongeur> myPlongeurs = new LinkedList<>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
         // TODO: Implémenter cette méthode
         myPlongeurs.add(participant);
        //throw new UnsupportedOperationException("Pas encore implémenté");	    
    }

    public Calendar getDate() {
        return date;
    }

    public boolean estConforme() {
         // TODO: Implémenter cette méthode
         boolean a = true;
         if (myPlongeurs.isEmpty()){
             throw new IllegalArgumentException();
         }
         for (Plongeur p : myPlongeurs){
             if (p.myLicence.get(p.myLicence.size()-1).estValide(date)){
                 a =true;
             }else{
                 a =false;
                 break;
             }
         }
         return a;
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

}

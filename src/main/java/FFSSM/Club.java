/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;

    public List<Plongee> myPlongee = new LinkedList<>();
    
    
    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    public Set<Plongee> plongeesNonConformes() {
         // TODO: Implémenter cette méthode
         HashSet<Plongee> plongeeNonConforme = new HashSet<>();
         for (Plongee p : myPlongee){
             if (p.estConforme()==false){
                 plongeeNonConforme.add(p);
             }
         }
         return plongeeNonConforme;
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

    public void organisePlongee(Plongee p) {
         // TODO: Implémenter cette méthode
         myPlongee.add(p);
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}

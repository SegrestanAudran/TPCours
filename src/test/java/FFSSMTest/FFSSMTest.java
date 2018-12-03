package FFSSMTest;


import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongeur;
import FFSSM.Plongee;
import FFSSM.Site;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FFSSMTest {
    
    private Plongeur p1,p2;
    private Plongee pl1,pl2;
    private Moniteur m1,m2;
    private Calendar ddn;
    private Calendar day;
    private Calendar oneyear;
    private Licence l1,l2;
    private Club c1;
    private Embauche e1;
    private Site s1;
    @Before
    public void setUp(){
        Calendar ddn = Calendar.getInstance();
        Calendar day = Calendar.getInstance();
        Calendar oneyear = Calendar.getInstance();
        oneyear.set(2018,11,29);
        
        ddn.set(0,01,01);
        day.set(2018,11,26);
        l1 = new Licence(p1,"12345",day,1,c1);
        l2 = new Licence(p2, "065005599", ddn, 2, c1);
        p1 = new Plongeur("123456","Michou", "Michel", "Quelque part", "0123456789", ddn, 1);
        p2 = new Plongeur("002", "Robert", "Louis", "2 Allee Fare", "64500", ddn,1);
        m1 = new Moniteur("123456","Michou", "Michel", "Quelque part", "0123456789", ddn, 1,1);
        m2 = new Moniteur("234567","Michou2", "Michel2", "Autre part", "0123456789", ddn, 1,1);
        pl1 = new Plongee(s1, m1, day, 80000, 30); 
        pl2 = new Plongee(s1, m1, day, 80000, 30); 
        c1 = new Club(m1, "ASS", "077777777");
        
        Calendar c4 = Calendar.getInstance();
        c4.set(2012,02,02);
        e1 = new Embauche(c4, m1, c1);
        
    }
    
    @Test
    public void testAjouteLicence(){
        p1.AjouteLicence(l1);
        assertEquals(p1.getMyLicence().size(),1);
    }
    
    @Test
        public void testGetEmployeur(){
            assertEquals(e1.getEmployeur(),c1);
        }
        
    @Test
        public void testEmbaucheTerminer(){
            Calendar c4 = Calendar.getInstance();
            c4.set(2018,02,02);
            e1.terminer(c4);
            assertEquals(e1.getFin(),c4);
        }
    
    @Test
    public void testLicenceValide(){
        Calendar oneyear = Calendar.getInstance();
        oneyear.set(2018,11,29);
        Calendar day2 = Calendar.getInstance();
        day2.set(0,01,01);
        assertEquals(l1.estValide(oneyear),true);
        assertEquals(l2.estValide(oneyear),false);
    }
    
    @Test
    public void testAjoutParticipants(){
        pl1.ajouteParticipant(p1);
        assertEquals(pl1.myPlongeurs.size(),1);
    }
        
    @Test
    public void testPlongleesConformes(){
        p1.AjouteLicence(l1);
        p2.AjouteLicence(l2);
        //Ajout d'un participant avec licence licence valide
        pl1.ajouteParticipant(p1);
        assertEquals(pl1.estConforme(), true);
        //Ajout d'un participant avec licence licence non valide
        pl1.ajouteParticipant(p2);
        assertEquals(pl1.estConforme(), false);
    }
    
    @Test
    public void testPlongeeAvecParticipantsSansLicence() {
        try {
            pl1.ajouteParticipant(p1);
            assertEquals(pl1.estConforme(), true);
            fail();
        } catch (Exception e) {

        }
    }
    
    @Test
    public void testPlongeeSansParticipants() {
        try {
            assertEquals(pl1.estConforme(), true);
            fail();
        } catch (Exception e) {

        }
    }
    
    @Test
    public void testOrganisePlongee() {
        c1.organisePlongee(pl1);
        assertEquals(c1.myPlongee.size(), 1);
    }
    
    @Test
    public void testListePlongeeNonConforme() {
        p1.AjouteLicence(l1);
        p2.AjouteLicence(l2);
        //Ajout d'un participant avec licence licence valide
        pl1.ajouteParticipant(p1);
        //Ajout d'un participant avec licence licence non valide
        pl2.ajouteParticipant(p2);
        c1.organisePlongee(pl1);
        assertEquals(c1.plongeesNonConformes().size(), 0);
        c1.organisePlongee(pl2);
        assertEquals(c1.plongeesNonConformes().size(), 1);
    }
        
    @Test
    public void testNouvelleEmbauche(){
        m1.nouvelleEmbauche(c1, day);
        assertEquals(m1.myEmbauche.size(),1);
    }
    
    @Test
    public void testEmployeur(){
        assertEquals(m1.employeur(),null);
        m1.nouvelleEmbauche(c1, day);
        assertEquals(m1.employeur(),c1);
    }
    
}

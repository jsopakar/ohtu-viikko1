/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovelluslogiikka.Pistelasku;

/**
 *
 * @author jsopakar
 */
public class PistelaskuTest {
    
    Pistelasku pl;
    
    public PistelaskuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void palauttaakoUusiPistelaskuriNollan() {
        pl = new Pistelasku();
        assertEquals(0, pl.getPisteet());
    }
    
    @Test
    public void toimiikoPisteenlisaysNollasta() {
        pl = new Pistelasku();
        pl.lisaaPisteita(5);
        assertEquals(5, pl.getPisteet());
    }
    
    @Test
    public void toimiikoUseidenPisteidenLisays() {
        pl = new Pistelasku();
        pl.lisaaPisteita(8);
        pl.lisaaPisteita(13);
        pl.lisaaPisteita(1);
        assertEquals(22, pl.getPisteet());
    }
    
    @Test
    public void toimiikoPisteidenPerusvahennys() {
        pl = new Pistelasku();
        pl.lisaaPisteita(9);
        pl.vahennaPisteita(5);
        assertEquals(4, pl.getPisteet());
    }
    
    @Test
    public void toimiikoVahennysNollaan() {
        pl = new Pistelasku();
        pl.lisaaPisteita(5);
        pl.vahennaPisteita(5);
        assertEquals(0, pl.getPisteet());
    }
    
    @Test
    public void tarkistaEtteiVahennysVieNegatiiviseksi() {
        pl = new Pistelasku();
        pl.lisaaPisteita(5);
        pl.vahennaPisteita(10);
        assertEquals(0, pl.getPisteet());
    }
    
    //Vaadittujen pisteiden kohdalla testausta:
    
    @Test
    public void toimiikoVaaditunPistemaaranAsetusLuonnissa() {
        pl = new Pistelasku(20);
        assertEquals(20, pl.getVaaditutPisteet());
    }
    
    @Test
    public void onkoUusiPistemaarallinenPeliLapaisematta() {
        pl = new Pistelasku(20);
        assertEquals(false, pl.peliLapi());
    }
    
    @Test
    public void onkoPeliLapiKunTarpeeksiPisteita_Tasan() {
        pl = new Pistelasku(20);
        pl.lisaaPisteita(20);
        assertEquals(true, pl.peliLapi());
    }

    @Test
    public void onkoPeliLapiKunTarpeeksiPisteita_Yli() {
        pl = new Pistelasku(20);
        pl.lisaaPisteita(50);
        assertEquals(true, pl.peliLapi());
    }

}
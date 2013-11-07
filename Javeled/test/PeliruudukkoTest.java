/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Peliruudukko;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jsopakar
 */
public class PeliruudukkoTest {
    
    Peliruudukko ruudukko;
    
    public PeliruudukkoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ruudukko = new Peliruudukko(6);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void hello() {}
    
    @Test
    // Koetesti
    public void ruudukonEkanRuudunArvoOikein() {
        ruudukko.taytaEsimerkkiruudukko();
        int ekaArvo = ruudukko.palautaRuutu(0, 0).kerroTyyppi();
        
        // selvitettävä miten testata palautusarvon olevan 0-3:::
        //assertArrayEquals(int, int);
    } 
    
    @Test
    // TODO: muokattava paremmaksi vielä...
    public void onnistuukoRuutujenVaihto() {
        ruudukko.taytaEsimerkkiruudukko();
        int arvo1 = ruudukko.palautaRuutu(2, 1).kerroTyyppi();
        int arvo2 = ruudukko.palautaRuutu(2, 2).kerroTyyppi();
        ruudukko.vaihdaRuudut(2, 1, 2, 2);
        int uusi1 = ruudukko.palautaRuutu(2, 1).kerroTyyppi();
        int uusi2 = ruudukko.palautaRuutu(2, 2).kerroTyyppi();
        
        assertEquals(arvo1, uusi2);
        assertEquals(arvo2, uusi1);
        
    }
    
    @Test
    public void toimiikoSamanTyypinRuudunSiirtojenEsto() {
        ruudukko.taytaEsimerkkiruudukko();
        boolean onnistuiko = ruudukko.siirtoMahdollinen(0, 0, 0, 1);
        assertEquals(false, onnistuiko);
    }
}
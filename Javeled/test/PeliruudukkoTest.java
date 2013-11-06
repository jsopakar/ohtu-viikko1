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
        Peliruudukko ruudukko = new Peliruudukko(6);
        ruudukko.taytaRuudukkoSatunnaisesti();
        int ekaArvo = ruudukko.palautaRuutu(0, 0).kerroTyyppi();
        
        // selvitettävä miten testata palautusarvon olevan 0-3:::
        //assertArrayEquals(int, int);
    } 
}
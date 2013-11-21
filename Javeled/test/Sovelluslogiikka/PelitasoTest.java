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

/**
 *
 * @author Janne Pakarinen
 */
public class PelitasoTest {
    
    public PelitasoTest() {
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
    public void toimiikoPelitasonLuonti() {
        Pelitaso peli = new Pelitaso(-1);
        Ruutu r = peli.getRuudukko().palautaRuutu(0, 0);
        assertEquals(1, r.kerroTyyppi());
    }
    
    @Test
    public void toimiikoPelitasonLuonninSiirtomaara() {
        Pelitaso peli = new Pelitaso(-1, 15);
        assertEquals(14, peli.siirtojaJaljella());
    }
}
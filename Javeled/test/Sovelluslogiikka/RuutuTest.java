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
import sovelluslogiikka.*;

/**
 *
 * @author Janne Pakarinen
 */
public class RuutuTest {

    Ruutu r;

    public RuutuTest() {
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

    @Test
    public void onkoLuodunRuudunTyyppiOikein() {
        r = new Ruutu(3);
        assertEquals(3, r.kerroTyyppi());
    }

    @Test
    public void onkoOletuspistemaaraYksi() {
        r = new Ruutu(1);
        assertEquals(1, r.pistearvo());
    }
    
    @Test
    public void asettuukoPistearvoOikeinLuonnissa() {
        r = new Ruutu(1, 4);
        assertEquals(4, r.pistearvo());
    }
    
    @Test
    public void toimiikoPistearvonMuuttaminen() {
        r = new Ruutu(2);
        r.asetaPistearvo(8);
        assertEquals(8, r.pistearvo());
    }
            
}
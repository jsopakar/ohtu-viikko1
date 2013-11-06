/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author jsopakar
 */

/* Luokkarunko yksittäiselle peliruudulle
 * 
 */

public class Ruutu {
    
    private int tyyppi;
    
    public Ruutu(int tyyppi) {
        this.tyyppi = tyyppi;
    }
    
    public int kerroTyyppi() {
        return this.tyyppi;
    }
    
    public void asetaTyyppi(int uusiTyyppi) {
        this.tyyppi = uusiTyyppi;
    }
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 * Luokka yksittäistä peliruutua varten.
 * <p>
 * Sisältää kaiken yksittäisen ruutuun vaikuttavan tiedon.
 * @author jsopakar
 */

/* Luokkarunko yksittäiselle peliruudulle
 * 
 */

public class Ruutu {
    
    private int tyyppi;
    
    /**
     * Konstruktori, joka luo halutun tyyppisen ruudun
     * @param tyyppi haluttu tyyppi
     */
    public Ruutu(int tyyppi) {
        this.tyyppi = tyyppi;
    }
    
    /**
     * Kertoo ruudun tyypin
     * @return ruudun tyyppi
     */
    public int kerroTyyppi() {
        return this.tyyppi;
    }
    
    /**
     * Muuttaa ruudun tyypin.
     * <p>
     * Ei ainakaan vielä tarkastele tyypin sisällön järkevyyttä millään tavalla.
     * @param uusiTyyppi haluttu uusi ruututyyppi
     */
    public void asetaTyyppi(int uusiTyyppi) {
        this.tyyppi = uusiTyyppi;
    }
    
    
    
}

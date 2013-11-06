/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author jsopakar
 */

/* Runko peliruudukolle, joka tulee sisältämään taulukon tms. Ruutu-olioita.
 * 
 */
public class Peliruudukko {
    
    private int koko;
    private Ruutu[][] sisalto;
    
    public Peliruudukko(int koko) {
        this.koko = koko;
        sisalto = new Ruutu[koko][koko];
    }
    
    public void taytaRuudukko() {
        for (int i = 0; i<koko; i++) {
            for (int j = 0; j<koko; j++ ) {
                sisalto[i][j] = new Ruutu(1);
            }
        }
    }
    
    
    
}

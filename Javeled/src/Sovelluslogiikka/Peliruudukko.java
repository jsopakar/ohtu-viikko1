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
                int luku = (int)(Math.random() * 3) + 1; //satunnaisluku 1-3
                sisalto[i][j] = new Ruutu(luku);
            }
        }
    }
    
    public Ruutu palautaRuutu(int x, int y) {
        return sisalto[x][y];
    }
    
    public int kerroKoko() {
        return this.koko;
    }
    
    // TODO: Tämä ei vielä tee mitään, tarvitsee kunnon 
    public void kasitteleRuutu(int x, int y) {
        
        //kokeilua, ei oikeaa logiikkaa:
        if (this.sisalto[x][y].kerroTyyppi() == 1) {
            this.sisalto[x][y].asetaTyyppi(0);
        }
            
    }
    
    
}

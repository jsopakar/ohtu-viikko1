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
    
    public void taytaRuudukkoSatunnaisesti() {
        for (int i = 0; i<koko; i++) {
            for (int j = 0; j<koko; j++ ) {
                int luku = (int)(Math.random() * 3) + 1; //satunnaisluku 1-3
                sisalto[i][j] = new Ruutu(luku);
            }
        }
    }
    
    // Tilapäinen tapa palauttaa jokin ennalta määritelty peliruudukko
    // Täytyy siirtää myöhemmin logiikka parempaan paikkaan, jossa
    // mahdollisuus palauttaa joku esimerkkiruudukko, satunnainen oletuskoko,
    // tai myös tiedostosta luettu erikoisempi pelimuoto.
    public void taytaEsimerkkiruudukko() {
        Ruutu[][] uusiSisalto = new Ruutu[koko][koko];
        int[][] numerot  =
            { { 1, 1, 3, 2, 2, 2 },
            { 2, 1, 1, 1, 2, 3 },
            { 2, 1, 3, 2, 3, 3 },
            { 2, 1, 1, 3, 1, 1 },
            { 3, 3, 2, 2, 1, 1 },
            { 1, 2, 3, 1, 2, 3 } };
        
        for (int i = 0; i<koko; i++) {
            for (int j = 0; j<koko; j++) {
                uusiSisalto[i][j] = new Ruutu(numerot[i][j]);
            }
        }
        this.sisalto = uusiSisalto;
    }
    
    public Ruutu palautaRuutu(int x, int y) {
        return sisalto[x][y];
    }
    
    public int kerroKoko() {
        return this.koko;
    }
    
    // TODO: Tämä ei vielä tee mitään, tarvitsee kunnon logiikan
    public void kasitteleRuutu(int x, int y) {
        
        //kokeilua, ei oikeaa logiikkaa:
        if (this.sisalto[x][y].kerroTyyppi() == 1) {
            this.sisalto[x][y].asetaTyyppi(0);
        }
        
        if (x < this.koko) {
            int a = x;
            while (a<koko) {
                
                a++;
            }
        }
            
    }
    
    
}

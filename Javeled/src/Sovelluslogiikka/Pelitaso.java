/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author jsopakar
 */

/* Luokkarunko pelitasolle, joka tulee sisältämään yhden Peliruudukon,
 * ja muut kyseiseen tasoon liittyvät tiedot, kuten vuoromäärän, pistelaskun,
 * ja tiedon siitä milloin taso on läpäisty.
 */
public class Pelitaso {
    
    private int tempTestikoko = 6;
    
    private Peliruudukko ruudukko;
    
    // Ilman parametria luodaan testikäyttöön esimerkkiruudukko
    public Pelitaso() {
        
        ruudukko = new Peliruudukko(tempTestikoko);
        ruudukko.taytaEsimerkkiruudukkoTesteihin();
        //ruudukko.taytaRuudukkoSatunnaisesti();
    }
    
    public Pelitaso(int kentta) {
        ruudukko = new Peliruudukko(tempTestikoko);
        switch (kentta) {
            case 0:     //Pelattavaruudukko
                ruudukko.taytaEsimerkkiPelattavaRuudukko();
                break;
            case -1:    //Testiruudukko
                ruudukko.taytaEsimerkkiruudukkoTesteihin();
                break;
            default:
                ruudukko.taytaEsimerkkiPelattavaRuudukko();
                break;
        }
    }
    
    public Peliruudukko getRuudukko() {
        return this.ruudukko;
    }
       
}

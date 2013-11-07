/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.*;

/**
 *
 * @author jsopakar
 */

/* Luokka tekstipohjaiselle käyttöliittymälle, lähinnä pelin rakennus-
 * ja testausvaiheeseen. Myöhemmin toiminnallisuus tulee siirtymään
 * graafisen käyttöliittymäluokan taakse.
 */

public class TekstiKL {

    public TekstiKL() {
        
    }
    
    public void testipeli() {
        
        System.out.println("Testipeli:");
        System.out.println("Luodaan kenttä:");
        
        Pelitaso peli = new Pelitaso();
        Peliruudukko ruudukko = peli.getRuudukko();
        
        tulostaRuudukko(ruudukko);
        
        System.out.println("Käsitellään ruutu:");
        System.out.println(ruudukko.palautaRuutu(1,2).kerroTyyppi());
        int testitulos = ruudukko.kasitteleRuutu(1,2);
        System.out.println("Samoja: "+ testitulos);
        
        System.out.println("Käsittelyn jälkeen: ");
        tulostaRuudukko(ruudukko);
        
        System.out.println("Vaihdetaan: ");
        System.out.println(ruudukko.siirtoMahdollinen(0,0,0,1));
        ruudukko.vaihdaRuudut(2, 1, 2, 2);
        
        //tulostaRuudukko(ruudukko);
    }
    
    private void tulostaRuudukko(Peliruudukko ruudukko) {
        int koko = ruudukko.kerroKoko();
        
        for (int i=0; i<koko; i++) {
            for (int j=0; j<koko; j++) {
                System.out.print(ruudukko.palautaRuutu(i, j).kerroTyyppi());
            }
            System.out.println("");
        }

    }
    
}

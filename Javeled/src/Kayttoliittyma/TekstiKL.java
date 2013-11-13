/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jsopakar
 */

/* Luokka tekstipohjaiselle käyttöliittymälle, lähinnä pelin rakennus-
 * ja testausvaiheeseen. Myöhemmin toiminnallisuus tulee siirtymään
 * graafisen käyttöliittymäluokan taakse.
 */

public class TekstiKL {
    
    Peliruudukko ruudukko;
    
    public TekstiKL() {
        
    }
    
    public void testipeli() {
        
        System.out.println("Testipeli:");
        System.out.println("Luodaan kenttä:");
        
        Pelitaso peli = new Pelitaso();
        ruudukko = peli.getRuudukko();
        
        tulostaRuudukko(ruudukko);
        
        
        
        boolean boo = ruudukko.vaihdaRuudut(0, 0, 1, 0);
        System.out.println(boo);
        System.out.println("asd");
        tulostaRuudukko(ruudukko);
        
        int x = ruudukko.kasitteleRuutu(1, 1);
        ruudukko.teePoisto();
        
        System.out.println("Käsittelyn jälkeen:");
        tulostaRuudukko(ruudukko);
        
        /*
        ArrayList<Point> poistettavat = new ArrayList<Point>();
        poistettavat.add(new Point(0, 2));
        poistettavat.add(new Point(5, 4));
        ruudukko.poistaRuudut(poistettavat);
        
        System.out.println("Poiston jälkeen:");
        tulostaRuudukko(ruudukko);
        */
        
        //System.out.println("Käsitellään ruutu:");
        //System.out.println(ruudukko.palautaRuutu(1,2).kerroTyyppi());
        //int testitulos = ruudukko.kasitteleRuutu(1,2);
        //System.out.println("Samoja: "+ testitulos);
        
        //System.out.println("Käsittelyn jälkeen: ");
        //tulostaRuudukko(ruudukko);
        
        //System.out.println("Vaihdetaan: ");
        //System.out.println(ruudukko.siirtoMahdollinen(0,0,0,1));
        //ruudukko.vaihdaRuudut(2, 1, 2, 2);
        
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
    
    private void lueKomento() {
        Scanner lukija = new Scanner(System.in);
        
        String komento = lukija.nextLine();
        while (komento != "") {
            
            int rivi1, sarake1, rivi2, sarake2;
            char kirjain = komento.charAt(0);
            switch (kirjain) {
                case 'K':   // K=käsittele
                    System.out.println("Anna rivi ja sarake:");
                    rivi1 = Integer.parseInt(lukija.nextLine());
                    sarake1 = Integer.parseInt(lukija.nextLine());
                    ruudukko.kasitteleRuutu(rivi1, sarake1);
                    break;
                case 'V':   // V=vaihto
                    System.out.println("Anna siirrettävän rivi ja sarake");
                    rivi1 = Integer.parseInt(lukija.nextLine());
                    sarake1 = Integer.parseInt(lukija.nextLine());
                    rivi2 = Integer.parseInt(lukija.nextLine());
                    sarake2 = Integer.parseInt(lukija.nextLine());
                    
                    break;
                default :
                    break;
            }
        }
    }
    
}

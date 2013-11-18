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
    Scanner lukija = new Scanner(System.in);
    
    public TekstiKL() {
        
    }
    
    public void testipeli() {
        
        System.out.println("Testipeli:");
        System.out.println("Luodaan kenttä:");
        
        Pelitaso peli = new Pelitaso();
        ruudukko = peli.getRuudukko();
        
        tulostaRuudukko(ruudukko);
        
        lueKomentoja();
        
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
    
    private void lueKomentoja() {
        
        boolean lopeta = false;
        while (!lopeta) {
            System.out.println("Anna komento: ");
            String komento = lukija.nextLine();
            if (komento.equals("")) {
                lopeta = true;
                break;
            }
            char kirjain = komento.charAt(0);
            switch (kirjain) {
                case 'K':   // K=käsittele
                    lueRuudunKasittely();
                    break;
                case 'V':   // V=vaihto
                    lueSiirronKasittely();
                    break;
                case 'T':   // Peliruudukon tulostus
                    System.out.println("Ruudukon tila:");
                    tulostaRuudukko(ruudukko);
                    break;
                case 'P':    // poista tyhjät
                    System.out.println("Poistetaan tyhjät ruudut");
                    ruudukko.taytaTyhjatRuudut();
                    //ruudukko.taytaRuutu(1, 2);
                    tulostaRuudukko(ruudukko);
                    break;
                case 'N':   // yksittäisen ruudun nollaus
                    lueNollaus();
                    break;
                case 'L':   //lopetus
                    System.out.println("Lopetataan.");
                    lopeta = true;
                default :
                    lopeta = true;
                    break;
            }
        }
    }
    
    private void lueRuudunKasittely() {
        int rivi1, sarake1;
        System.out.println("Anna rivi ja sarake: ");
        rivi1 = Integer.parseInt(lukija.nextLine());
        sarake1 = Integer.parseInt(lukija.nextLine());
        System.out.println("Käsitellään: " + rivi1 + ", " + sarake1);
        int tulos = ruudukko.kasitteleRuutu(rivi1, sarake1);
        ruudukko.teePoisto();
        tulostaRuudukko(ruudukko);
    }
    
    private void lueSiirronKasittely() {
        int rivi1, sarake1, rivi2, sarake2;
        System.out.println("Anna siirrettävän ruudun rivi ja sarake:");
        rivi1 = Integer.parseInt(lukija.nextLine());
        sarake1 = Integer.parseInt(lukija.nextLine());
        System.out.println("Anna kohderuudun rivi ja sarake");
        rivi2 = Integer.parseInt(lukija.nextLine());
        sarake2 = Integer.parseInt(lukija.nextLine());
        boolean tulos = ruudukko.vaihdaRuudut(rivi1, sarake1, rivi2, sarake2);
        if (!tulos) {
            System.out.println("Siirto ei mahdollinen!");
        } else {
            tulostaRuudukko(ruudukko);
        }
        
    }
    
    private void lueNollaus() {
        int rivi1, sarake1;
        System.out.println("Anna rivi ja sarake: ");
        rivi1 = Integer.parseInt(lukija.nextLine());
        sarake1 = Integer.parseInt(lukija.nextLine());
        System.out.println("Nollataan: " + rivi1 + ", " + sarake1);
        ruudukko.poistaRuutu(rivi1, sarake1);
        tulostaRuudukko(ruudukko);
    }
    
}

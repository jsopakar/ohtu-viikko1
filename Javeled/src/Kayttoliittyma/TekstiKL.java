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
/* Luokka tekstipohjaiselle käyttöliittymälle, lähinnä pelin rakennus-
 * ja testausvaiheeseen. Myöhemmin toiminnallisuus tulee siirtymään
 * graafisen käyttöliittymäluokan taakse.
 *
 * @author 012616660
 */
public class TekstiKL {
    
    Pelitaso peli;
    Peliruudukko ruudukko;
    Scanner lukija = new Scanner(System.in);
    
    /**
     *
     */
    public TekstiKL() {
        
    }
    
    /**
     * Testipelin toteutusrunko, joka luo pelitason, ja kutsuu komentoja
     * erikseen lukevia ja tulkitsevia metodeja.
     * <p>
     * Mitään virheenkäsittelyä annetulle syötteelle ei tehdä, koska
     * tekstikäyttöliittymän on tarkoitus jäädä tilapäiseksi ja lähinnä
     * pelin testausta varten olevaksi. Esim. koordinaattien antamiseen
     * samalle riville ei varauduta.
     */
    public void testipeli() {
        
        System.out.println("------Testipeli------");
        tulostaOhje();
        System.out.println("Luodaan kenttä:");
        
        peli = new Pelitaso(0);
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
    
    /**
     * Tulostaa peliruudukon merkkiesityksenä
     * @param ruudukko tulostetta ruudukko
     */
    private void tulostaRuudukko(Peliruudukko ruudukko) {
        int koko = ruudukko.kerroKoko();
        
        for (int i=0; i<koko; i++) {
            for (int j=0; j<koko; j++) {
                System.out.print(ruudukko.palautaRuutu(i, j).kerroTyyppi());
            }
            System.out.println("");
        }

    }
    /**
     * Lukee käyttäjän antaman komennon rivi riviltä. Kutsuu monimutkaisempien
     * komentojen yhteydessä erillistä metodia, joka hoitaa käsittelyn.
     */
    private void lueKomentoja() {
        
        boolean lopeta = false;
        while (!lopeta) {
            int siirtoja = peli.siirtojaJaljella();
            System.out.println("Anna komento: (" + siirtoja + " siirtoa jäljellä)");
            String komento = lukija.nextLine();
            if (komento.equals("")) {
                lopeta = true;
                break;
            }
            char kirjain = komento.toUpperCase().charAt(0);
            switch (kirjain) {
                case 'S':   // S=Siirron tekeminen, varsinainen pelitoiminto
                    lueSiirronKasittely();
                    break;
                case 'K':   // K=käsittele
                    lueRuudunKasittely();
                    break;
                case 'T':   // Peliruudukon tulostus
                    System.out.println("Ruudukon tila:");
                    tulostaRuudukko(ruudukko);
                    break;
                case 'P':    // poista tyhjät
                    System.out.println("Poistetaan tyhjät ruudut");
                    ruudukko.taytaTyhjatRuudut();
                    ruudukko.kasitteleKokoRuudukko();
                    tulostaRuudukko(ruudukko);
                    break;
                case 'N':   // yksittäisen ruudun nollaus
                    lueNollaus();
                    break;
                case 'X':   // Testitoiminto, debuggausvaiheen helpottamiseen
                    ruudukko.kasitteleKokoRuudukko();
                    tulostaRuudukko(ruudukko);
                    break;
                case 'O':   // ohjeen tulostus
                    tulostaOhje();
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
    
    /**
     * Metodi, joka kysyy erillisillä riveillä neljä lukua, keskenään vaihdettavien
     * ruutujen rivin ja sarakkeen.
     * <p>
     * Huom! Käyttäjän antama indeksointi lähtee ykkösestä.
     */
    private void lueSiirronKasittely() {
        int rivi1, sarake1, rivi2, sarake2;
        System.out.println("Anna siirrettävän ruudun rivi ja sarake:");
        rivi1 = Integer.parseInt(lukija.nextLine())-1;
        sarake1 = Integer.parseInt(lukija.nextLine())-1;
        System.out.println("Anna kohderuudun rivi ja sarake");
        rivi2 = Integer.parseInt(lukija.nextLine())-1;
        sarake2 = Integer.parseInt(lukija.nextLine())-1;
        //boolean tulos = ruudukko.vaihdaRuudut(rivi1, sarake1, rivi2, sarake2);
        boolean tulos = peli.teeSiirto(rivi1, sarake1, rivi2, sarake2);
        if (!tulos) {
            System.out.println("Siirto ei mahdollinen!");
        } else {
            //ruudukko.taytaTyhjatRuudut();
            tulostaRuudukko(ruudukko);
        }
    }

    /**
     * Testikäyttöön oleva metodi, joka käsittelee yksittäisen ruudun, eli suorittaa
     * samantyyppisten ruutujen laskennan ja poistaa ne.
     * <p>
     * Tätä ei ole tarkoitus käyttää itse pelatessa.
     */
    private void lueRuudunKasittely() {
        int rivi1, sarake1;
        System.out.println("Anna rivi ja sarake: ");
        rivi1 = Integer.parseInt(lukija.nextLine())-1;
        sarake1 = Integer.parseInt(lukija.nextLine())-1;
        System.out.println("Käsitellään: " + rivi1 + ", " + sarake1);
        int tulos = ruudukko.kasitteleRuutu(rivi1, sarake1);
        ruudukko.teePoisto();
        tulostaRuudukko(ruudukko);
    }
    
    // Testikäyttöön, ei varsinaista peliä
    /**
     * Testikäyttöön oleva metodi, joka poistaa yksittäisen ruudun, eli nollaa sen.
     * <p>
     * Tätä ei ole tarkoitus käyttää itse pelaamiseen.
     */
    private void lueNollaus() {
        int rivi1, sarake1;
        System.out.println("Anna rivi ja sarake: ");
        rivi1 = Integer.parseInt(lukija.nextLine())-1;
        sarake1 = Integer.parseInt(lukija.nextLine())-1;
        System.out.println("Nollataan: " + rivi1 + ", " + sarake1);
        ruudukko.poistaRuutu(rivi1, sarake1);
        tulostaRuudukko(ruudukko);
    }
    
    /**
     * Tulostaa lyhyet ohjeet. 
     */
    private void tulostaOhje() {
        System.out.println("Käytössä olevat peruskomennot:");
        System.out.println("S = Siirron tekeminen:");
        System.out.println("    Tämän jälkeen annettava omille riveilleen lähderuudun");
        System.out.println("    rivin ja sarakkeen numero, ja samat tiedot kohderuudulle.");
        System.out.println("P = Poista tyhjät ruudut, tuomalla ylhäältä alaspäin ja arpomalla uusia");
        System.out.println("T = Peliruudukon tulostus uusiksi");
        System.out.println("O = Tulostaa nämä ohjeet");
        System.out.println("L = Lopetus (myös tyhjä rivi kelpaa)");
        System.out.println("HUOM! Jokaisen siirron jälkeen P:llä poistettava tyhjät ruudut ja suoritettava uusi käsitely");
        System.out.println("kunnes nollaruutuja ei enää näy.");
        System.out.println("Tämä tulee automaattiseksi, mutta toistaiseksi auttaa vielä hahmottamaan mitä ruudukossa tapahtuu");
        System.out.println("askel askeleelta.");
        System.out.println("");
    }
    
}

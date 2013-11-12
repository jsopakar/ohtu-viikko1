/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import java.awt.Point;
import java.util.ArrayList;

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
    
    //
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
    
    // Koordinaatiston suunta ja mietittävä, ei ehkä lopullinen...
    public Ruutu palautaRuutu(int rivi, int sarake) {
        return sisalto[rivi][sarake];
    }
    
    public int kerroKoko() {
        return this.koko;
    }
    
    // TODO: Tämä ei vielä tee mitään, järkevää tarvitsee kunnon logiikan
    // ja pilkkomisen fiksuihin osametodeihin. 
    
    //public void kasitteleRuutu(int x, int y) {
    public int kasitteleRuutu(int rivi, int sarake) { // tilapäisesti palauttaa samojen ruutujen määrän
        
        int samoja = 1;
        
        Ruutu tamaRuutu = this.palautaRuutu(rivi, sarake);
        
        //taulukko, johon kasataan 4 ilmansuuntaan lukumäärä, kuinka monta samaa
        // järjestys: vasen, oikea, ylä, ala
        int[] samaaSuuntiin = new int[4];
        
        int tempRivi = rivi-1; int tempSarake = sarake-1;
        
        //Vasen suunta:
        while (tempSarake >= 0 &&
                this.palautaRuutu(rivi, tempSarake).kerroTyyppi() == tamaRuutu.kerroTyyppi()) {
            samoja++;
            tempSarake--;
        }
                
        //Oikea suunta:
        tempSarake = sarake+1;
        while (tempSarake < this.koko &&
                this.palautaRuutu(rivi, tempSarake).kerroTyyppi() == tamaRuutu.kerroTyyppi()) {
            samoja++;
            tempSarake++;
        }
        
        // Yläsuunta
        tempRivi = rivi - 1;
        while (tempRivi >= 0 &&
                this.palautaRuutu(tempRivi, sarake).kerroTyyppi() == tamaRuutu.kerroTyyppi()) {
            samoja++;
            tempRivi--;
        }
        
        //Alasuunta
        tempRivi = rivi + 1;
        while (tempRivi < this.koko &&
                this.palautaRuutu(rivi, tempSarake).kerroTyyppi() == tamaRuutu.kerroTyyppi()) {
            
        }
        
        return samoja; // palautetaan vain samojen määrä, ei vielä tallenneta sijainteja
            
    }
    
    public boolean vaihdaRuudut(int rivi1, int sarake1, int rivi2, int sarake2) {
        if (siirtoMahdollinen(rivi1, sarake1, rivi2, sarake2)) {
            Ruutu r1 = sisalto[rivi1][sarake1];
            Ruutu r2 = sisalto[rivi2][sarake2];
            sisalto[rivi1][sarake1] = r2;
            sisalto[rivi2][sarake2] = r1;
            
            return true;
        } else {
            return false;
        }
    }
    
    // Metodi, joka katsoo onko pelaajan antama siirto mahdollinen
    public boolean siirtoMahdollinen(int x1, int y1, int x2, int y2) {
        boolean onOK = true;
        int arvo1 = sisalto[x1][y1].kerroTyyppi();
        int arvo2 = sisalto[x1][y2].kerroTyyppi();
        
        // Saman tyypin ruutuja ei voi vaihtaa keskenään
        if (arvo1 == arvo2) {
            onOK = false;
        }
        
        return onOK;
    }
    
    /* Yksittäisen ruudun poistava metodi */
    public void poistaRuutu(int sarake, int rivi) {
        this.sisalto[sarake][rivi] = new Ruutu(0);
    }
    
    public void poistaRuudut(ArrayList<Point> poistettavat) {
        for ( Point p : poistettavat) {
            poistaRuutu(p.x, p.y);
        }
    }
    
}

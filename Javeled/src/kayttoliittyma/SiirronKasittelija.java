/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import sovelluslogiikka.Peliruudukko;
import sovelluslogiikka.Pelitaso;
import sovelluslogiikka.Ruutu;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author jsopakar
 */
public class SiirronKasittelija implements ActionListener {

    private Pelitaso peli;
    private Ruutu ruutu;
    private Point sijainti;
    private Pelialue pelialue;
    private Tietoalue tietoalue;

    public SiirronKasittelija(Pelitaso pt, Ruutu r, Point sijainti, Pelialue pa, Tietoalue ta) {
        this.peli = pt;
        this.ruutu = r;
        this.sijainti = sijainti;
        this.pelialue = pa;
        this.tietoalue = ta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.print("Käsitellään klikkaus ");
        System.out.println("x:" + sijainti.x + ", y: " + sijainti.y);

        System.out.println(pelialue.lahdeValittu());

        if (!pelialue.lahdeValittu()) {
            pelialue.asetaLahde(sijainti.x, sijainti.y);
            System.out.println("Asetettiin lähderuutu");
        } else {
            if (false) { // TODO: käsittely jos klikattu samaa kuin lähde
                System.out.println("Klikattu samaa uudestaan!");
            } else {
                System.out.println("Käsitellään siirto");
                kasitteleSiirto();
                
            }
        }

        tulostaRuudukko(this.peli.getRuudukko());

    }

    private void kasitteleSiirto() {
        Point lahde = pelialue.getLahde();
        boolean onnistui;

        onnistui = peli.teeSiirto(lahde.x, lahde.y, sijainti.x, sijainti.y);

        if (onnistui) {
            System.out.println("Siirto tehty");
            peli.getRuudukko().taytaTyhjatRuudut();
            peli.getRuudukko().kasitteleKokoRuudukko();

            pelialue.nollaaLahde();

            this.paivitaPelialueenTiedot();
            pelialue.repaint();

            //TODO: Tietoalueen päivitys!
            paivitaTietoalueenTiedot();
            
        } else {
            //TODO: Äänimerkki jos siirto ei onnistunut
            System.out.println("Siirtoa ei voitu tehdä!");
        }
    }

    /**
     * Metodi, joka päivittää käyttöliittymäpanelin ruudukon nappuloiden
     * tiedot vastaamaan sovelluslogiikan ruudukkoa.
     */
    private void paivitaPelialueenTiedot() {
        Component[] komponentit = pelialue.getComponents();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int monesko = i * 10 + j;
                komponentit[monesko].setBackground(GraafinenKL.kerroTyypinVari(peli.getRuudukko().palautaRuutu(i, j).kerroTyyppi()));
            }
        }
    }
    
    private void paivitaTietoalueenTiedot() {
        System.out.println("Tietoalueen päivitys:");
        Component comp = tietoalue.getComponent(0);
        System.out.println(comp.getName());
    }

    /**
     * Tilapäinen metodi ruudukon tekstimuotoiseen tulostukseen.
     * <p>
     * debug-tarkoitukseen.
     * @param ruudukko 
     */
    private void tulostaRuudukko(Peliruudukko ruudukko) {
        int koko = ruudukko.kerroKoko();
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                System.out.print(ruudukko.palautaRuutu(i, j).kerroTyyppi());
            }
            System.out.println("");
        }
    }
}

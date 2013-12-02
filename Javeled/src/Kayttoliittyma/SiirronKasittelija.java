/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jsopakar
 */
public class SiirronKasittelija implements ActionListener {
    
    private Pelitaso peli;
    private Ruutu ruutu;
    private Point sijainti;
    private GraafinenKL kayttoliittyma;
    
    public SiirronKasittelija(Pelitaso pt, Ruutu r, Point sijainti, GraafinenKL kl) {
        this.peli = pt;
        this.ruutu = r;
        this.sijainti = sijainti;
        this.kayttoliittyma = kl;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Piip");
        System.out.println(ae.getActionCommand());
        System.out.println(ae.paramString());
        System.out.println();
        System.out.println("X:");
        System.out.println("Y:");
        System.out.println(kayttoliittyma.lahdeValittu());
        
        if (!kayttoliittyma.lahdeValittu()) {
            kayttoliittyma.asetaLahde(sijainti.x, sijainti.y);
        } else {
            if (false) { // TODO: käsittely jos klikattu samaa kuin lähde
                
            } else {
                kasitteleSiirto();
            }
        }
    }
    
    private void kasitteleSiirto() {
        Point lahde = kayttoliittyma.getLahde();
        boolean onnistui;
        
        onnistui = peli.teeSiirto(lahde.x, lahde.y, sijainti.x, sijainti.y);
        
        if (onnistui) {
            kayttoliittyma.nollaaLahde();
        } else {
            //TODO: Äänimerkki jos siirto ei onnistunut
        
        }
    }
        
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import sovelluslogiikka.Peliruudukko;
import sovelluslogiikka.Pelitaso;
import sovelluslogiikka.Ruutu;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jsopakar
 */
public class Pelialue extends JPanel {

    private Pelitaso peli;
    private Peliruudukko ruudukko;
    private Tietoalue tietoalue;
    private boolean lahdeValittu = false;
    private Point lahde;

    public Pelialue(Pelitaso peli, Tietoalue ta) {
        super(new GridLayout(10, 10));
        this.peli = peli;
        this.ruudukko = peli.getRuudukko();
        this.tietoalue = ta;
        luoKomponentit();
    }

    private void luoKomponentit() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int tyyppi = ruudukko.palautaRuutu(i, j).kerroTyyppi();
                JButton uusiRuutu = new JButton(Integer.toString(tyyppi));
                uusiRuutu.putClientProperty("ruutu", new Ruutu(6));

                SiirronKasittelija sk =
                        new SiirronKasittelija(peli,
                        ruudukko.palautaRuutu(i, j),
                        new Point(i, j),
                        this,
                        tietoalue);
                uusiRuutu.addActionListener(sk);
                uusiRuutu.setBackground(GraafinenKL.kerroTyypinVari(tyyppi));
                add(uusiRuutu);
            }
        }

    }

    public boolean lahdeValittu() {
        return this.lahdeValittu;
    }

    public Point getLahde() {
        return this.lahde;
    }

    public void asetaLahde(int rivi, int sarake) {
        lahde = new Point(rivi, sarake);
        lahdeValittu = true;
    }

    public void nollaaLahde() {
        lahde = null;
        lahdeValittu = false;
    }
}

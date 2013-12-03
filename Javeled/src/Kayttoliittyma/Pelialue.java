/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.*;
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
    private boolean lahdeValittu = false;
    private Point lahde;
//    private JFrame frame;

    public Pelialue(Pelitaso peli) {
        super(new GridLayout(10, 10));
        this.peli = peli;
        this.ruudukko = peli.getRuudukko();
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
                        this);
                uusiRuutu.addActionListener(sk);
                uusiRuutu.setBackground(kerroTyypinVari(tyyppi));
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

    public Color kerroTyypinVari(int tyyppi) {
        switch (tyyppi) {
            case 1:
                return Color.red;
            case 2:
                return Color.yellow;
            case 3:
                return Color.blue;
            case 4:
                return Color.green;
            case 5:
                return Color.orange;
            default:
                return Color.black;
        }
    }
    
    @Override
    public void repaint() {
        //this.removeAll();
        //luoKomponentit2();
        super.repaint();
    }

    private void luoKomponentit2() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int tyyppi = ruudukko.palautaRuutu(i, j).kerroTyyppi();
                JButton uusiRuutu = new JButton(Integer.toString(tyyppi));
                uusiRuutu.putClientProperty("ruutu", new Ruutu(6));

                SiirronKasittelija sk =
                        new SiirronKasittelija(peli,
                        ruudukko.palautaRuutu(i, j),
                        new Point(i, j),
                        this);
                uusiRuutu.addActionListener(sk);
                uusiRuutu.setBackground(kerroTyypinVari(tyyppi));
                add(uusiRuutu);
            }
        }

    }

}


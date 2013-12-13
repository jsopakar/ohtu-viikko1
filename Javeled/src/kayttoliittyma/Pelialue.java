package kayttoliittyma;

import sovelluslogiikka.Peliruudukko;
import sovelluslogiikka.Pelitaso;
import sovelluslogiikka.Ruutu;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Pelialueen sisältävä JPanel-laajennus. 
 * <p>
 * Sisältää 100 JButton-oliota, ei muuta varsinaista komponenttisisältöä.
 * @author jsopakar
 */
public class Pelialue extends JPanel {

    /**
     * Viittaus Pelitasoon.
     */
    private Pelitaso peli;
    
    /**
     * Suora viittaus pelin peliruudukkoon.
     */
    private Peliruudukko ruudukko;
    
    /**
     * Viittaus käyttöliittymän tietoalueeseen.
     */
    private Tietoalue tietoalue;
    
    /**
     * Tieto siitä, onko käyttäjä klikannut ruudukossa kertaalleen, merkkinä
     * siirron lähderuudusta.
     */
    private boolean lahdeValittu = false;
    
    /**
     * Jos käyttäjä on klikannut lähdruudun, sisältää tiedon sen koordinaateista.
     */
    private Point lahde;

    /*
     * Konstruktori, joka saa parametreinaan tarvittavat viitteet.
     */
    public Pelialue(Pelitaso peli, Tietoalue ta) {
        super(new GridLayout(10, 10));
        this.peli = peli;
        this.ruudukko = peli.getRuudukko();
        this.tietoalue = ta;
        luoKomponentit();
    }

    /**
     * JButton-komponenttien luonti.
     */
    private void luoKomponentit() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int tyyppi = ruudukko.palautaRuutu(i, j).kerroTyyppi();
                int pistearvo = ruudukko.palautaRuutu(i, j).pistearvo();
                JButton uusiRuutu = new JButton(Integer.toString(pistearvo));
                uusiRuutu.setOpaque(true);
                uusiRuutu.setBorderPainted(false);
                uusiRuutu.setFocusPainted(false);
                
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
    
    /**
     * 
     * @return onko lähderuutu valittu kerran klikkaamalla.
     */
    public boolean lahdeValittu() {
        return this.lahdeValittu;
    }

    /*
     * Kertoo mikä ruutu valittu lähderuuduksi.
     */
    public Point getLahde() {
        return this.lahde;
    }
    
    /**
     * Asettaa halutun ruudun lähderuuduksi.
     * @param rivi lähderuudun rivi
     * @param sarake lähderuudun sarake
     */
    public void asetaLahde(int rivi, int sarake) {
        lahde = new Point(rivi, sarake);
        lahdeValittu = true;
    }
    
    /**
     * Poistaa lähderuudun valinnan
     */
    public void nollaaLahde() {
        lahde = null;
        lahdeValittu = false;
    }
}

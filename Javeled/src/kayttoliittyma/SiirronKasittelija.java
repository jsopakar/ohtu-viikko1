package kayttoliittyma;

import java.awt.Color;
import sovelluslogiikka.Peliruudukko;
import sovelluslogiikka.Pelitaso;
import sovelluslogiikka.Ruutu;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * ActionListener-tyyppinen käsittelijä, joka huolehtii käyttäjän tekemän
 * siirtovalinnan käsittelemisestä.
 * @author 012616660
 */
public class SiirronKasittelija implements ActionListener {
    
    /**
     * Viite Pelitasoon.
     */
    private Pelitaso peli;
    
    /**
     * Kyseinen ruutu.
     */
    private Ruutu ruutu;
    
    /**
     * Minkä sijainnin käsittelijä on kyseessä.
     */
    private Point sijainti;
    
    /**
     * Viittaus pelialueeseen, sen päivittämistä varten siirron jälkeen.
     */
    private Pelialue pelialue;
    
    /**
     * Viittaus tietoalueesee, sen päivttämistä varten siirron jälkeen.
     */
    private Tietoalue tietoalue;

    /**
     * Konstruktori, tarvittavine viitteineen.
     * @param pt Pelitaso
     * @param r Ruutu
     * @param sijainti Ruudun sijaintitiedot
     * @param pa Pelialue
     * @param ta Tietoalue
     */
    public SiirronKasittelija(Pelitaso pt, Ruutu r, Point sijainti, Pelialue pa, Tietoalue ta) {
        this.peli = pt;
        this.ruutu = r;
        this.sijainti = sijainti;
        this.pelialue = pa;
        this.tietoalue = ta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // Jos siirrot loppuneet, ei tehdä mitään vaan kerrotaan vain dialogissa se
        if (peli.siirtojaJaljella() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Siirtoja ei enää jäljellä",
                    "Peli loppunut!", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        //System.out.print("Käsitellään klikkaus ");
        //System.out.println("x:" + sijainti.x + ", y: " + sijainti.y);

        boolean lahdeValittu = pelialue.lahdeValittu();

        if (!lahdeValittu) {
            pelialue.asetaLahde(sijainti.x, sijainti.y);
            paivitaRuutuValituksi(sijainti, true);

        } else {
            Point lahde = pelialue.getLahde();

            // Tarkastetaan ettei klikattu samaa ruutua uudestaan:
            if (lahde.equals(sijainti)) {
                //System.out.println("Klikattu samaa uudestaan!");
                this.paivitaRuutuValituksi(lahde, false);
                pelialue.nollaaLahde();
            } else {
                //System.out.println("Käsitellään siirto");
                kasitteleSiirto();

            }
        }

        // Konsoliin tulostus tarvittaessa debuggaukseen:
        //if (lahdeValittu) {
        //    tulostaRuudukko(this.peli.getRuudukko());
        //}

    }
    /**
     * Siirron käsittelyn hoitaminen.
     * <p>
     * Jos siirto onnistui, päivitetään peli-ja tietoalueen sisällöt.
     */
    private void kasitteleSiirto() {
        Point lahde = pelialue.getLahde();
        boolean onnistui;

        onnistui = peli.teeSiirto(lahde.x, lahde.y, sijainti.x, sijainti.y);

        if (onnistui) {
            //System.out.println("Siirto tehty");

            this.paivitaRuutuValituksi(lahde, false);
            pelialue.nollaaLahde();

            this.paivitaPelialueenTiedot();
            pelialue.repaint();

            this.paivitaTietoalueenTiedot();

            this.tilanTarkastelu();

        } else {
            //System.out.println("Siirtoa ei voitu tehdä!");
            
            this.paivitaRuutuValituksi(lahde, false);
            pelialue.nollaaLahde();
            
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * Metodi, joka päivittää käyttöliittymäpanelin ruudukon nappuloiden tiedot
     * vastaamaan sovelluslogiikan ruudukkoa.
     */
    private void paivitaPelialueenTiedot() {
        Component[] komponentit = pelialue.getComponents();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int monesko = i * 10 + j;
                JButton nappula = (JButton) komponentit[monesko];
                Ruutu r = peli.getRuudukko().palautaRuutu(i, j);
                String pistearvo = Integer.toString(r.pistearvo());
                Color ruutuvari = GraafinenKL.kerroTyypinVari(r.kerroTyyppi());
                nappula.setBackground(ruutuvari);
                nappula.setText(pistearvo);
            }
        }
    }

    /**
     * Päivittää tietoalueen tiedot, lähinnä siirtomäärän ja pistetilanteen.
     */
    private void paivitaTietoalueenTiedot() {

        tietoalue.siirtojaLabel.setText(Integer.toString(peli.siirtojaJaljella()));
        tietoalue.pisteitaLabel.setText(Integer.toString(peli.kerroPistemaara()));
    }

    /**
     * Tilapäinen metodi ruudukon tekstimuotoiseen tulostukseen konsoliin.
     * <p>
     * debug-tarkoitukseen.
     *
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

    /**
     * Metodi, jolla siirron jälkeen tarkastellaan, onko peli mennyt läpi yms.
     */
    private void tilanTarkastelu() {

        // Jos siirrot loppu:
        if (peli.siirtojaJaljella() <= 0) {
            System.out.println("PELI LOPPUI");
            int n = peli.kerroPistemaara();
            JOptionPane.showMessageDialog(null,
                    "Peli loppui, sait " + n + " pistettä!",
                    "Peli loppui!", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    /**
     * Metodi, joka merkitsee ruudun korostetuksi kun se on valittu lähteeksi.
     * <p>
     * Määritellään setBorderPainted- ja setSelected-arvoilla.
     * <p>
     * Samalla metodilla voidaan päivittää ruudun tila ei-valituksi.
     * @param ruutu haluttu ruutu
     * @param valituksi tieto siitä, merkataanko ruutu valituksi ei ei-valituksi
     */
    private void paivitaRuutuValituksi(Point ruutu, boolean valituksi ) {

            int monesko = ruutu.x * 10 + ruutu.y;
            Component[] komponentit = pelialue.getComponents();
            JButton nappula = (JButton) komponentit[monesko];
            nappula.setBorderPainted(valituksi);
            nappula.setSelected(valituksi);
    }
}

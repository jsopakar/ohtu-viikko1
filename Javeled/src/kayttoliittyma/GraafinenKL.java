package kayttoliittyma;

import sovelluslogiikka.Peliruudukko;
import sovelluslogiikka.Pelitaso;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Perusrunko pelin graafiselle käyttöliittymälle
 * @author 012616660
 */
public class GraafinenKL implements Runnable {
    
    /**
     * Pelitaso-olio, joka sisältää varsinaisen pelin ilmentymän.
     */
    Pelitaso peli;
    
    /**
     * Viittaus pelin ruudukko-olioon.
     */
    Peliruudukko ruudukko;
    
    /**
     * JPanelista periytyvä oma alueensa peliruudukolle.
     */
    private Tietoalue tietoalue;
    
    /**
     * JPanelista periytyvä oma alueensa pelin statussisällölle.
     */
    private Pelialue pelialue;
    
    private JFrame frame;
    
    /**
     * Konstruktori, joka luo molemmat sisältöalueet.
     */
    public GraafinenKL() {
        peli = new Pelitaso(1);
        ruudukko = peli.getRuudukko();
        
        this.tietoalue = new Tietoalue(peli);
        this.pelialue = new Pelialue(peli, tietoalue);
    }
    
    @Override
    public void run() {
        frame = new JFrame("Javeled");
        frame.setPreferredSize(new Dimension(430, 370));
        frame.setLocation(600,250);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        
        container.add(pelialue, BorderLayout.CENTER);
        container.add(tietoalue, BorderLayout.SOUTH);
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public static Color kerroTyypinVari(int tyyppi) {
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
}
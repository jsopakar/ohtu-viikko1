package kayttoliittyma;

import sovelluslogiikka.Peliruudukko;
import sovelluslogiikka.Pelitaso;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 * Perusrunko pelin graafiselle käyttöliittymälle
 * @author 012616660
 */
public class GraafinenKL implements Runnable {
    
    Pelitaso peli;
    Peliruudukko ruudukko;
    
    private Tietoalue tietoalue;
    private Pelialue pelialue;
    
    //private boolean lahdeValittu = false;
    //private Point lahde;
    
    private JFrame frame;
    
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
        
        //container.add(luoOtsikot(), BorderLayout.NORTH);
        
        container.add(pelialue, BorderLayout.CENTER);
        container.add(tietoalue, BorderLayout.SOUTH);
        
        //container.add(luoSiirtokomennot(), BorderLayout.SOUTH);
    }
    
    // Turhaksi jäävä tilapäinen metodi
    private JPanel luoOtsikot() {
        JPanel panel = new JPanel(new GridLayout(1, 4));
        
        panel.add(new JLabel("Siirtoja: "));
        JLabel siirtojaLabel = new JLabel();
        siirtojaLabel.setName("siirtoLabel");
        siirtojaLabel.setText(Integer.toString(peli.siirtojaJaljella()));
        panel.add(siirtojaLabel);
        
        panel.add(new JLabel("Pisteitä: "));
        JLabel pisteitaLabel = new JLabel();
        pisteitaLabel.setName("pisteLabel");
        pisteitaLabel.setText("Coming soon");
        panel.add(pisteitaLabel);
                
        return panel;
                
    }
    
    // Turhaksi jäävä tilapäinen metodi
    private JPanel luoSiirtokomennot() {
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.setLayout(layout);
        panel.add(new JLabel("Lähde: "));
        panel.add(new JLabel("X "));
        JTextField lahdeX = new JTextField();
        panel.add(lahdeX);
        panel.add(new JLabel("Y "));
        JTextField lahdeY = new JTextField();
        panel.add(lahdeY);
        panel.add(new JLabel("Kohde: "));
        panel.add(new JLabel("X "));
        JTextField kohdeX = new JTextField();
        panel.add(kohdeX);
        panel.add(new JLabel("Y "));
        JTextField kohdeY = new JTextField();
        panel.add(kohdeY);
        JButton kasitteleNappi = new JButton("Siirrä");
        panel.add(kasitteleNappi);
        
        return panel;
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

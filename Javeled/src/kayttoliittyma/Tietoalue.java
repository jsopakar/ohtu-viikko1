/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sovelluslogiikka.*;

/**
 *
 * @author jsopakar
 */
public class Tietoalue extends JPanel {
    
    private Pelitaso peli;
    
    public Tietoalue(Pelitaso peli) {
        super(new GridLayout(2, 4));
        this.peli = peli;
        luoKomponentit();
    }

    private void luoKomponentit() {

        this.add(new JLabel("Siirtoja: "));
        JLabel siirtojaLabel = new JLabel();

        siirtojaLabel.setName("siirtoLabel");
        siirtojaLabel.setText(Integer.toString(peli.siirtojaJaljella()));
        this.add(siirtojaLabel);

        this.add(new JLabel("Pisteitä: "));
        JLabel pisteitaLabel = new JLabel();

        pisteitaLabel.setName("pisteLabel");
        pisteitaLabel.setText("Coming soon");
        this.add(pisteitaLabel);
        
        // Toinen rivi:
        this.add(new JLabel("Toimintoja"));
        this.add(new JLabel("tulossa..."));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sovelluslogiikka.*;

/**
 * Pelin tietoalue, joka näyttää jäljellä olevat siirrot, pistemäärän
 * ja tarvittavat toimintopainikkeet.
 * @author 012616660
 */
public class Tietoalue extends JPanel implements ActionListener {
    
    private Pelitaso peli;
    
    protected JLabel siirtojaLabel;
    protected JLabel pisteitaLabel;
    
    protected JButton lopetaButton;
    
    public Tietoalue(Pelitaso peli) {
        super(new GridLayout(2, 4));
        this.peli = peli;
        luoKomponentit();
    }

    private void luoKomponentit() {

        this.add(new JLabel("Siirtoja: "));
        siirtojaLabel = new JLabel();

        siirtojaLabel.setName("siirtoLabel");
        siirtojaLabel.setText(Integer.toString(peli.siirtojaJaljella()));
        this.add(siirtojaLabel);

        this.add(new JLabel("Pisteitä: "));
        pisteitaLabel = new JLabel();

        pisteitaLabel.setName("pisteLabel");
        pisteitaLabel.setText(Integer.toString(peli.kerroPistemaara()));
        this.add(pisteitaLabel);
        
        // Toinen rivi:
        this.add(new JLabel("Toimintoja: "));
        
        lopetaButton = new JButton();
        lopetaButton.setText("Lopeta");
        lopetaButton.addActionListener(this);
        lopetaButton.setActionCommand("Lopeta");
        this.add(lopetaButton);
        
        this.add(new JLabel(""));
        this.add(new JLabel(""));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Lopeta-nappulan käsittely:
        if ("Lopeta".equals(e.getActionCommand())) {
            Container frame = lopetaButton.getParent();
            do
                frame = frame.getParent();
            while (!(frame instanceof JFrame));
            ((JFrame) frame).dispose();
            
        // Tuki muille komennoille jatkossa:
        } else if ("Uusi".equals(e.getActionCommand())) {
            // Runko uuden pelin luomiselle, tai uuden tason valitsemisen laukaisemiselle
        }
        
    }
    
}

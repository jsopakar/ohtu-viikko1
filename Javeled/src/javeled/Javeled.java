/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javeled;

import kayttoliittyma.GraafinenKL;
import kayttoliittyma.TekstiKL;
import javax.swing.SwingUtilities;

/**
 * Ohjelman käynnistävä luokka.
 * <p>
 * Käynnistää graafisen käyttöliittymän, mutta testivaiheen tekstipohjainen
 * käyttöliittymä on tarvittaessa mukana koodissa kommentoituna.
 * @author 012616660
 */
public class Javeled {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Javeled alpha");
        System.out.println("-------------\n");
        
        GraafinenKL klG= new GraafinenKL();
        SwingUtilities.invokeLater(klG);

        
        //TekstiKL klT = new TekstiKL();
        //klT.testipeli();
        
        
    }
}

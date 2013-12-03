/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javeled;

import kayttoliittyma.GraafinenKL;
import kayttoliittyma.TekstiKL;
import javax.swing.SwingUtilities;

/**
 *
 * @author jsopakar
 */
public class Javeled {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Javeled alpha");
        System.out.println("-------------\n");
        
        // Pelitaso peli = new Pelitaso();
        
        //TekstiKL klT = new TekstiKL();
        //klT.testipeli();

        
        GraafinenKL klG= new GraafinenKL();
        SwingUtilities.invokeLater(klG);
        
    }
}

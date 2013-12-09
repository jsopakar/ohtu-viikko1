/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 * Luokkarunko pelitasolle, joka tulee sisältämään yhden Peliruudukon,
 * ja muut kyseiseen tasoon liittyvät tiedot, kuten vuoromäärän, pistelaskun,
 * ja tiedon siitä milloin taso on läpäisty.
 * 
 * @author 012616660
 */

public class Pelitaso {
    
    private int tempTestikoko = 6;
    private int maksimiSiirtomaara = 10;
    
    private Peliruudukko ruudukko;
    private int siirtojaJaljella = maksimiSiirtomaara;
    
    private int vaadittuPistemaara;
    
    private Pistelasku pisteet;
    
    // Ilman parametria luodaan testikäyttöön esimerkkiruudukko
    /**
     * Oletuskonstruktori, joka luo pelitason esimerkkitestiruudukolla
     */
    public Pelitaso() {
        
        ruudukko = new Peliruudukko(tempTestikoko);
        ruudukko.taytaEsimerkkiruudukkoTesteihin();
        
        this.vaadittuPistemaara = 20;
    }
    
    /**
     * Kuormitettu konstruktori, jolla voi määritellä millainen kenttä ladataan
     * 
     * @param kentta kentän numero, 0=oletuspeli, -1=testausruudukko
     */
    public Pelitaso(int kentta) {
        ruudukko = new Peliruudukko(tempTestikoko);
        pisteet = new Pistelasku();
        
        switch (kentta) {
            case 0:     //Pelattavaruudukko
                ruudukko.taytaEsimerkkiPelattavaRuudukko();
                break;
            case -1:    //Testiruudukko
                ruudukko.taytaEsimerkkiruudukkoTesteihin();
                break;
            case 1:     // Isompi ruudukko
                ruudukko = new Peliruudukko(10);
                ruudukko.taytaRuudukkoSatunnaisesti();
                break;
            default:
                ruudukko.taytaEsimerkkiPelattavaRuudukko();
                break;
        }
    }
    
    /**
     * Kuormitettu konstruktori, jolle voi myös antaa pelitason maksimisiirtomäärän.
     * 
     * @param kentta kentän numero, 0=oletuspeli, -1=testausruudukko
     * @param siirtomaara maksimisiirtomäärä
     */
    public Pelitaso(int kentta, int siirtomaara) {
        this(kentta);
        this.maksimiSiirtomaara = siirtomaara;
        siirtojaJaljella = siirtomaara;
    }
    
    /**
     * 
     * @return Peliruudukko
     */
    public Peliruudukko getRuudukko() {
        return this.ruudukko;
    }
    
    /**
     *
     * @return Jäljellä oleva siirtomäärä
     */
    public int siirtojaJaljella() {
        return this.siirtojaJaljella;
    }
    
    /**
     * Metodi, joka vähentää jäljellä olevia siirtoja yhdellä. Kutsutaan hyväksytyn siirron yhteydessä.
     */
    public void vahennaSiirto() {
        this.siirtojaJaljella--;
    }
    
    /**
     * Varsinainen pelisiirron tekevä metodikutsu, jota käyttöliittymän on tarkoitus kutsua.
     * 
     * @param rivi1 ensimmäisen siirrettävän ruudun rivi
     * @param sarake1 ensimmäisen siirrettävän ruudun sarake
     * @param rivi2 toisen siirrettävän ruudun rivi
     * @param sarake2 toisen siirrettävän ruudun saraka
     * @return tieto, tehtiinkö siirto onnistuneesti
     */
    public boolean teeSiirto(int rivi1, int sarake1, int rivi2, int sarake2) {
        boolean tehty = false;
        if (!(siirtojaJaljella > 0)) {
            return false;
        }
        tehty = ruudukko.vaihdaRuudut(rivi1, sarake1, rivi2, sarake2, true);
        if (tehty) {
            vahennaSiirto();
            // siirronJalkikasittely(); Kunhan metodi tekee jotain...
        }
        return tehty;
    }
    
    /**
     * Metodi, joka suorittaa yksittäisen siirron jälkitarkastelun.
     * <p>
     * KESKEN
     */
    public void siirronJalkikasittely() {
        ruudukko.taytaTyhjatRuudut();
    }
    
    public int kerroPistemaara() {
        return this.pisteet.getPisteet();
    }
}

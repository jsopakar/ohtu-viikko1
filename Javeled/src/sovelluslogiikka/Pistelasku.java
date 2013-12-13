package sovelluslogiikka;

/**
 * Luokka pistelaskua varten.
 * <p>
 * Mahdollistaa myöhemmin monimutkaisemman logiikan sisällyttämisen
 * pistelaskuun. Toistaiseksi peli tukee vain pistelaskua, jossa
 * ei ole erikseen kentän läpäisyyn vaadittavaa pistemäärää asennettu.
 * @author 012616660
 */
public class Pistelasku {
    
    /**
     * Laskuri tämän hetkiselle pistemäärällä. Alkaa nollasta.
     */
    private int pisteitaTallahetkella;
    
    /**
     * Kenttä, jolla voidaan rakentaa kentän läpipääsyyn vaadittava pistemäärä.
     * <p>
     * Huom. Julkaisuversio ei käytä tätä vielä millään tavalla.
     */
    private int vaaditutPisteet;

    /**
     * Konstruktori, joka luo pistelaskun, jossa ei ole vaadittuja pisteitä
     * läpipääsyyn.
     */
    public Pistelasku() {
        this(-1);
    }
    
    /**
     * Konstruktori, joka tukee vaadittavien pisteiden antamista.
     * @param vaadittavatPisteet pelitason läpipääsyyn vaadittava pistemäärä
     */
    public Pistelasku(int vaadittavatPisteet) {
        this.vaaditutPisteet = vaadittavatPisteet;
        this.pisteitaTallahetkella = 0;
    }

    /**
     * 
     * @return tämänhetkinen pistemäärä
     */
    public int getPisteet() {
        return this.pisteitaTallahetkella;
    }
    
    /**
     * 
     * @return läpipääsyyn vaadittava pistemäärä
     */
    public int getVaaditutPisteet() {
        return this.vaaditutPisteet;
    }
    
    /**
     * Metodi pistemäärän kasvattamiseen.
     * @param pisteet lisättävä pistemäärä
     */
    public void lisaaPisteita(int pisteet) {
        this.pisteitaTallahetkella += pisteet;
    }
    
    /**
     * Metodi pistemäärän vähentämiseen.
     * <p>
     * Ei käytetä julkaisuversiossa, mukana vain tukena jatkoon.
     * @param pisteet vähennettävä pistemäärä
     */
    public void vahennaPisteita(int pisteet) {
        this.pisteitaTallahetkella -= pisteet;
        if (this.pisteitaTallahetkella < 0) {
            this.pisteitaTallahetkella = 0;
        }
    }

    /**
     * Metodi, jolla voi tarkastaa onko vaadittu pistemäärä saatu ja kenttä
     * läpäisty.
     * <p>
     * Jos vaadittua pistemäärää ei ole, palauttaa aina false.
     *
     * @return Onko vaadittu pistemäärä läpäisty
     */
    public boolean peliLapi() {
        boolean lapi = false;
        if (this.vaaditutPisteet > 0
                && this.pisteitaTallahetkella >= this.vaaditutPisteet) {
            lapi = true;
        }
        return lapi;
    }
}

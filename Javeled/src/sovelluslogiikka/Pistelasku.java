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

    private int pisteitaTallahetkella;
    private int vaaditutPisteet;

    /**
     * Konstruktri, joka luo pistelaskun, jossa ei ole vaadittuja pisteitä
     * läpipääsyyn.
     */
    public Pistelasku() {
        this(-1);
    }

    public Pistelasku(int vaadittavatPisteet) {
        this.vaaditutPisteet = vaadittavatPisteet;
        this.pisteitaTallahetkella = 0;
    }

    public int getPisteet() {
        return this.pisteitaTallahetkella;
    }
    
    public int getVaaditutPisteet() {
        return this.vaaditutPisteet;
    }

    public void lisaaPisteita(int pisteet) {
        this.pisteitaTallahetkella += pisteet;
    }

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

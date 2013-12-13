package sovelluslogiikka;

/**
 * Luokka yksittäistä peliruutua varten.
 * <p>
 * Sisältää kaiken yksittäisen ruutuun vaikuttavan tiedon.
 * @author 012616660
 */

/* Luokkarunko yksittäiselle peliruudulle
 * 
 */

public class Ruutu {
    
    private int tyyppi;
    private int pistearvo;
    
    /**
     * Konstruktori, joka luo halutun tyyppisen ruudun
     * @param tyyppi haluttu tyyppi
     */
    public Ruutu(int tyyppi) {
        this(tyyppi, 1);
    }
    
    /**
     * Konstruktori, joka luo halutun tyyppisen ruudun jollain pistearvolla.
     * @param tyyppi haluttu tyyppi
     * @param pistearvo ruudun antama pistemäärä
     */
    public Ruutu(int tyyppi, int pistearvo) {
        this.tyyppi = tyyppi;
        this.pistearvo = pistearvo;
    }
    
    /**
     * Kertoo ruudun tyypin
     * @return ruudun tyyppi
     */
    public int kerroTyyppi() {
        return this.tyyppi;
    }
    
    /**
     * Muuttaa ruudun tyypin.
     * <p>
     * Ei ainakaan vielä tarkastele tyypin sisällön järkevyyttä millään tavalla.
     * @param uusiTyyppi haluttu uusi ruututyyppi
     */
    public void asetaTyyppi(int uusiTyyppi) {
        this.tyyppi = uusiTyyppi;
    }
    
    /**
     * 
     * @return ruudun antama pistemäärä
     */
    public int pistearvo() {
        return this.pistearvo;
    }
    
    /**
     * Setteri ruudun pistearvolle
     * @param arvo haluttu pistearvo
     */
    public void asetaPistearvo(int arvo) {
        if (arvo > 0) {
            this.pistearvo = arvo;
        } else {
            this.pistearvo = 1;
        }
    }
    
}

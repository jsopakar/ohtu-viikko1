package sovelluslogiikka;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Runko peliruudukolle, jonka keskeinen tietosisältö on kaksiulotteinen
 * taulukko Ruutu-olioita.
 * <p>
 * Tämä luokka sisältää suurimman osan sovelluslogiikasta. Ruutujen vaihtoon ja
 * käsittelyyn liittyen.
 * 
 * @author 012616660
 */
public class Peliruudukko {
    
    /**
     * Vakio, joka kertoo kuinka monta eri perusruututyyppiä peliin kuuluu
     */
    public static final int TYYPPIMAARA = 5;
    
    /**
     * Vakio, joka kertoo millä todennäköisyydellä uusi arvottava ruutu on 2 pisteen arvoinen
     */
    public static final double TOD_2PISTETTA = 0.1;

    /**
     * Vakio, joka kertoo millä todennäköisyydellä uusi arvottava ruutu on 3 pisteen arvoinen
     */
    public static final double TOD_3PISTETTA = 0.05;

    /**
     * Vakio, joka kertoo millä todennäköisyydellä uusi arvottava ruutu on 5 pisteen arvoinen
     */
    public static final double TOD_5PISTETTA = 0.01;
            
    /**
     * Ruudukon koko, (koko x koko)-taulukko
     */
    private int koko;
    
    /**
     * Taulukollinen Ruutu-olioita.
     */
    private Ruutu[][] sisalto;
    
    /*
     * Pistelasku.
     * <p>
     * Huom. Sama viite kuin Pelitaso-luokalla on pistelaskuun.
     */
    private Pistelasku pisteet;
    
    /**
     * Luokan sisäinen tietovarasto poistettaville ruuduille, Point-taulukkona
     * koordinaattien tallentamiseen.
     */
    private ArrayList<Point> poistettavatRuudut =
            new ArrayList<Point>();
    
    /**
     * Konstruktori peliruudukon luomiseen.
     * <p>
     * Ruudukon pysty- ja kaakakoko ovat samat.
     * @param koko ruudukon koko (koko x koko)
     * @param pisteet viite Pelin Pistelasku-olioon
     */
    public Peliruudukko(int koko, Pistelasku pisteet) {
        this.koko = koko;
        sisalto = new Ruutu[koko][koko];
        this.pisteet = pisteet;
    }
    
    /**
     * Metodi, joka täyttää ruudukon satunnaisilla ruututyypeillä.
     */
    public void taytaRuudukkoSatunnaisesti() {
        for (int i = 0; i<koko; i++) {
            for (int j = 0; j<koko; j++ ) {
                int tyyppi = arvoRuututyyppi();
                while (!onKelvollinenUusiRuutu(i, j, tyyppi)) {
                    tyyppi = arvoRuututyyppi();
                }
                sisalto[i][j] = new Ruutu(tyyppi);
            }
        }
    }
    
    /**
     * Metodi, joka tarkastaa onko uusi arvottu ruutu tyypiltään sellainen,
     * joka ei aiheuta aiempien ruutujen kanssa poistoja.
     * <p>
     * Vertailee vain vasemmalta ylhäältä täytettyihin, olettaa että ruudukko
     * täytetään kokonaan ruutu kerrallaan.
     * @param rivi vertailtavan ruudun rivi
     * @param sarake vertailtavan ruudun sarake
     * @param uusiTyyppi vertailtavan ruudun testattava tyyppi
     * @return tieto, onko testattava tyyppi sopiva tähän kohtaan ruudukkoa
     */
    public boolean onKelvollinenUusiRuutu(int rivi, int sarake, int uusiTyyppi) {
        boolean onOk = true;
        if (rivi > 1) {
            if (sisalto[rivi-1][sarake].kerroTyyppi() == uusiTyyppi &&
                    sisalto[rivi-2][sarake].kerroTyyppi() == uusiTyyppi)
                onOk = false;
        }
        if (sarake > 1) {
            if (sisalto[rivi][sarake-1].kerroTyyppi() == uusiTyyppi &&
                    sisalto[rivi][sarake-2].kerroTyyppi() == uusiTyyppi)
                onOk = false;
        }
        return onOk;
    }
    
    /**
     * Metodi, joka täyttää ruudukon ennalta määritellyillä ruututyypeillä.
     * <p>
     * Tämä on tarkoitettu lähinnä JUnit-testien käyttöön, ei pelisisällöksi varsinaisesti.
     * Sisältää valmiiksi poistuvia ruutumuodostelmia.
     */
    public void taytaEsimerkkiruudukkoTesteihin() {
        Ruutu[][] uusiSisalto = new Ruutu[koko][koko];
        int[][] numerot  =
          { { 1, 1, 3, 2, 2, 1 },
            { 2, 1, 1, 1, 2, 3 },
            { 2, 1, 3, 2, 3, 3 },
            { 2, 1, 1, 3, 1, 1 },
            { 3, 3, 2, 2, 1, 1 },
            { 1, 2, 3, 1, 2, 3 } };
        
        for (int i = 0; i<koko; i++) {
            for (int j = 0; j<koko; j++) {
                uusiSisalto[i][j] = new Ruutu(numerot[i][j]);
            }
        }
        this.sisalto = uusiSisalto;
    }
    
    /**
     * Metodi, joka täyttää ruudukon esimerkkipelillä.
     * <p>
     * Erotuksena testiruudukkoon, tämä ei sisällä valmiiksi poistuvia yhdistelmiä,
     * ja tätä voidaan periaatteessa käyttää uutena pelinä. Suunniteltu peli tosin
     * käyttää satunnaista ruudukkoa, ei tätä.
     */
    public void taytaEsimerkkiPelattavaRuudukko() {
        Ruutu[][] uusiSisalto = new Ruutu[koko][koko];
        int[][] numerot  =
          { { 1, 1, 3, 2, 2, 1 },
            { 1, 2, 1, 1, 2, 3 },
            { 2, 1, 3, 2, 3, 3 },
            { 2, 1, 1, 3, 1, 1 },
            { 3, 3, 2, 2, 1, 1 },
            { 1, 2, 3, 1, 2, 3 } };
        
        for (int i = 0; i<koko; i++) {
            for (int j = 0; j<koko; j++) {
                uusiSisalto[i][j] = new Ruutu(numerot[i][j]);
            }
        }
        this.sisalto = uusiSisalto;
    }
    
    /**
     * Palauttaa halutun kohdan Ruutu-olion.
     * @param rivi halutun ruudun rivi
     * @param sarake halutun ruudun sarake
     * @return Ruutu-olio
     */
    public Ruutu palautaRuutu(int rivi, int sarake) {
        return sisalto[rivi][sarake];
    }
    
    /**
     * 
     * @return Ruudukon koko
     */
    public int kerroKoko() {
        return this.koko;
    }
    
    /**
     * Kertoo nykyisen pistetilanteen.
     * @return pistemäärä
     */
    public int pistetilanne() {
        return this.pisteet.getPisteet();
    }
    
    
    /**
     * Metodi, joka hoitaa varsinaisen ydintoiminnon, eli laskennan halutun
     * ruudun ympäriltä.
     * <p>
     * Aluksi lasketaan ruudun ympäriltä joka suunnalta, kuinka monta samaa tyyppiä
     * löytyy. Tämän tiedon pohjalta sitten lisätään poistettavatRuudut-olioon
     * kaikki kriteerit täyttävät oliot, eli suuntaansa on oltava 3 samaa tyyppiä,
     * jotta ne halutaan poistaa.
     * <p>
     * 
     * @param rivi käsiteltävän ruudun rivi
     * @param sarake käsiteltävän ruudun sarake
     * @return tieto kuinka monta ruutua merkataan poistettavaksi
     */
    public int kasitteleRuutu(int rivi, int sarake) {
        
        // Laskuri, että kuinka monta samaa tyyppiä käsiteltävän ruudun ympärillä on
        // itse käsiteltävä ruutu mukaanluettuna
        int samoja = 1;
        
        Ruutu tamaRuutu = this.palautaRuutu(rivi, sarake);
        
        //taulukko, johon kasataan 4 ilmansuuntaan lukumäärä, kuinka monta samaa
        // järjestys: vasen, oikea, ylä, ala
        int[] samaaSuuntiin = new int[4];
        
        int tempRivi = rivi-1; int tempSarake = sarake-1;
        
        //Vasen suunta:
        while (tempSarake >= 0 &&
                this.palautaRuutu(rivi, tempSarake).kerroTyyppi() == tamaRuutu.kerroTyyppi()) {
            samoja++;
            samaaSuuntiin[0]++;
            tempSarake--;
        }
                
        //Oikea suunta:
        tempSarake = sarake+1;
        while (tempSarake < this.koko &&
                this.palautaRuutu(rivi, tempSarake).kerroTyyppi() == tamaRuutu.kerroTyyppi()) {
            samoja++;
            samaaSuuntiin[1]++;
            tempSarake++;
        }
        
        // Yläsuunta
        tempRivi = rivi - 1;
        while (tempRivi >= 0 &&
                this.palautaRuutu(tempRivi, sarake).kerroTyyppi() == tamaRuutu.kerroTyyppi()) {
            samoja++;
            samaaSuuntiin[2]++;
            tempRivi--;
        }
        
        //Alasuunta
        tempRivi = rivi + 1;
        while (tempRivi < this.koko &&
                this.palautaRuutu(tempRivi, sarake).kerroTyyppi() == tamaRuutu.kerroTyyppi()) {
            samoja++;
            samaaSuuntiin[3]++;
            tempRivi++;
        }
        
        // Vaakaruutujen lisäys poistettaviin
        if (samaaSuuntiin[0] + samaaSuuntiin[1] >= 2) {
            for (int i = sarake - samaaSuuntiin[0]; i <= sarake + samaaSuuntiin[1]; i++) {
                poistettavatRuudut.add(new Point(rivi, i));
                
            }
        }
        
        // Pystyruudut poistettaviin:
        if (samaaSuuntiin[2] + samaaSuuntiin[3] >= 2) {
            for (int i = rivi - samaaSuuntiin[2]; i <= rivi + samaaSuuntiin[3]; i++) {
                poistettavatRuudut.add(new Point(i, sarake));
            }
        }
        return samoja; // palautetaan vain samojen määrä, sijainnit talletettu erikseen
    }
    
    /**
     * Metodi, joka vaihtaa kaksi ruutua keskenään.
     * <p>
     * Tämä metodi ei ota mitään kantaa osumien tarkasteluun tai ruutujen poistoon.
     * 
     * @param rivi1 ensimmäisen vaihdettavan ruudun rivi
     * @param sarake1 ensimmäisen vaihdettavan ruudun sarake
     * @param rivi2 toisen vaihdettavan ruudun rivi
     * @param sarake2 toisen vaihdettavan ruudun sarake
     * @return tieto onnistuiko vaihtaminen
     */
    public boolean vaihdaRuudut(int rivi1, int sarake1, int rivi2, int sarake2) {
        if (siirtoMahdollinen(rivi1, sarake1, rivi2, sarake2)) {
            Ruutu r1 = sisalto[rivi1][sarake1];
            Ruutu r2 = sisalto[rivi2][sarake2];
            sisalto[rivi1][sarake1] = r2;
            sisalto[rivi2][sarake2] = r1;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Kuormitettu metodi samannimisestä, jolle voi kertoa, tehdäänkö samalla
     * kertaa myös poistokäsittely.
     * 
     * @param rivi1 ensimmäisen vaihdettavan ruudun rivi
     * @param sarake1 ensimmäisen vaihdettavan ruudun sarake
     * @param rivi2 toisen vaihdettavan ruudun rivi
     * @param sarake2 toisen vaihdettavan ruudun sarake
     * @param teePoisto suoritetaanko poistokutsu samalla.
     * @return tieto onnistuiko vaihtaminen
     */
    public boolean vaihdaRuudut(int rivi1, int sarake1, int rivi2, int sarake2, boolean teePoisto) {
        boolean vaihdettu = vaihdaRuudut(rivi1, sarake1, rivi2, sarake2);
        if (teePoisto) {
            int eka = kasitteleRuutu(rivi1, sarake1);
            int toka = kasitteleRuutu(rivi2, sarake2);
            if (!poistettavatRuudut.isEmpty()) {
                teePoisto();
            } else {
                // Tilaa mahdolliselle reagoinnille jos poistoja ei tehdä.
            }
        }
        return vaihdettu;
    }

    
    /**
     * Metodi, joka tarkastaa onko käyttäjän antama siirto toteutettavissa.
     * <p>
     * Tarkastaa että siirrettävät ruudut ei ole samaa tyyppiä, ja että ne
     * ovat ruudukossa vierekkäisiä.
     * 
     * @param rivi1 ensimmäisen vaihdettavan ruudun rivi
     * @param sarake1 ensimmäisen vaihdettavan ruudun sarake
     * @param rivi2 toisen vaihdettavan ruudun rivi
     * @param sarake2 toisen vaihdettavan ruudun sarake
     * @return tieto siitä onko siirto mahdollinen
     */
    public boolean siirtoMahdollinen(int rivi1, int sarake1, int rivi2, int sarake2) {

        // Ruutujen täytyy olla vierekkäiset
        if (Math.abs(rivi1-rivi2) > 1 || Math.abs(sarake1-sarake2) > 1 ) {
            return false;
        }

        int arvo1 = sisalto[rivi1][sarake1].kerroTyyppi();
        int arvo2 = sisalto[rivi2][sarake2].kerroTyyppi();
        
        // Saman tyypin ruutuja ei voi vaihtaa keskenään
        if (arvo1 == arvo2) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Yksittäisen ruudun poistava metodi.
     * <p>
     * Lisää samalla yhden pisteen jokaista poistettua ruutua kohti. Ei huomio
     * mahdollisia ruutujen pistemääriä.
     * @param sarake poistettavan ruudun sarake
     * @param rivi poistettavan ruudun rivi
     */
    public void poistaRuutu(int sarake, int rivi) {
        
        int tamanPisteet = this.palautaRuutu(sarake, rivi).pistearvo();
        pisteet.lisaaPisteita(tamanPisteet);
        this.sisalto[sarake][rivi] = new Ruutu(0);
    }
    
    /**
     * Useamman ruudun poiston toteuttava metodi.
     * 
     * @param poistettavat ArrayList Point-oliota, jotka sisältävät koordinaatit
     */
    public void poistaRuudut(ArrayList<Point> poistettavat) {
        //System.out.println("Poistettavia: " + poistettavat.size());
        for ( Point p : poistettavat) {
            poistaRuutu(p.x, p.y);
        }
    }
    
    /**
     * Metodi, jolla hoidetaan siihen mennessä poistetuksi merkittävien ruutujen
     * poisto.
     * <p>
     * Toistaa poistoa tarpeeksi kauan, kunnes tyhjien ruutujen täytön jälkeen
     * ei enää ole poistuvia alueita.
     * 
     */
    public void teePoisto() {
        while (!poistettavatRuudut.isEmpty()) {
            
            poistaRuudut(poistettavatRuudut);
            poistettavatRuudut.clear();
            
            this.taytaTyhjatRuudut();
            this.kasitteleKokoRuudukko();
        }
    }
    
    /**
     * Metodi, joka käy koko taulukon läpi, ja täyttää tyhjät ruudut.
     * <p>
     * Kutsuu taytaRuutu-metodia joka kohdassa, jossa löytyy 0-tyypin ruutu.
     */
    public void taytaTyhjatRuudut() {
        for (int i = 0; i<koko; i++) {
            for (int j = 0; j<koko; j++) {
                if (sisalto[i][j].kerroTyyppi() == 0) {
                    taytaRuutu(i, j);
                }
            }
        }
    }
    
    /**
     * Metodi, jonka tarkoitus täyttää haluttu ruutu laskemalla sen yläpuolella olevia ruutuja yhdellä alaspäin.
     * <p>
     * Kutsuu rekursiivisesti itseään.
     * 
     * @param rivi käsiteltävän ruudun rivi
     * @param sarake käsiteltävän ruudun sarake
     * @return palauttaa kutsuttavan kohdan sisältämän ruudun
     */
    public Ruutu taytaRuutu(int rivi, int sarake) {
        Ruutu palautettava;
        if (rivi <0) {
            palautettava = arvoSatunnainenRuutu();
        } else {
            
            palautettava = sisalto[rivi][sarake];
            sisalto[rivi][sarake] = taytaRuutu(rivi-1, sarake);
            if (palautettava.kerroTyyppi() == 0) {
                palautettava = sisalto[rivi][sarake];
            }
        }
        return palautettava;
    }
    
    /**
     * Metodi, joka arpoo satunnaisen ruudun.
     * @return arvottu satunnainen ruutu
     */
    public Ruutu arvoSatunnainenRuutu() {
        
        int luku = arvoRuututyyppi();
        int pistearvo = arvoRuudunPistearvo();
        return new Ruutu(luku, pistearvo);
    }
    
    /**
     * Arpoo uudelle ruudulle pistearvon.
     * <p>Pistemäärien todennäköisyysarvot on määritelty luokassa vakioina.
     * @return arvottu pistearvo.
     */
    public int arvoRuudunPistearvo() {
        double r = Math.random();
        if (r < TOD_5PISTETTA) {
            return 5;
        } else if (r < TOD_3PISTETTA) {
            return 3;
        } else if (r < TOD_2PISTETTA) {
            return 2;
        } else {
            return 1;
        }
    }
    
    /**
     * Metodi, joka käy koko peliruudukon läpi, tarkastelee kaikki poistokriteerit
     * täyttävät ruudut.
     * <p>
     * Tätä on tarkoitus kutsua ainakin sen jälkeen, kun tyhjät ruudut on täytetty,
     * ja sitä kautta peliruudukkoon on voinut syntyä sattumanvaraisesti uusia
     * 3:n tai enemmän kattavia saman tyypin alueita.
     */
    public void kasitteleKokoRuudukko() {
        for (int i=0; i < koko; i++) {
            for (int j=0; j < koko; j++) {
                if (sisalto[i][j].kerroTyyppi() > 0) {
                    if (kasitteleRuutu(i, j) > 0) {
                        teePoisto();
                    }
                }
            }
        }
    }
    
    /**
     * Arpoo satunnaisen ruututyypin
     * @return ruututyyppi
     */
    private int arvoRuututyyppi() {
        return (int)(Math.random() * TYYPPIMAARA) + 1;
    }
    
}

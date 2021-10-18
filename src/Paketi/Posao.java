package Paketi;

public class Posao {

    
    private String naziv;
    public int satnica;
    private int vreme;
    private int brojKorisnika;
    private int id;
    
    public Posao(String naziv, int satnica, int vreme, int brojKorisnika) {
        this.naziv = naziv;
        this.satnica = satnica;
        this.vreme = vreme;
        this.brojKorisnika = brojKorisnika;
    }

    public Posao(int id, String naziv, int satnica, int vreme, int brojKorisnika) {
        this.id = id;
        this.naziv = naziv;
        this.satnica = satnica;
        this.vreme = vreme;
        this.brojKorisnika = brojKorisnika;
    }

    public Posao() {
    }

    public String getNaziv() {
        return naziv;
    }

    public int getSatnica() {
        return satnica;
    }

    public int getVreme() {
        return vreme;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setSatnica(int satnica) {
        this.satnica = satnica;
    }

    public void setVreme(int vreme) {
        this.vreme = vreme;
    }

    public int getBrojKorisnika() {
        return brojKorisnika;
    }

    public void setBrojKorisnika(int brojKorisnika) {
        this.brojKorisnika = brojKorisnika;
    }

    @Override
    public String toString() {
        return "Posao: " + "ID: " + id + ", Naziv: " + naziv + ", Satnica: " + satnica + ", Vreme(u danima): " + vreme + ", Broj radnika: " + brojKorisnika;
    }

}

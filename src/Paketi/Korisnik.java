package Paketi;

public class Korisnik {

    private int id;
    private String ime;
    private String prezime;
    private int godiste;
    private String firma;

    public Korisnik(int id, String ime, String prezime, int godiste, String firma) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.godiste = godiste;
        this.firma = firma;
    }

    public Korisnik(String ime, String prezime, int godiste, String firma) {
        this.ime = ime;
        this.prezime = prezime;
        this.godiste = godiste;
        this.firma = firma;
    }

    public Korisnik() {
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getGodiste() {
        return godiste;
    }

    public String getFirma() {
        return firma;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Korisnik:" + " ID: " + id + ", Ime: " + ime + ", Prezime: " + prezime + ", Godiste: " + godiste + ", Firma: " + firma;
    }

}

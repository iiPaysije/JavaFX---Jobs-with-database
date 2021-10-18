package Baza;

import com.sun.javafx.tk.Toolkit;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Paketi.Korisnik;

public class BazaKorisnik {

    private static java.sql.Connection konekcija = null;
    private static String url = "jdbc:mysql://localhost/projekat";
    private static String username = "root";
    private static String password = "";

    public static void insertKorisnik(Korisnik korisnik) {
        try {
            konekcija = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO korisnik(ime, prezime, godiste, firma) VALUES (?, ?,? ,?)";
            PreparedStatement stmt = konekcija.prepareStatement(query);
            stmt.setString(1, korisnik.getIme());
            stmt.setString(2, korisnik.getPrezime());
            stmt.setInt(3, korisnik.getGodiste());
            stmt.setString(4, korisnik.getFirma());

            stmt.execute();

            konekcija.close();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Korisnik unesen u bazu");

        } catch (SQLException e) {
            System.out.println("Greska u konekciji");
            Logger.getLogger(BazaKorisnik.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static List<Korisnik> procitaj() {
        List<Korisnik> listaKorisnika = new ArrayList<Korisnik>();
        try {
            konekcija = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM korisnik";
            Statement st = (Statement) konekcija.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                int godiste = rs.getInt("godiste");
                String firma = rs.getString("firma");
                listaKorisnika.add(new Korisnik(id, ime, prezime, godiste, firma));
            }
            st.close();
            konekcija.close();
        } catch (SQLException ex) {
            System.out.println("Greska u konekciji");
            ex.printStackTrace();
        }
        return listaKorisnika;
    }

    public static Korisnik getKorisnik(int id) {
        Korisnik toReturn = null;
        try {
            konekcija = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM korisnik WHERE id=" + id;
            Statement st = konekcija.createStatement();
            ResultSet rt = st.executeQuery(query);

            if (rt.next()) {
                toReturn = new Korisnik(id, rt.getString("ime"), rt.getString("prezime"), rt.getInt("godiste"), rt.getString("firma"));
            }

            rt.close();
            st.close();
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(BazaKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }

        return toReturn;
    }

   public static void obrisiKorisnika(int id) {
            try {
            konekcija = DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM korisnik WHERE id = ?";
            PreparedStatement stmt = konekcija.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Korisnik uspesno izbrisan", "", JOptionPane.INFORMATION_MESSAGE);
            konekcija.close();
            stmt.close();
        } catch (SQLException ex) {
           
            Logger.getLogger(BazaKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    public static void updateKorisnike(int ID, Korisnik korisnik) {
        try {
            konekcija = DriverManager.getConnection(url, username, password);
            String query = "UPDATE korisnik SET  ime = ?, prezime = ?, godiste=?, firma= ? WHERE ID = ?";
            PreparedStatement stmt = konekcija.prepareStatement(query);
            stmt.setString(1, korisnik.getIme());
            stmt.setString(2, korisnik.getPrezime());
            stmt.setInt(3, korisnik.getGodiste());
            stmt.setString(4, korisnik.getFirma());
            stmt.setInt(5, ID);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Uspesno azuriranje baze.");

            konekcija.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("MySql Connection error...");
            Logger.getLogger(BazaKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

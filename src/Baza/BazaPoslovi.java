package Baza;

import Baza.BazaKorisnik;
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
import Paketi.Posao;

public class BazaPoslovi {

    private static java.sql.Connection konekcija = null;
    private static String url = "jdbc:mysql://localhost/projekat";
    private static String username = "root";
    private static String password = "";

    public static void insertPosao(Posao posao) {
        try {
            konekcija = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO posao(naziv, satnica, vreme, brojKorisnika) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = konekcija.prepareStatement(query);
            stmt.setString(1, posao.getNaziv());
            stmt.setInt(2, posao.getSatnica());
            stmt.setInt(3, posao.getVreme());
            stmt.setInt(4, posao.getBrojKorisnika());

            stmt.execute();

            konekcija.close();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Posao unesen u bazu.", "", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Greska u konekciji", "", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(BazaKorisnik.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static List<Posao> procitajPoslove() {
        List<Posao> listaPoslova = new ArrayList<Posao>();
        try {
            konekcija = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM posao";
            Statement st = (Statement) konekcija.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                int satnica = rs.getInt("satnica");
                int vreme = rs.getInt("vreme");
                int brojKorisnika = rs.getInt("brojKorisnika");
                listaPoslova.add(new Posao(id, naziv, satnica, vreme, brojKorisnika));
            }
            st.close();
            konekcija.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Losa konekcija", "", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();
        }
        return listaPoslova;
    }

    public static List<Posao> procitajPosloveId(int proba) {
        List<Posao> listaPoslova = new ArrayList<>();
        try {
            konekcija = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM posao WHERE brojKorisnika = " + proba;

            PreparedStatement st = konekcija.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                int satnica = rs.getInt("satnica");
                int vreme = rs.getInt("vreme");
                int brojKorisnika = rs.getInt("brojKorisnika");
                listaPoslova.add(new Posao(id, naziv, satnica, vreme, brojKorisnika));
            }
            st.close();
            konekcija.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Losa konekcija", "", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();
        }
        return listaPoslova;
    }

    public static List<Posao> procitajPosaoId(int proba) {
        List<Posao> listaPoslova = new ArrayList<>();
        try {
            konekcija = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM posao WHERE id= " + proba;

            PreparedStatement st = konekcija.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                int satnica = rs.getInt("satnica");
                int vreme = rs.getInt("vreme");
                int brojKorisnika = rs.getInt("brojKorisnika");
                listaPoslova.add(new Posao(id, naziv, satnica, vreme, brojKorisnika));
            }
            st.close();
            konekcija.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Losa konekcija", "", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();
        }
        return listaPoslova;
    }

    public static void obrisiPosao(int id) {
        try {
            konekcija = DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM posao WHERE id = ?";
            PreparedStatement stmt = konekcija.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
            konekcija.close();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Posao uspesno obrisan iz baze.", "", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(BazaKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updatePosao(int ID, Posao posao) {
        try {
            konekcija = DriverManager.getConnection(url, username, password);
            String query = "UPDATE posao SET  naziv= ?, satnica= ?, vreme=?, brojKorisnika= ? WHERE ID = ?";
            PreparedStatement stmt = konekcija.prepareStatement(query);
            stmt.setString(1, posao.getNaziv());
            stmt.setInt(2, posao.getSatnica());
            stmt.setInt(3, posao.getVreme());
            stmt.setInt(4, posao.getBrojKorisnika());
            stmt.setInt(5, ID);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Uspesno azuriranje baze.", "", JOptionPane.INFORMATION_MESSAGE);
            konekcija.close();
            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "MySql Connection error....", "", JOptionPane.ERROR_MESSAGE);

            Logger.getLogger(BazaKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

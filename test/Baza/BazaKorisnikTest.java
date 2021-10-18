/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baza;

import Paketi.Korisnik;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dragica
 */
public class BazaKorisnikTest {
    
    public BazaKorisnikTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertKorisnik method, of class BazaKorisnik.
     */
    @Test
    public void testInsertKorisnik() {
        System.out.println("Test inserta korisnika");
        Korisnik korisnik = new  Korisnik("stojan", "Dragosavljevic", 1959, "firma1");
        BazaKorisnik.insertKorisnik(korisnik);
        System.out.println("Sve ok");
        assertNotEquals(korisnik, this);
    }

    /**
     * Test of procitaj method, of class BazaKorisnik.
     */
    @Test
    public void testProcitaj() {
        System.out.println("procitajTest");
        List<Korisnik> expResult =BazaKorisnik.procitaj();
        List<Korisnik> result = BazaKorisnik.procitaj();
        assertNotEquals(expResult, result);
        
        
    }

    /**
     * Test of getKorisnik method, of class BazaKorisnik.
     */
    @Test
    public void testGetKorisnik() {
        System.out.println("getKorisnikTest");
        int id = 0;
        Korisnik expResult = null;
        Korisnik result = BazaKorisnik.getKorisnik(id);
        assertEquals(expResult, result);
      
        
    }

    /**
     * Test of obrisiKorisnika method, of class BazaKorisnik.
     */
    @Test
    public void testObrisiKorisnika() {
        System.out.println("obrisiKorisnika");
        int id = 0;
        BazaKorisnik.obrisiKorisnika(id);
        
       
    }

    /**
     * Test of updateKorisnike method, of class BazaKorisnik.
     */
    @Test
    public void testUpdateKorisnike() {
        System.out.println("updateKorisnike");
        int ID = 0;
        Korisnik korisnik = new Korisnik("Pavle", "Aksentijevic", 1999 , "Firma2");
        BazaKorisnik.updateKorisnike(ID, korisnik);
        
       
    }
    
}

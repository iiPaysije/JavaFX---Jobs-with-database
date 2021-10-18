/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baza;

import Paketi.Posao;
import java.util.List;
import javax.swing.JOptionPane;
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
public class BazaPosloviTest {
    
    public BazaPosloviTest() {
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
     * Test of insertPosao method, of class BazaPoslovi.
     */
    @Test
    public void testInsertPosao() {
        System.out.println("insertPosao");
        Posao posao = new Posao(0 ,"Doamr", 20, 4, 3);
        BazaPoslovi.insertPosao(posao);
        JOptionPane.showMessageDialog(null, "Posao uspesno unsesn, test prosao");
    }

    /**
     * Test of procitajPoslove method, of class BazaPoslovi.
     */
    @Test
    public void testProcitajPoslove() {
        System.out.println("procitajPoslove");
        List<Posao> expResult = null;
        List<Posao> result = BazaPoslovi.procitajPoslove();
        assertNotEquals(expResult, result);
        
    }

    /**
     * Test of procitajPosloveId method, of class BazaPoslovi.
     */
    @Test
    public void testProcitajPosloveId() {
        System.out.println("procitajPosloveId");
        int proba = 0;
        List<Posao> expResult = BazaPoslovi.procitajPosloveId(proba);
        List<Posao> result = BazaPoslovi.procitajPosloveId(proba);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of procitajPosaoId method, of class BazaPoslovi.
     */
    @Test
    public void testProcitajPosaoId() {
        System.out.println("procitajPosaoId");
        int proba = 0;
        List<Posao> expResult = null;
        List<Posao> result = BazaPoslovi.procitajPosaoId(proba);
        assertNotEquals(expResult, result);
       
    }

    /**
     * Test of obrisiPosao method, of class BazaPoslovi.
     */
    @Test
    public void testObrisiPosao() {
        System.out.println("obrisiPosao");
        int id = 4;
        BazaPoslovi.obrisiPosao(id);
        
    }

    /**
     * Test of updatePosao method, of class BazaPoslovi.
     */
    @Test
    public void testUpdatePosao() {
        System.out.println("updatePosao");
        int ID = 0;
        Posao posao = null;
        BazaPoslovi.updatePosao(ID, posao);
        
    }
    
}

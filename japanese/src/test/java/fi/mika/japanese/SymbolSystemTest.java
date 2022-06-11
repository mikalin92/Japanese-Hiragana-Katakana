/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mika.japanese;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mika
 */
public class SymbolSystemTest {

    public SymbolSystemTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of searchForSymbol method, of class SymbolSystem.
     */
    @org.junit.jupiter.api.Test
    public void testSearchForSymbol() {
        System.out.println("searchForHiragana");
        SymbolSystem sys=new Katakana().sys;
        for (int i = 1; i < Katakana.westernNames.length - 1; i++) {
            String[] names = Katakana.westernNames[i].split("-");
            for (String name : names) {
                
                
                
                String result = sys.searchForWesternName(sys.searchForSymbol(name));
                assertEquals(name, result);

                
            }
        }

    }



}

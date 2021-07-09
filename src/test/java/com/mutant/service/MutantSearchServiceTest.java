package com.mutant.service;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mutant.service.MutantSearchService;
 
public class MutantSearchServiceTest {
 
    @Test
    @DisplayName("Test busqueda horizontal ok")
    public void busquedahorizontal() {
    	MutantSearchService mutantService = new MutantSearchService();
    	String[] dna = {"ACDV","ASDE","de","GGGG"};
    	String[] cadenaMutante = {"CCCC","TTTT","AAAA","GGGG"};
        assertEquals( mutantService.busquedaHorizontal( dna, cadenaMutante), true);
    }
    
    @Test
    @DisplayName("Test busqueda horizontal no")
    public void busquedahorizontal2() {
    	MutantSearchService mutantService = new MutantSearchService();
    	String[] dna = {"ACTG","CACT","ACTT","ACAC"};
    	String[] cadenaMutante = {"CCCC","TTTT","AAAA","GGGG"};
        assertEquals( mutantService.busquedaHorizontal( dna, cadenaMutante), false);
    }
    
    @Test
    @DisplayName("Test 1")
    public void busquedavertical() {
    	MutantSearchService mutantService = new MutantSearchService();
    	String[] dna = {"CCCC","CTTT","CAAA","CGGG"};
    	String[] cadenaMutante = {"CCCC","TTTT","AAAA","GGGG"};
        assertEquals( mutantService.busquedaVertical( dna, cadenaMutante), true);
    }
    
    @Test
    @DisplayName("Test 1")
    public void busquedavertical2() {
    	MutantSearchService mutantService = new MutantSearchService();
    	String[] dna = {"CCCC","TTTT","AAAA","GGGG"};
    	String[] cadenaMutante = {"CCCC","TTTT","AAAA","GGGG"};
        assertEquals( mutantService.busquedaVertical( dna, cadenaMutante), false);
    }
    
    @Test
    @DisplayName("Test 1")
    public void busquedadiagonalppl1() {
    	MutantSearchService mutantService = new MutantSearchService();
    	String[] dna = {"CCCC","TCTT","AACA","GGGC"};
    	String[] cadenaMutante = {"CCCC","TTTT","AAAA","GGGG"};
        assertEquals( mutantService.busquedaDiagonalPpal1( dna, cadenaMutante), true);
    }
    
    @Test
    @DisplayName("Test 1")
    public void busquedadiagonalppl11() {
    	MutantSearchService mutantService = new MutantSearchService();
    	String[] dna = {"CCCC","TTTT","AAAA","GGGG"};
    	String[] cadenaMutante = {"CCCC","TTTT","AAAA","GGGG"};
        assertEquals( mutantService.busquedaDiagonalPpal1( dna, cadenaMutante), false);
    }
    
    @Test
    @DisplayName("Test 1")
    public void busquedadiagonalppl2() {
    	MutantSearchService mutantService = new MutantSearchService();
    	String[] dna = {"CCCC","TTCT","ACAA","CGGG"};
    	String[] cadenaMutante = {"CCCC","TTTT","AAAA","GGGG"};
        assertEquals( mutantService.busquedaDiagonalPpal2( dna, cadenaMutante), true);
    }
    
    @Test
    @DisplayName("Test 1")
    public void busquedadiagonalppl21() {
    	MutantSearchService mutantService = new MutantSearchService();
    	String[] dna = {"CCCC","TTTT","AAAA","GGGG"};
    	String[] cadenaMutante = {"CCCC","TTTT","AAAA","GGGG"};
        assertEquals( mutantService.busquedaDiagonalPpal2( dna, cadenaMutante), false);
    }
}
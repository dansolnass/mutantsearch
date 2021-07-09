package com.mutant.controller;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.mutant.dto.DnaDTO;
import com.mutant.dto.StatisticsDTO;
import com.mutant.model.Statistics;
import com.mutant.repository.StatisticsRepository;
import com.mutant.service.IMutantSearchService;
import com.mutant.service.MutantSearchService;
 
public class MutantControllerTest {
 
    @Test
    @DisplayName("Test buscar mutante")
    public void buscarmutanteExitosoTest() {
    	MutantController mutantControllerTest = new MutantController();
    	String[] dna = {"ACCC","ACCC","ACCC","ACCC"};
    	String[] cadenaMutante = {"AAAA","TTTT","GGGG","CCCC"};
    	DnaDTO dnaDto = new DnaDTO();
    	dnaDto.setDna(dna);

    	Statistics statistics = new Statistics();
    	statistics.setProperty("VALOR_MUTANTES");
    	statistics.setValue(1);
    	Optional<Statistics> s = Optional.of(statistics);
    	IMutantSearchService imutantSearchService = mock(IMutantSearchService.class);
    	mutantControllerTest.setiMutantSearchService(imutantSearchService);
    	
    	StatisticsRepository statisticsRepository = mock(StatisticsRepository.class);
    	mutantControllerTest.setStatisticsRepository(statisticsRepository);
    	// Return interface
		when(imutantSearchService.busquedaHorizontal(dna, cadenaMutante)).thenReturn(true);
		
		when(imutantSearchService.busquedaVertical(dna, cadenaMutante)).thenReturn(true);
		
		when(imutantSearchService.busquedaDiagonalPpal1(dna, cadenaMutante)).thenReturn(true);
		
		when(imutantSearchService.busquedaDiagonalPpal2(dna, cadenaMutante)).thenReturn(true);
		
		when(statisticsRepository.findById("VALOR_MUTANTES")).thenReturn(s);
		statistics = new Statistics();
    	statistics.setProperty("VALOR_HUMANOS");
    	statistics.setValue(1);
    	s = Optional.of(statistics);
		when(statisticsRepository.findById("VALOR_HUMANOS")).thenReturn(s);
		
    	ResponseEntity<Object> responseTest =mutantControllerTest.mutantSearch(dnaDto);
        assertNotNull(responseTest);
    }
    
    @Test
    @DisplayName("Test buscar mutante null")
    public void buscarmutanteNullTest() {
    	MutantController mutantControllerTest = new MutantController();
    	String[] dna = {"ATGC","GAAA","ACGC","AGCG"};;
    	String[] cadenaMutante = {"AAAA","TTTT","GGGG","CCCC"};
    	DnaDTO dnaDto = new DnaDTO();
    	dnaDto.setDna(dna);

    	Statistics statistics = new Statistics();
    	statistics.setProperty("VALOR_MUTANTES");
    	statistics.setValue(1);
    	Optional<Statistics> s = Optional.of(statistics);
    	IMutantSearchService imutantSearchService = mock(IMutantSearchService.class);
    	mutantControllerTest.setiMutantSearchService(imutantSearchService);
    	
    	StatisticsRepository statisticsRepository = mock(StatisticsRepository.class);
    	mutantControllerTest.setStatisticsRepository(statisticsRepository);
    	// Return interface
		when(imutantSearchService.busquedaHorizontal(dna, cadenaMutante)).thenReturn(true);
		
		when(imutantSearchService.busquedaVertical(dna, cadenaMutante)).thenReturn(true);
		
		when(imutantSearchService.busquedaDiagonalPpal1(dna, cadenaMutante)).thenReturn(true);
		
		when(imutantSearchService.busquedaDiagonalPpal2(dna, cadenaMutante)).thenReturn(true);
		
		when(statisticsRepository.findById("VALOR_MUTANTES")).thenReturn(s);
		statistics = new Statistics();
    	statistics.setProperty("VALOR_HUMANOS");
    	statistics.setValue(1);
    	s = Optional.of(statistics);
		when(statisticsRepository.findById("VALOR_HUMANOS")).thenReturn(s);
		
    	ResponseEntity<Object> responseTest =mutantControllerTest.mutantSearch(dnaDto);
    	assertNotNull(responseTest);
    }
    
    @Test
    @DisplayName("Test consultat estadisticas")
    public void consultarEstadisticasTest() {
    	MutantController mutantControllerTest = new MutantController();
    	
    	
    	IMutantSearchService imutantSearchService = mock(IMutantSearchService.class);
    	mutantControllerTest.setiMutantSearchService(imutantSearchService);
    	
    	StatisticsRepository statisticsRepository = mock(StatisticsRepository.class);
    	mutantControllerTest.setStatisticsRepository(statisticsRepository);
    	// set v
    	Statistics statistics = new Statistics();
    	statistics.setProperty("VALOR_MUTANTES");
    	statistics.setValue(1);
    	Optional<Statistics> s = Optional.of(statistics);
		when(statisticsRepository.findById("VALOR_MUTANTES")).thenReturn(s);
		statistics = new Statistics();
    	statistics.setProperty("VALOR_HUMANOS");
    	statistics.setValue(1);
    	s = Optional.of(statistics);
		when(statisticsRepository.findById("VALOR_HUMANOS")).thenReturn(s);
		
    	StatisticsDTO responseTest =mutantControllerTest.stats();
        assertNotNull(responseTest);
    }
  
}
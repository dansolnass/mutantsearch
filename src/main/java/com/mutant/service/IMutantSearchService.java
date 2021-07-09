package com.mutant.service;

import org.springframework.stereotype.Component;

@Component
public interface IMutantSearchService {
	
	public boolean busquedaHorizontal(String[] dna, String[] cadenaMutante);
	
	public boolean busquedaVertical(String[] dna, String[] cadenaMutante);
	
	public boolean busquedaDiagonalPpal1(String[] dna, String[] cadenaMutante);
	
	public boolean busquedaDiagonalPpal2(String[] dna, String[] cadenaMutante);

}

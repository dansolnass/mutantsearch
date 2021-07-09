package com.mutant.service;

import org.springframework.stereotype.Service;

@Service(value = "MutantSearchService")
public class MutantSearchService implements IMutantSearchService{
	
	@Override
	public boolean busquedaHorizontal(String[] dna, String[] cadenaMutante){
		for(int i=0;i<dna.length;i++){
            for(int j=0;j<cadenaMutante.length;j++){
            	if (dna[i].toString().contains(cadenaMutante[j]))
            	{
            		return true;
            	}
            }
            
        }
		return false;
    }
	@Override
	public boolean busquedaVertical(String[] dna, String[] cadenaMutante){
		String cadena = "";
		for(int i=0;i<dna.length;i++){
			for(int j=0;j<dna.length;j++){
            	cadena = cadena + dna[j].substring(i,i+1);
        }
			
		 for(int c=0;c<cadenaMutante.length;c++){
			 if (cadena.contains(cadenaMutante[c]))
            	{
            		return true;
            	}
		 }
		 cadena = "";
        }
		return false;
    }
	@Override
	public boolean busquedaDiagonalPpal1(String[] dna, String[] cadenaMutante){
		String cadena = "";
		for(int i=0;i<dna.length;i++) {
            	cadena = cadena + dna[i].substring(i,i+1);
		}	

		for(int c=0;c<cadenaMutante.length;c++){
			 if (cadena.contains(cadenaMutante[c]))
           	{
           		return true;
           	}
		}
		return false;
    }
	@Override
	public boolean busquedaDiagonalPpal2(String[] dna, String[] cadenaMutante){
		String cadena = "";
		for(int i=0;i<dna.length;i++) {
			
				cadena = cadena + dna[i].substring(dna.length-(i+1),dna.length-i);
			
		}	

		for(int c=0;c<cadenaMutante.length;c++){
			 if (cadena.contains(cadenaMutante[c]))
           	{
           		return true;
           	}
		}
		return false;
    }

}

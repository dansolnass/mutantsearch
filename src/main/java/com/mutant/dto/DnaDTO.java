/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mutant.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {Insert class description here} *
 * @version $Revision: 1.0 $
 * @since Build {insert version here} 18/10/2018 03:37:27 PM
 * @author wcastelb  william.castelblanco.galindo@everis.com
 */ 
public class DnaDTO {

    public DnaDTO() {
        //This Construct Void
    }
    
    @Valid
    @NotNull
    @JsonProperty("dna")
    private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}
    
   

}

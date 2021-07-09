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
public class StatisticsDTO {

    public StatisticsDTO() {
        //This Construct Void
    }
    
    @Valid
    @NotNull
    @JsonProperty("count_mutant_dna")
    private int countMutantDna;

    @Valid
    @NotNull
    @JsonProperty("count_human_dna")
    private int countHumanDna;
    
    @Valid
    @NotNull
    @JsonProperty("ratio")
    private float ratio;

	public int getCountMutantDna() {
		return countMutantDna;
	}

	public void setCountMutantDna(int countMutantDna) {
		this.countMutantDna = countMutantDna;
	}

	public int getCountHumanDna() {
		return countHumanDna;
	}

	public void setCountHumanDna(int countHumanDna) {
		this.countHumanDna = countHumanDna;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
    
    
    

}

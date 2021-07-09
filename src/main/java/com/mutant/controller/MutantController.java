package com.mutant.controller;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mutant.dto.DnaDTO;
import com.mutant.dto.StatisticsDTO;
import com.mutant.model.Dna;
import com.mutant.model.Statistics;
import com.mutant.repository.*;
import com.mutant.service.IMutantSearchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;




@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class MutantController {
	private static final Logger LOG = Logger.getLogger(MutantController.class.getName());
	
	@Autowired
	IMutantSearchService iMutantSearchService;
	
	@Autowired
	StatisticsRepository statisticsRepository;
	
	@Autowired
	DnaRepository dnaRepository;
	
	@PostMapping("/mutant")
    public ResponseEntity mutantSearch(@RequestBody @Valid DnaDTO body) {
		String[] dna = body.getDna();
		String[] cadenaMutante = {"CCCC","TTTT","AAAA","GGGG"};
		int c = 0;
		
		if (iMutantSearchService.busquedaHorizontal(dna,cadenaMutante)) {
			c++;
		}
		if (iMutantSearchService.busquedaVertical(dna, cadenaMutante)) {
			c++;
		}
		if (iMutantSearchService.busquedaDiagonalPpal1(dna, cadenaMutante)){
			c++;
		}
		if (iMutantSearchService.busquedaDiagonalPpal2(dna, cadenaMutante)){
			c++;
		}
		if (c>1) {
			Optional<Statistics> s;
			s = statisticsRepository.findById("VALOR_MUTANTES");
			Statistics estadisticas = s.get();
			estadisticas.setValue(estadisticas.getValue()+1);
			statisticsRepository.save(estadisticas);
			Dna adn = new Dna();
			String jsonString = new com.google.gson.Gson().toJson(body);
			adn.setDna(jsonString);
			adn.setType("MUTANT");
			dnaRepository.save(adn);
			return new ResponseEntity<String>("", HttpStatus.OK);
			
		}else {
			Optional<Statistics> s;
			s = statisticsRepository.findById("VALOR_HUMANOS");
			Statistics estadisticas = s.get();
			estadisticas.setValue(estadisticas.getValue()+1);
			statisticsRepository.save(estadisticas);
			Dna adn = new Dna();
			String jsonString = new com.google.gson.Gson().toJson(body);
			adn.setDna(jsonString);
			adn.setType("HUMAN");
			dnaRepository.save(adn);
			return new ResponseEntity<String>("", HttpStatus.FORBIDDEN);
		}
	}
	
	@ApiOperation(value = "Consulta de stats", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
	@ApiResponse(code = 206, message = "Error en el servicio") })
	@RequestMapping(value = ("/stats"), method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public StatisticsDTO stats() {
		StatisticsDTO statisticsDto = new StatisticsDTO();
		Iterable<Dna> Mdnas = dnaRepository.findByType("MUTANT");
		statisticsDto.setCountMutantDna(IterableUtils.size(Mdnas));
		Iterable<Dna> Hdnas = dnaRepository.findByType("HUMAN");
		statisticsDto.setCountHumanDna(IterableUtils.size(Hdnas));
		if (IterableUtils.size(Hdnas) == 0) {
			statisticsDto.setRatio(0);
		}else {
			statisticsDto.setRatio((float) IterableUtils.size(Mdnas)/IterableUtils.size(Hdnas));
	}
        return statisticsDto;
	
	}



	public void setiMutantSearchService(IMutantSearchService iMutantSearchService) {
		this.iMutantSearchService = iMutantSearchService;
	}

	public void setStatisticsRepository(StatisticsRepository statisticsRepository) {
		this.statisticsRepository = statisticsRepository;
	}
	
	public void setDnaRepository(DnaRepository dnaRepository) {
		this.dnaRepository = dnaRepository;
	}
	
	
}

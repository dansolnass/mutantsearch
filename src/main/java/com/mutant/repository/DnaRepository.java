package com.mutant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mutant.model.Dna;
import com.mutant.model.Statistics;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DnaRepository extends CrudRepository<Dna, Integer> {

	Iterable<Dna> findByType(String type);


}
package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.Candidate;

public interface CandidateService {
	List<Candidate> findAll();

	Optional<Candidate> findById(Integer candId);

	//Candidate updateById(Integer candId);

	Candidate save(Candidate candidate);
}
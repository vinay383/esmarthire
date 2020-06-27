package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.Candidate;
import com.eSmartHire.repository.CandidateRepository;
import com.eSmartHire.service.CandidateService;

@Component
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateRepository candidateRepository;

	@Override
	public List<Candidate> findAll() {
		return candidateRepository.findAll();
	}

	@Override
	public Optional<Candidate> findById(Integer candId) {
		return candidateRepository.findById(candId);
	}

	/*
	 * @Override public Candidate updateById(Integer candId) { return null; }
	 */

	@Override
	public Candidate save(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

}
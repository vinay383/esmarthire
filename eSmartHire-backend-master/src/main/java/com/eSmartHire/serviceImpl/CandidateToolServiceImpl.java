package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTool;
import com.eSmartHire.repository.CandidateToolRepository;
import com.eSmartHire.service.CandidateToolService;

@Component
public class CandidateToolServiceImpl implements CandidateToolService {

	@Autowired
	CandidateToolRepository candidateToolRepository;

	@Override
	public CandidateTool save(CandidateTool candidateTool) {
		return candidateToolRepository.save(candidateTool);
	}

	@Override
	public List<CandidateTool> findAll() {
		return candidateToolRepository.findAll();
	}

	@Override
	public Optional<CandidateTool> findById(Integer candToolId) {
		return candidateToolRepository.findById(candToolId);
	}

}

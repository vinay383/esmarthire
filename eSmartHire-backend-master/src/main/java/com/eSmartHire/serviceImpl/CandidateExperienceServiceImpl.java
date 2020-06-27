package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateExperience;
import com.eSmartHire.repository.CandidateExperienceRepository;
import com.eSmartHire.service.CandidateExperienceService;

@Component
public class CandidateExperienceServiceImpl implements CandidateExperienceService {

	@Autowired
	CandidateExperienceRepository candidateExperienceRepository;

	@Override
	public CandidateExperience save(CandidateExperience candidateExperience) {
		return candidateExperienceRepository.save(candidateExperience);
	}

	@Override
	public List<CandidateExperience> findAll() {
		return candidateExperienceRepository.findAll();
	}

	@Override
	public Optional<CandidateExperience> findById(Integer candExpeId) {
		return candidateExperienceRepository.findById(candExpeId);
	}

}

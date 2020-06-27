package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateExperience;

public interface CandidateExperienceService {

	CandidateExperience save(CandidateExperience candidateExperience);

	List<CandidateExperience> findAll();

	Optional<CandidateExperience> findById(Integer candExpeId);

}

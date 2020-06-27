package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTemplateExperience;

public interface CandidateTemplateExperienceService {

	CandidateTemplateExperience save(CandidateTemplateExperience candidateTemplateExperience);

	List<CandidateTemplateExperience> findAll();

	Optional<CandidateTemplateExperience> findById(Integer ctExpeId);

}

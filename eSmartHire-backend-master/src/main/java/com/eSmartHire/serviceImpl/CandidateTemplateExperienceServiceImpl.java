package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTemplateExperience;
import com.eSmartHire.repository.CandidateTemplateExperienceRepository;
import com.eSmartHire.service.CandidateTemplateExperienceService;

@Component
public class CandidateTemplateExperienceServiceImpl implements CandidateTemplateExperienceService {

	@Autowired
	CandidateTemplateExperienceRepository candidateTemplateExperienceRepository;

	@Override
	public CandidateTemplateExperience save(CandidateTemplateExperience candidateTemplateExperience) {
		return candidateTemplateExperienceRepository.save(candidateTemplateExperience);
	}

	@Override
	public List<CandidateTemplateExperience> findAll() {
		return candidateTemplateExperienceRepository.findAll();
	}

	@Override
	public Optional<CandidateTemplateExperience> findById(Integer ctExpeId) {
		return candidateTemplateExperienceRepository.findById(ctExpeId);
	}

}

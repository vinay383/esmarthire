package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTemplateEducation;
import com.eSmartHire.repository.CandidateTemplateEducationRepository;
import com.eSmartHire.service.CandidateTemplateEducationService;

@Component
public class CandidateTemplateEducationServiceImpl implements CandidateTemplateEducationService {

	@Autowired
	CandidateTemplateEducationRepository candidateTemplateEducationRepository;

	@Override
	public CandidateTemplateEducation save(CandidateTemplateEducation candidateTemplateEducation) {
		return candidateTemplateEducationRepository.save(candidateTemplateEducation);
	}

	@Override
	public List<CandidateTemplateEducation> findAll() {
		return candidateTemplateEducationRepository.findAll();
	}

	@Override
	public Optional<CandidateTemplateEducation> findById(Integer ctEducId) {
		return candidateTemplateEducationRepository.findById(ctEducId);
	}

}

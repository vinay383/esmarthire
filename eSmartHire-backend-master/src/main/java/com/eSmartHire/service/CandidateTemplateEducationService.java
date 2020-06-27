package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTemplateEducation;

public interface CandidateTemplateEducationService {

	CandidateTemplateEducation save(CandidateTemplateEducation candidateTemplateEducation);

	List<CandidateTemplateEducation> findAll();

	Optional<CandidateTemplateEducation> findById(Integer ctEducId);

}

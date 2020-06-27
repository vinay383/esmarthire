package com.eSmartHire.service;

import java.util.Optional;

import com.eSmartHire.model.CandidateEducation;

public interface CandidateEducationService {

	CandidateEducation save(CandidateEducation candidateEducation);

	Object findAll();

	Optional<CandidateEducation> findById(Integer candEducId);

}

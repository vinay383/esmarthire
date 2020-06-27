package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTemplateProfile;

public interface CandidateTemplateProfileService {

	CandidateTemplateProfile save(CandidateTemplateProfile candidateTemplateProfile);

	List<CandidateTemplateProfile> findAll();

	Optional<CandidateTemplateProfile> findById(Integer ctProfId);

}

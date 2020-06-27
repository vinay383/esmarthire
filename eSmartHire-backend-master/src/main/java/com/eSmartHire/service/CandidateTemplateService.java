package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTemplate;

public interface CandidateTemplateService {

	CandidateTemplate save(CandidateTemplate candidateTemplate);

	List<CandidateTemplate> findAll();

	Optional<CandidateTemplate> findById(Integer candTempId);

}

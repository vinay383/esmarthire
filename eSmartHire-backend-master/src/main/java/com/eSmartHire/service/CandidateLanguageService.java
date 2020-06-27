package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateLanguage;

public interface CandidateLanguageService {

	// Object findAll();

	CandidateLanguage save(CandidateLanguage candidateLanguage);

	List<CandidateLanguage> findAll();

	Optional<CandidateLanguage> findById(Integer hobbId);

}

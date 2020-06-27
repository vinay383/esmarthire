package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTemplateLanguage;

public interface CandidateTemplateLanguageService {

	CandidateTemplateLanguage save(CandidateTemplateLanguage candidateTemplateLanguage);

	List<CandidateTemplateLanguage> findAll();

	Optional<CandidateTemplateLanguage> findById(Integer ctLangId);

}

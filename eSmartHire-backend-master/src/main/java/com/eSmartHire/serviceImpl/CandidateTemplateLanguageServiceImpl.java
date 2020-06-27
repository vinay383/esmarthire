package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTemplateLanguage;
import com.eSmartHire.repository.CandidateTemplateLanguageRepository;
import com.eSmartHire.service.CandidateTemplateLanguageService;

@Component
public class CandidateTemplateLanguageServiceImpl implements CandidateTemplateLanguageService {

	@Autowired
	CandidateTemplateLanguageRepository candidateTemplateLanguageRepository;

	@Override
	public CandidateTemplateLanguage save(CandidateTemplateLanguage candidateTemplateLanguage) {
		return candidateTemplateLanguageRepository.save(candidateTemplateLanguage);
	}

	@Override
	public List<CandidateTemplateLanguage> findAll() {
		return candidateTemplateLanguageRepository.findAll();
	}

	@Override
	public Optional<CandidateTemplateLanguage> findById(Integer ctLangId) {
		return candidateTemplateLanguageRepository.findById(ctLangId);
	}

}

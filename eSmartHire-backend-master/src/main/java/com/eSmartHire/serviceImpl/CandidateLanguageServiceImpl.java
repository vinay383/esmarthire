package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateLanguage;
import com.eSmartHire.repository.CandidateLanguageRepository;
import com.eSmartHire.service.CandidateLanguageService;

@Component
public class CandidateLanguageServiceImpl implements CandidateLanguageService {

	@Autowired
	CandidateLanguageRepository candidateLanguageRepository;

	@Override
	public CandidateLanguage save(CandidateLanguage candidateLanguage) {
		return candidateLanguageRepository.save(candidateLanguage);
	}

	@Override
	public Optional<CandidateLanguage> findById(Integer locationCityId) {
		return candidateLanguageRepository.findById(locationCityId);
	}

	@Override
	public List<CandidateLanguage> findAll() {
		return candidateLanguageRepository.findAll();
	}

}

package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTemplate;
import com.eSmartHire.repository.CandidateTemplateRepository;
import com.eSmartHire.service.CandidateTemplateService;

@Component
public class CandidateTemplateServiceImpl implements CandidateTemplateService {

	@Autowired
	CandidateTemplateRepository candidateTemplateRepository;

	@Override
	public CandidateTemplate save(CandidateTemplate candidateTemplate) {
		return candidateTemplateRepository.save(candidateTemplate);
	}

	@Override
	public List<CandidateTemplate> findAll() {
		return candidateTemplateRepository.findAll();
	}

	@Override
	public Optional<CandidateTemplate> findById(Integer candTempId) {
		return candidateTemplateRepository.findById(candTempId);
	}

}

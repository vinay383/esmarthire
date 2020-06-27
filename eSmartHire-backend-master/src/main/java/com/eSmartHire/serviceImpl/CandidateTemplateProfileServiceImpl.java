package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTemplateProfile;
import com.eSmartHire.repository.CandidateTemplateProfileRepository;
import com.eSmartHire.service.CandidateTemplateProfileService;

@Component
public class CandidateTemplateProfileServiceImpl implements CandidateTemplateProfileService {

	@Autowired
	CandidateTemplateProfileRepository candidateTemplateProfileRepository;

	@Override
	public CandidateTemplateProfile save(CandidateTemplateProfile candidateTemplateProfile) {
		return candidateTemplateProfileRepository.save(candidateTemplateProfile);
	}

	@Override
	public List<CandidateTemplateProfile> findAll() {
		return candidateTemplateProfileRepository.findAll();
	}

	@Override
	public Optional<CandidateTemplateProfile> findById(Integer ctProfId) {
		return candidateTemplateProfileRepository.findById(ctProfId);
	}
}

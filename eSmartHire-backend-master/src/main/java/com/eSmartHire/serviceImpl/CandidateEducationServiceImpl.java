package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateEducation;
import com.eSmartHire.repository.CandidateEducationRepository;
import com.eSmartHire.service.CandidateEducationService;


@Component
public class CandidateEducationServiceImpl implements CandidateEducationService {
	
	@Autowired
	CandidateEducationRepository candidateEducationRepository;
	
	
	@Override
	public CandidateEducation save(CandidateEducation candidateEducation) {
		return candidateEducationRepository.save(candidateEducation);
	}
	

	@Override
	public List<CandidateEducation> findAll() {
		return candidateEducationRepository.findAll();
	}
	
	@Override
	public Optional<CandidateEducation> findById(Integer candEducId) {
		return candidateEducationRepository.findById(candEducId);
	}


}

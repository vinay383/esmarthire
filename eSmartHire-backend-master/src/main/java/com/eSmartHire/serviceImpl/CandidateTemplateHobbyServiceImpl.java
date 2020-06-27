package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTemplateHobby;
import com.eSmartHire.repository.CandidateTemplateHobbyRepository;
import com.eSmartHire.service.CandidateTemplateHobbyService;

@Component
public class CandidateTemplateHobbyServiceImpl implements CandidateTemplateHobbyService {

	@Autowired
	CandidateTemplateHobbyRepository candidateTemplateHobbyRepository;

	@Override
	public CandidateTemplateHobby save(CandidateTemplateHobby candidateTemplateHobby) {
		return candidateTemplateHobbyRepository.save(candidateTemplateHobby);
	}

	@Override
	public List<CandidateTemplateHobby> findAll() {
		return candidateTemplateHobbyRepository.findAll();
	}

	@Override
	public Optional<CandidateTemplateHobby> findById(Integer ctHobbId) {
		return candidateTemplateHobbyRepository.findById(ctHobbId);
	}

}

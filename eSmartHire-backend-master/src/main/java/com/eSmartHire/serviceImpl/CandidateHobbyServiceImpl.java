package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateHobby;
import com.eSmartHire.repository.CandidateHobbyRepository;
import com.eSmartHire.service.CandidateHobbyService;

@Component
public class CandidateHobbyServiceImpl implements CandidateHobbyService {

	@Autowired
	CandidateHobbyRepository candidateHobbyRepository;

	@Override
	public CandidateHobby save(CandidateHobby candidateHobby) {
		return candidateHobbyRepository.save(candidateHobby);
	}

	@Override
	public List<CandidateHobby> findAll() {
		return candidateHobbyRepository.findAll();
	}

	@Override
	public Optional<CandidateHobby> findById(Integer candHobbId) {
		return candidateHobbyRepository.findById(candHobbId);
	}

}

package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateHobby;

public interface CandidateHobbyService {

	CandidateHobby save(CandidateHobby candidateHobby);

	List<CandidateHobby> findAll();

	Optional<CandidateHobby> findById(Integer candHobbId);

}

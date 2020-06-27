package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTemplateHobby;

public interface CandidateTemplateHobbyService {

	CandidateTemplateHobby save(CandidateTemplateHobby candidateTemplateHobby);

	List<CandidateTemplateHobby> findAll();

	Optional<CandidateTemplateHobby> findById(Integer ctHobbId);

}

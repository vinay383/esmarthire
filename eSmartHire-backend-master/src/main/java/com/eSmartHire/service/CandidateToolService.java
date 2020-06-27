package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTool;

public interface CandidateToolService {

	CandidateTool save(CandidateTool candidateTool);

	List<CandidateTool> findAll();

	Optional<CandidateTool> findById(Integer candToolId);

}

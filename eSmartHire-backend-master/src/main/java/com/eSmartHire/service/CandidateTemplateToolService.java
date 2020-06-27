package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTemplateTool;

public interface CandidateTemplateToolService {

	CandidateTemplateTool save(CandidateTemplateTool candidateTemplateTool);

	List<CandidateTemplateTool> findAll();

	Optional<CandidateTemplateTool> findById(Integer ctToolId);

}

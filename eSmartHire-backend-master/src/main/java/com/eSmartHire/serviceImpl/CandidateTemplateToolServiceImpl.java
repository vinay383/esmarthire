package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTemplateTool;
import com.eSmartHire.repository.CandidateTemplateToolRepository;
import com.eSmartHire.service.CandidateTemplateToolService;

@Component
public class CandidateTemplateToolServiceImpl implements CandidateTemplateToolService {

	@Autowired
	CandidateTemplateToolRepository candidateTemplateToolRepository;

	@Override
	public CandidateTemplateTool save(CandidateTemplateTool candidateTemplateTool) {
		return candidateTemplateToolRepository.save(candidateTemplateTool);
	}

	@Override
	public List<CandidateTemplateTool> findAll() {
		return candidateTemplateToolRepository.findAll();
	}

	@Override
	public Optional<CandidateTemplateTool> findById(Integer ctToolId) {
		return candidateTemplateToolRepository.findById(ctToolId);
	}

}

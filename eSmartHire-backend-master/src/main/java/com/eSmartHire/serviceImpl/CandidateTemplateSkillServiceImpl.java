package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTemplateSkill;
import com.eSmartHire.repository.CandidateTemplateSkillRepository;
import com.eSmartHire.service.CandidateTemplateSkillService;

@Component
public class CandidateTemplateSkillServiceImpl implements CandidateTemplateSkillService {

	@Autowired
	CandidateTemplateSkillRepository candidateTemplateSkillRepository;

	@Override
	public CandidateTemplateSkill save(CandidateTemplateSkill candidateTemplateSkill) {
		return candidateTemplateSkillRepository.save(candidateTemplateSkill);
	}

	@Override
	public List<CandidateTemplateSkill> findAll() {
		return candidateTemplateSkillRepository.findAll();
	}

	@Override
	public Optional<CandidateTemplateSkill> findById(Integer ctSkill) {
		return candidateTemplateSkillRepository.findById(ctSkill);
	}

}

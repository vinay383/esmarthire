package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTemplateSkill;

public interface CandidateTemplateSkillService {

	CandidateTemplateSkill save(CandidateTemplateSkill candidateTemplateSkill);

	List<CandidateTemplateSkill> findAll();

	Optional<CandidateTemplateSkill> findById(Integer ctSkill);

}

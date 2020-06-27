package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateSkill;

public interface CandidateSkillService {

	CandidateSkill save(CandidateSkill candidateSkill);

	List<CandidateSkill> findAll();

	Optional<CandidateSkill> findById(Integer candSkilId);

}

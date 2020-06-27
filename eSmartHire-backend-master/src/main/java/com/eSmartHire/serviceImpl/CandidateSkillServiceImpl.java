package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateSkill;
import com.eSmartHire.repository.CandidateSkillRepository;
import com.eSmartHire.service.CandidateSkillService;

@Component
public class CandidateSkillServiceImpl implements CandidateSkillService {

	@Autowired
	CandidateSkillRepository candidateSkillRepository;

	@Override
	public CandidateSkill save(CandidateSkill candidateSkill) {
		return candidateSkillRepository.save(candidateSkill);
	}

	@Override
	public List<CandidateSkill> findAll() {
		return candidateSkillRepository.findAll();
	}

	@Override
	public Optional<CandidateSkill> findById(Integer candSkilId) {
		return candidateSkillRepository.findById(candSkilId);
	}

}

package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTemplateAchievement;
import com.eSmartHire.repository.CandidateTemplateAchievementRepository;
import com.eSmartHire.service.CandidateTemplateAchievementService;

@Component
public class CandidateTemplateAchievementServiceImpl implements CandidateTemplateAchievementService {

	@Autowired

	CandidateTemplateAchievementRepository candidateTemplateAchievementRepository;

	@Override
	public CandidateTemplateAchievement save(CandidateTemplateAchievement candidateTemplateAchievement) {
		return candidateTemplateAchievementRepository.save(candidateTemplateAchievement);
	}

	@Override
	public List<CandidateTemplateAchievement> findAll() {
		return candidateTemplateAchievementRepository.findAll();
	}

	@Override
	public Optional<CandidateTemplateAchievement> findById(Integer ctAchiId) {
		return candidateTemplateAchievementRepository.findById(ctAchiId);
	}

}

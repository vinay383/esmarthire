package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateAchievement;
import com.eSmartHire.repository.CandidateAchievementRepository;
import com.eSmartHire.service.CandidateAchievementService;

@Component
public class CandidateAchievementServiceImpl implements CandidateAchievementService {

	@Autowired
	CandidateAchievementRepository candidateAchievementRepository;

	@Override
	public CandidateAchievement save(CandidateAchievement candidateAchievement) {
		return candidateAchievementRepository.save(candidateAchievement);
	}

	@Override
	public List<CandidateAchievement> findAll() {
		return candidateAchievementRepository.findAll();
	}

	@Override
	public Optional<CandidateAchievement> findById(Integer candAchiId) {
		return candidateAchievementRepository.findById(candAchiId);
	}

}

package com.eSmartHire.service;

import java.util.Optional;

import com.eSmartHire.model.CandidateAchievement;

public interface CandidateAchievementService {

	CandidateAchievement save(CandidateAchievement candidateAchievement);

	Object findAll();

	Optional<CandidateAchievement> findById(Integer candAchiId);

}

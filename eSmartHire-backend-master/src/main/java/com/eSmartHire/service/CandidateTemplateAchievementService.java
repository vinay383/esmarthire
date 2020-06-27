package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTemplateAchievement;

public interface CandidateTemplateAchievementService {

	CandidateTemplateAchievement save(CandidateTemplateAchievement candidateTemplateAchievementService);

	List<CandidateTemplateAchievement> findAll();

	Optional<CandidateTemplateAchievement> findById(Integer ctAchiId);

}

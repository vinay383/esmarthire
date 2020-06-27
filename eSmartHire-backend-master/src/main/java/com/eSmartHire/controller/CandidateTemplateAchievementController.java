package com.eSmartHire.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eSmartHire.common.JsonData;
import com.eSmartHire.exception.RecordNotFoundException;
import com.eSmartHire.model.CandidateTemplateAchievement;
import com.eSmartHire.service.CandidateTemplateAchievementService;

@RestController
@RequestMapping(value = "/api")
public class CandidateTemplateAchievementController {

	@Autowired
	CandidateTemplateAchievementService candidateTemplateAchievementService;

	@PostMapping(value = "/v1/candidate-template-achievements")
	public JsonData createcandidateTemplateAchievements(
			@RequestBody CandidateTemplateAchievement candidateTemplateAchievement) {

		System.out.println("name: " + candidateTemplateAchievement.getCtAchiCandTempId() + "title: "
				+ candidateTemplateAchievement.getCtAchiTitle() + "description: "
				+ candidateTemplateAchievement.getCtAchiDescription());
		return JsonData.SUCCESS_RESPONSE("candidate template achievements  created Successfully")
				.withData(candidateTemplateAchievementService.save(candidateTemplateAchievement));
	}

	@GetMapping(value = "/v1/candidate-template-achievements")
	public JsonData getCandidateTemplateAchievement() {
		return JsonData.SUCCESS_RESPONSE("All candidate template achievements  listed successfully")
				.withData(candidateTemplateAchievementService.findAll());
	}

	@GetMapping(value = "/v1/candidate-template-achievements/{id}")
	public JsonData getMasterHobbyById(@PathVariable("id") Integer ctAchiId) {
		Optional<CandidateTemplateAchievement> candidateTemplateAchievement = candidateTemplateAchievementService
				.findById(ctAchiId);

		if (!candidateTemplateAchievement.isPresent()) {
			throw new RecordNotFoundException("ctAchiId: " + ctAchiId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Hobby  by Id:" + ctAchiId + " listed Successfully")
				.withData(candidateTemplateAchievement.get());
	}

	@PutMapping(value = "/v1/candidate-template-achievements/{id}")
	public JsonData updateCandidateTemplateAchievementById(
			@RequestBody CandidateTemplateAchievement candidateTemplateAchievement,
			@PathVariable("id") Integer ctAchiId) {
		Optional<CandidateTemplateAchievement> candidateTemplateAchievementOptional = candidateTemplateAchievementService
				.findById(ctAchiId);

		if (!candidateTemplateAchievementOptional.isPresent()) {
			throw new RecordNotFoundException("ctAchiId" + ctAchiId);
		}

		candidateTemplateAchievement.setCtAchiId(ctAchiId);
		return JsonData.SUCCESS_RESPONSE()
				.withData(candidateTemplateAchievementService.save(candidateTemplateAchievement));
	}

}

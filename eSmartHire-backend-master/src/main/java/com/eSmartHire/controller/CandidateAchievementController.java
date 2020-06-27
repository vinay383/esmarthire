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
import com.eSmartHire.model.CandidateAchievement;
import com.eSmartHire.service.CandidateAchievementService;

@RestController
@RequestMapping(value = "/api")
public class CandidateAchievementController {

	@Autowired
	CandidateAchievementService candidateAchievementService;

	@PostMapping(value = "/v1/candidate-achievements")
	public JsonData createCandidateAchievements(@RequestBody CandidateAchievement candidateAchievement) {

		System.out.println(
				/* "Candidate Id: " + candidateAchievement.getCandAchiCandidateId()+ */"Candidate Achievement Name: "
						+ candidateAchievement.getCandAchiName() + "Achievement Held By: "
						+ candidateAchievement.getCandAchiHeldBy());
		return JsonData.SUCCESS_RESPONSE("Candidate Achievement created Successfully")
				.withData(candidateAchievementService.save(candidateAchievement));
	}

	@GetMapping(value = "/v1/candidate-achievements")
	public JsonData getCandidateAchievement() {
		return JsonData.SUCCESS_RESPONSE("All candidate achievements  listed successfully")
				.withData(candidateAchievementService.findAll());
	}

	@GetMapping(value = "/v1/candidate-achievements/{id}")
	public JsonData getCandidateAchievementById(@PathVariable("id") Integer candAchiId) {
		Optional<CandidateAchievement> candidateAchievement = candidateAchievementService.findById(candAchiId);

		if (!candidateAchievement.isPresent()) {
			throw new RecordNotFoundException("candAchiId: " + candAchiId);
		}

		return JsonData.SUCCESS_RESPONSE("Candidate Achievement   by Id:" + candAchiId + " listed Successfully")
				.withData(candidateAchievement.get());
	}

	@PutMapping(value = "/v1/candidate-achievements/{id}")
	public JsonData updateCandidateAchievementById(@RequestBody CandidateAchievement candidateAchievement,
			@PathVariable("id") Integer candAchiId) {
		Optional<CandidateAchievement> candidiateAchievementOptional = candidateAchievementService.findById(candAchiId);

		if (!candidiateAchievementOptional.isPresent()) {
			throw new RecordNotFoundException("candAchiId" + candAchiId);
		}

		candidateAchievement.setCandAchiId(candAchiId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateAchievementService.save(candidateAchievement));
	}

}

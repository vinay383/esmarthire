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
import com.eSmartHire.model.CandidateExperience;
import com.eSmartHire.service.CandidateExperienceService;

@RestController
@RequestMapping(value = "/api")
public class CandidateExperienceController {

	@Autowired
	CandidateExperienceService candidateExperienceService;

	@PostMapping(value = "/v1/candidate-experiences")
	public JsonData createCandidateExperiences(@RequestBody CandidateExperience candidateExperience) {

		System.out.println("name: " + candidateExperience.getCandExpeCandidateId() + "title: "
				+ candidateExperience.getCandExpeTitle() + "company: " + candidateExperience.getCandExpeCompany());
		return JsonData.SUCCESS_RESPONSE("Candidate Experience created Successfully")
				.withData(candidateExperienceService.save(candidateExperience));
	}

	@GetMapping(value = "/v1/candidate-experiences")
	public JsonData getCandidateExperience() {
		return JsonData.SUCCESS_RESPONSE("All candidate experiences  listed successfully")
				.withData(candidateExperienceService.findAll());
	}

	@GetMapping(value = "/v1/candidate-experiences/{id}")
	public JsonData getMasterHobbyById(@PathVariable("id") Integer candExpeId) {
		Optional<CandidateExperience> candidateExperience = candidateExperienceService.findById(candExpeId);

		if (!candidateExperience.isPresent()) {
			throw new RecordNotFoundException("candExpeId: " + candExpeId);
		}

		return JsonData.SUCCESS_RESPONSE("Candidate Experience  by Id:" + candExpeId + " listed Successfully")
				.withData(candidateExperience.get());
	}

	@PutMapping(value = "/v1/candidate-experiences/{id}")
	public JsonData updateMasterHobbyById(@RequestBody CandidateExperience candidateExperience,
			@PathVariable("id") Integer candExpeId) {
		Optional<CandidateExperience> candidateExperienceOptional = candidateExperienceService.findById(candExpeId);

		if (!candidateExperienceOptional.isPresent()) {
			throw new RecordNotFoundException("candExpeId" + candExpeId);
		}

		candidateExperience.setCandExpeId(candExpeId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateExperienceService.save(candidateExperience));
	}

}

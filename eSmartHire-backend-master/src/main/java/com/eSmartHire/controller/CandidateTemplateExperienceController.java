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
import com.eSmartHire.model.CandidateTemplateExperience;
import com.eSmartHire.service.CandidateTemplateExperienceService;

@RestController
@RequestMapping(value = "/api")
public class CandidateTemplateExperienceController {

	@Autowired
	CandidateTemplateExperienceService candidateTemplateExperienceService;

	@PostMapping(value = "/v1/candidate-template-experiences")
	public JsonData createCandidateTemplateExperiences(
			@RequestBody CandidateTemplateExperience candidateTemplateExperience) {

		System.out.println("temp id: " + candidateTemplateExperience.getCtExpeCandTempId() + "title: "
				+ candidateTemplateExperience.getCtExpeTitle() + "company : "
				+ candidateTemplateExperience.getCtExpeCompany() + " from: "
				+ candidateTemplateExperience.getCtExpeFrom() + " about: "
				+ candidateTemplateExperience.getCtExpeAbout());
		return JsonData.SUCCESS_RESPONSE("Master Hobby created Successfully")
				.withData(candidateTemplateExperienceService.save(candidateTemplateExperience));
	}

	@GetMapping(value = "/v1/candidate-template-experiences")
	public JsonData getCandidateTemplateExperience() {
		return JsonData.SUCCESS_RESPONSE("All candidate template experiences  listed successfully")
				.withData(candidateTemplateExperienceService.findAll());
	}

	@GetMapping(value = "/v1/candidate-template-experiences/{id}")
	public JsonData getCandidateTemplateExperienceById(@PathVariable("id") Integer ctExpeId) {
		Optional<CandidateTemplateExperience> candidateTemplateExperience = candidateTemplateExperienceService
				.findById(ctExpeId);

		if (!candidateTemplateExperience.isPresent()) {
			throw new RecordNotFoundException("ctExpeId: " + ctExpeId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Hobby  by Id:" + ctExpeId + " listed Successfully")
				.withData(candidateTemplateExperience.get());
	}

	@PutMapping(value = "/v1/candidate-template-experiences/{id}")
	public JsonData updateCandidateTemplateExperienceById(
			@RequestBody CandidateTemplateExperience candidateTemplateExperience,
			@PathVariable("id") Integer ctExpeId) {
		Optional<CandidateTemplateExperience> candidateTemplateExperienceOptional = candidateTemplateExperienceService
				.findById(ctExpeId);

		if (!candidateTemplateExperienceOptional.isPresent()) {
			throw new RecordNotFoundException("ctExpeId" + ctExpeId);
		}

		candidateTemplateExperience.setCtExpeId(ctExpeId);
		return JsonData.SUCCESS_RESPONSE()
				.withData(candidateTemplateExperienceService.save(candidateTemplateExperience));
	}

}

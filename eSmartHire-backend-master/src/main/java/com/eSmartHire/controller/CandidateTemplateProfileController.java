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
import com.eSmartHire.model.CandidateTemplateProfile;
import com.eSmartHire.service.CandidateTemplateProfileService;

@RestController
@RequestMapping(value = "/api")
public class CandidateTemplateProfileController {

	@Autowired
	CandidateTemplateProfileService candidateTemplateProfileService;

	@PostMapping(value = "/v1/candidate-template-profiles")
	public JsonData createCandidateTemplateProfiles(@RequestBody CandidateTemplateProfile candidateTemplateProfile) {

		System.out.println("name: " + candidateTemplateProfile.getCtProfCandTempId());
		return JsonData.SUCCESS_RESPONSE("Master Hobby created Successfully")
				.withData(candidateTemplateProfileService.save(candidateTemplateProfile));
	}

	@GetMapping(value = "/v1/candidate-template-profiles")
	public JsonData getCandidateTemplateProfile() {
		return JsonData.SUCCESS_RESPONSE("All candidate template profiles  listed successfully")
				.withData(candidateTemplateProfileService.findAll());
	}

	@GetMapping(value = "/v1/candidate-template-profiles/{id}")
	public JsonData getCandidateTemplateProfileById(@PathVariable("id") Integer ctProfId) {
		Optional<CandidateTemplateProfile> candidateTemplateProfile = candidateTemplateProfileService
				.findById(ctProfId);

		if (!candidateTemplateProfile.isPresent()) {
			throw new RecordNotFoundException("ctProfId: " + ctProfId);
		}

		return JsonData.SUCCESS_RESPONSE("candidate template profiles  by Id:" + ctProfId + " listed Successfully")
				.withData(candidateTemplateProfile.get());
	}

	@PutMapping(value = "/v1/candidate-template-profiles/{id}")
	public JsonData updateMasterHobbyById(@RequestBody CandidateTemplateProfile candidateTemplateProfile,
			@PathVariable("id") Integer ctProfId) {
		Optional<CandidateTemplateProfile> candidateTemplateProfileOptional = candidateTemplateProfileService
				.findById(ctProfId);

		if (!candidateTemplateProfileOptional.isPresent()) {
			throw new RecordNotFoundException("ctProfId" + ctProfId);
		}

		candidateTemplateProfile.setCtProfId(ctProfId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateTemplateProfileService.save(candidateTemplateProfile));
	}

}

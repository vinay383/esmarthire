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
import com.eSmartHire.model.CandidateTemplateEducation;
import com.eSmartHire.service.CandidateTemplateEducationService;

@RestController
@RequestMapping(value = "/api")
public class CandidateTemplateEducationController {

	@Autowired
	CandidateTemplateEducationService candidateTemplateEducationService;

	@PostMapping(value = "/v1/candidate-template-educations")
	public JsonData createCandidateTemplateEducations(
			@RequestBody CandidateTemplateEducation candidateTemplateEducation) {

		System.out.println("candidate temp id: " + candidateTemplateEducation.getCtEducCandTempId()
				+ "education institute: " + candidateTemplateEducation.getCtEducInstitution() + "education standard: "
				+ candidateTemplateEducation.getCtEducStandard() + "education university: "
				+ candidateTemplateEducation.getCtEducUniversity() + "percentage: "
				+ candidateTemplateEducation.getCtEducPercentage() + " project: "
				+ candidateTemplateEducation.getCtEducProject());
		return JsonData.SUCCESS_RESPONSE("candidate template education created successfully")
				.withData(candidateTemplateEducationService.save(candidateTemplateEducation));

	}

	@GetMapping(value = "/v1/candidate-template-educations")
	public JsonData getCandidateTemplateEducation() {
		return JsonData.SUCCESS_RESPONSE("All candidate template educations listed successfully")
				.withData(candidateTemplateEducationService.findAll());
	}

	@GetMapping(value = "/v1/candidate-template-educations/{id}")
	public JsonData getCandidateTemplateEducationById(@PathVariable("id") Integer ctEducId) {
		Optional<CandidateTemplateEducation> candidateTemplateEducation = candidateTemplateEducationService
				.findById(ctEducId);

		if (!candidateTemplateEducation.isPresent()) {
			throw new RecordNotFoundException("ctEducId: " + ctEducId);
		}

		return JsonData.SUCCESS_RESPONSE("Candidate Template Education  by Id:" + ctEducId + " listed Successfully")
				.withData(candidateTemplateEducation.get());
	}

	@PutMapping(value = "/v1/candidate-template-educations/{id}")
	public JsonData updateCandidateTemplateEducationById(
			@RequestBody CandidateTemplateEducation candidateTemplateEducation, @PathVariable("id") Integer ctEducId) {
		Optional<CandidateTemplateEducation> candidateTemplateEducationOptional = candidateTemplateEducationService
				.findById(ctEducId);

		if (!candidateTemplateEducationOptional.isPresent()) {
			throw new RecordNotFoundException("ctEducId" + ctEducId);
		}

		candidateTemplateEducation.setCtEducId(ctEducId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateTemplateEducationService.save(candidateTemplateEducation));
	}

}

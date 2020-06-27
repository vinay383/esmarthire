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
import com.eSmartHire.model.CandidateEducation;
import com.eSmartHire.service.CandidateEducationService;

@RestController
@RequestMapping(value = "/api")
public class CandidateEducationController {

	@Autowired
	CandidateEducationService candidateEducationService;

	@PostMapping(value = "/v1/candidate-educations")
	public JsonData createCandidateEducations(@RequestBody CandidateEducation candidateEducation) {

		System.out.println("education candidate id: " + candidateEducation.getCandEducCandidateId()
				+ "university: Institution: " + candidateEducation.getCandEducInstitution() + "university: "
				+ candidateEducation.getCandEducUniversity() + "name: " + candidateEducation.getCandEducFrom()
				+ "Education to: " + candidateEducation.getCandEducTo());
		return JsonData.SUCCESS_RESPONSE("Candidate Education created Successfully")
				.withData(candidateEducationService.save(candidateEducation));
	}

	@GetMapping(value = "/v1/candidate-educations")
	public JsonData getCandidateEducation() {
		return JsonData.SUCCESS_RESPONSE("All candidate education  listed successfully")
				.withData(candidateEducationService.findAll());
	}

	@GetMapping(value = "/v1/candidate-educations/{id}")
	public JsonData getCandidateEducationById(@PathVariable("id") Integer candEducId) {
		Optional<CandidateEducation> candidateEducation = candidateEducationService.findById(candEducId);

		if (!candidateEducation.isPresent()) {
			throw new RecordNotFoundException("candEducId: " + candEducId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Hobby  by Id:" + candEducId + " listed Successfully")
				.withData(candidateEducation.get());
	}

	@PutMapping(value = "/v1/candidate-educations/{id}")
	public JsonData updateCandidateEducationById(@RequestBody CandidateEducation candidateEducation,
			@PathVariable("id") Integer candEducId) {
		Optional<CandidateEducation> candidateEducationOptional = candidateEducationService.findById(candEducId);

		if (!candidateEducationOptional.isPresent()) {
			throw new RecordNotFoundException("candEducId" + candEducId);
		}

		candidateEducation.setCandEducId(candEducId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateEducationService.save(candidateEducation));
	}

}

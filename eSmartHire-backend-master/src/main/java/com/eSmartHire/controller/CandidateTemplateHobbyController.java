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
import com.eSmartHire.model.CandidateTemplateHobby;
import com.eSmartHire.service.CandidateTemplateHobbyService;

@RestController
@RequestMapping(value = "/api")
public class CandidateTemplateHobbyController {

	@Autowired
	CandidateTemplateHobbyService candidateTemplateHobbyService;

	@PostMapping(value = "/v1/candidate-template-hobbies")
	public JsonData createCandidateTemplateHobbies(@RequestBody CandidateTemplateHobby candidateTemplateHobby) {

		System.out.println("temp id: " + candidateTemplateHobby.getCtHobbCandTempId() + "hobby id:"
				+ candidateTemplateHobby.getCtHobbMasterHobbyId());
		return JsonData.SUCCESS_RESPONSE("Candidate Template  Hobby created Successfully")
				.withData(candidateTemplateHobbyService.save(candidateTemplateHobby));
	}

	@GetMapping(value = "/v1/candidate-template-hobbies")
	public JsonData getCandidateTemplateHobby() {
		return JsonData.SUCCESS_RESPONSE("All candidate template Hobbiess  listed successfully")
				.withData(candidateTemplateHobbyService.findAll());
	}

	@GetMapping(value = "/v1/candidate-template-hobbies/{id}")
	public JsonData getMasterHobbyById(@PathVariable("id") Integer ctHobbId) {
		Optional<CandidateTemplateHobby> candidateTemplateHobby = candidateTemplateHobbyService.findById(ctHobbId);

		if (!candidateTemplateHobby.isPresent()) {
			throw new RecordNotFoundException("ctHobbId: " + ctHobbId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Hobby  by Id:" + ctHobbId + " listed Successfully")
				.withData(candidateTemplateHobby.get());
	}

	@PutMapping(value = "/v1/candidate-template-hobbies/{id}")
	public JsonData updateCandidateTemplateHobbyById(@RequestBody CandidateTemplateHobby candidateTemplateHobby,
			@PathVariable("id") Integer ctHobbId) {
		Optional<CandidateTemplateHobby> candidateTemplateHobbyOptional = candidateTemplateHobbyService
				.findById(ctHobbId);

		if (!candidateTemplateHobbyOptional.isPresent()) {
			throw new RecordNotFoundException("ctHobbId" + ctHobbId);
		}

		candidateTemplateHobby.setCtHobbId(ctHobbId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateTemplateHobbyService.save(candidateTemplateHobby));
	}

}

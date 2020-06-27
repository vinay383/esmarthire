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
import com.eSmartHire.model.CandidateHobby;
import com.eSmartHire.service.CandidateHobbyService;

@RestController
@RequestMapping(value = "/api")
public class CandidateHobbyController {

	@Autowired
	CandidateHobbyService candidateHobbyService;;

	@PostMapping(value = "/v1/candidate-hobbies")
	public JsonData createCandidateHobbies(@RequestBody CandidateHobby candidateHobby) {

		System.out.println("candidate id: " + candidateHobby.getCandHobbCandidateId() + "master hobby id: "
				+ candidateHobby.getCandHobbMasterHobbyId());
		return JsonData.SUCCESS_RESPONSE("Candidate Hobby created Successfully")
				.withData(candidateHobbyService.save(candidateHobby));
	}

	@GetMapping(value = "/v1/candidate-hobbies")
	public JsonData getCandidateHobby() {
		return JsonData.SUCCESS_RESPONSE("All candidate Hobbiess  listed successfully")
				.withData(candidateHobbyService.findAll());
	}

	@GetMapping(value = "/v1/candidate-hobbies/{id}")
	public JsonData getCandidateHobbyById(@PathVariable("id") Integer candHobbId) {
		Optional<CandidateHobby> candidateHobby = candidateHobbyService.findById(candHobbId);

		if (!candidateHobby.isPresent()) {
			throw new RecordNotFoundException("candHobbId: " + candHobbId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Hobby  by Id:" + candHobbId + " listed Successfully")
				.withData(candidateHobby.get());
	}

	@PutMapping(value = "/v1/candidate-hobbies/{id}")
	public JsonData updateMasterHobbyById(@RequestBody CandidateHobby candidateHobby,
			@PathVariable("id") Integer candHobbId) {
		Optional<CandidateHobby> candidateHobbyOptional = candidateHobbyService.findById(candHobbId);

		if (!candidateHobbyOptional.isPresent()) {
			throw new RecordNotFoundException("hobbId" + candHobbId);
		}

		candidateHobby.setCandHobbId(candHobbId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateHobbyService.save(candidateHobby));
	}

}

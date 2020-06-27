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
import com.eSmartHire.model.CandidateSkill;
import com.eSmartHire.service.CandidateSkillService;

@RestController
@RequestMapping(value = "/api")
public class CandidateSkillController {

	@Autowired
	CandidateSkillService candidateSkillService;

	@PostMapping(value = "/v1/candidate-skills")
	public JsonData createCandidateSkills(@RequestBody CandidateSkill candidateSkill) {

		System.out.println("candidate id: " + candidateSkill.getCandSkilCandidateId() + "master skill id: "
				+ candidateSkill.getCandSkilMasterSkillId() + "percentage: " + candidateSkill.getCandSkilPercentage());
		return JsonData.SUCCESS_RESPONSE("Master Hobby created Successfully")
				.withData(candidateSkillService.save(candidateSkill));
	}

	@GetMapping(value = "/v1/candidate-skills")
	public JsonData getCandidateSkill() {
		return JsonData.SUCCESS_RESPONSE("All candidate Skills are  listed successfully")
				.withData(candidateSkillService.findAll());
	}

	@GetMapping(value = "/v1/candidate-skills/{id}")
	public JsonData getCandidateSkillById(@PathVariable("id") Integer candSkilId) {
		Optional<CandidateSkill> candidateSkill = candidateSkillService.findById(candSkilId);

		if (!candidateSkill.isPresent()) {
			throw new RecordNotFoundException("candSkilId: " + candSkilId);
		}

		return JsonData.SUCCESS_RESPONSE("Candidate Skill   by Id:" + candSkilId + " listed Successfully")
				.withData(candidateSkill.get());
	}

	@PutMapping(value = "/v1/candidate-skills/{id}")
	public JsonData updateCandidateSkillById(@RequestBody CandidateSkill candidateSkill,
			@PathVariable("id") Integer candSkilId) {
		Optional<CandidateSkill> candidateSkillOptional = candidateSkillService.findById(candSkilId);

		if (!candidateSkillOptional.isPresent()) {
			throw new RecordNotFoundException("candSkilId" + candSkilId);
		}

		candidateSkill.setCandSkilId(candSkilId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateSkillService.save(candidateSkill));
	}

}

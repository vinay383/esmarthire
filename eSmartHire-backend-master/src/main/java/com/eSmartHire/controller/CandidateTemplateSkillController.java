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
import com.eSmartHire.model.CandidateTemplateSkill;
import com.eSmartHire.service.CandidateTemplateSkillService;

@RestController
@RequestMapping(value = "/api")
public class CandidateTemplateSkillController {

	@Autowired
	CandidateTemplateSkillService candidateTemplateSkillService;

	@PostMapping(value = "/v1/candidate-template-skills")
	public JsonData createcandidateTemplateSkills(@RequestBody CandidateTemplateSkill candidateTemplateSkill) {

		System.out.println("temp id: " + candidateTemplateSkill.getCtSkillCandTempId());
		return JsonData.SUCCESS_RESPONSE("candidate template skill created Successfully")
				.withData(candidateTemplateSkillService.save(candidateTemplateSkill));
	}

	@GetMapping(value = "/v1/candidate-template-skills")
	public JsonData getCandidateTemplateSkill() {
		return JsonData.SUCCESS_RESPONSE("All candidate template links  listed successfully")
				.withData(candidateTemplateSkillService.findAll());
	}

	@GetMapping(value = "/v1/candidate-template-skills/{id}")
	public JsonData getCandidateTemplateSkillById(@PathVariable("id") Integer ctSkill) {
		Optional<CandidateTemplateSkill> candidateTemplateSkill = candidateTemplateSkillService.findById(ctSkill);

		if (!candidateTemplateSkill.isPresent()) {
			throw new RecordNotFoundException("ctSkill: " + ctSkill);
		}

		return JsonData.SUCCESS_RESPONSE("candidate template skills  by Id:" + ctSkill + " listed Successfully")
				.withData(candidateTemplateSkill.get());
	}

	@PutMapping(value = "/v1/candidate-template-skills/{id}")
	public JsonData updateMasterHobbyById(@RequestBody CandidateTemplateSkill candidateTemplateSkill,
			@PathVariable("id") Integer ctSkill) {
		Optional<CandidateTemplateSkill> candidateTemplateSkillOptional = candidateTemplateSkillService
				.findById(ctSkill);

		if (!candidateTemplateSkillOptional.isPresent()) {
			throw new RecordNotFoundException("ctSkill" + ctSkill);
		}

		candidateTemplateSkill.setCtSkill(ctSkill);
		return JsonData.SUCCESS_RESPONSE().withData(candidateTemplateSkillService.save(candidateTemplateSkill));
	}

}

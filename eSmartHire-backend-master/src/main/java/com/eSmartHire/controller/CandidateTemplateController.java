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
import com.eSmartHire.model.CandidateTemplate;
import com.eSmartHire.service.CandidateTemplateService;

@RestController
@RequestMapping(value = "/api")
public class CandidateTemplateController {

	@Autowired
	CandidateTemplateService candidateTemplateService;

	@PostMapping(value = "/v1/candidate-templates")
	public JsonData createCandidateTemplates(@RequestBody CandidateTemplate candidateTemplate) {

		System.out.println("name: " + candidateTemplate.getCandTempUserId() + "master template id: "
				+ candidateTemplate.getCandTempMasterTemplateId());
		return JsonData.SUCCESS_RESPONSE("Candidate Template created Successfully")
				.withData(candidateTemplateService.save(candidateTemplate));
	}

	@GetMapping(value = "/v1/candidate-templates")
	public JsonData getCandidateTemplate() {
		return JsonData.SUCCESS_RESPONSE("All candidate templates listed successfully")
				.withData(candidateTemplateService.findAll());
	}

	@GetMapping(value = "/v1/candidate-templates/{id}")
	public JsonData getCandidateTemplateById(@PathVariable("id") Integer candTempId) {
		Optional<CandidateTemplate> candidateTemplate = candidateTemplateService.findById(candTempId);

		if (!candidateTemplate.isPresent()) {
			throw new RecordNotFoundException("candTempId: " + candTempId);
		}

		return JsonData.SUCCESS_RESPONSE("Candidate template  by Id:" + candTempId + " listed Successfully")
				.withData(candidateTemplate.get());
	}

	@PutMapping(value = "/v1/candidate-templates/{id}")
	public JsonData updateCandidateTemplateById(@RequestBody CandidateTemplate candidateTemplate,
			@PathVariable("id") Integer candTempId) {
		Optional<CandidateTemplate> candidateTemplateOptional = candidateTemplateService.findById(candTempId);

		if (!candidateTemplateOptional.isPresent()) {
			throw new RecordNotFoundException("candTempId" + candTempId);
		}

		candidateTemplate.setCandTempId(candTempId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateTemplateService.save(candidateTemplate));
	}

}

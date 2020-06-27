package com.eSmartHire.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eSmartHire.common.JsonData;
import com.eSmartHire.exception.RecordNotFoundException;
import com.eSmartHire.model.CandidateTemplateTool;
import com.eSmartHire.service.CandidateTemplateToolService;

@RestController
@RequestMapping(value = "/api")
public class CandidateTemplateToolController {

	@Autowired
	CandidateTemplateToolService candidateTemplateToolService;

	@PostMapping(value = "/v1/candidate-template-tools")
	public JsonData createCandidateTemplateTools(@RequestBody CandidateTemplateTool candidateTemplateTool) {

		System.out.println("temp id: " + candidateTemplateTool.getCtToolCandTempId());
		return JsonData.SUCCESS_RESPONSE("candidate template tools  created Successfully")
				.withData(candidateTemplateToolService.save(candidateTemplateTool));
	}

	@GetMapping(value = "/v1/candidate-template-tools")
	public JsonData getCandidateTemplateTool() {
		return JsonData.SUCCESS_RESPONSE("All candidate template tools   listed successfully")
				.withData(candidateTemplateToolService.findAll());
	}

	@GetMapping(value = "/v1/candidate-template-tools/{id}")
	public JsonData getCandidateTemplateToolById(@PathVariable("id") Integer ctToolId) {
		Optional<CandidateTemplateTool> candidateTemplateTool = candidateTemplateToolService.findById(ctToolId);

		if (!candidateTemplateTool.isPresent()) {
			throw new RecordNotFoundException("ctToolId: " + ctToolId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Hobby  by Id:" + ctToolId + " listed Successfully")
				.withData(candidateTemplateTool.get());
	}

}

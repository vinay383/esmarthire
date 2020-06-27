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
import com.eSmartHire.model.CandidateTool;
import com.eSmartHire.service.CandidateToolService;

@RestController
@RequestMapping(value = "/api")
public class CandidateToolController {

	@Autowired
	CandidateToolService candidateToolService;

	@PostMapping(value = "/v1/candidate-tools")
	public JsonData createCandidateTools(@RequestBody CandidateTool candidateTool) {

		System.out.println("candidate id: " + candidateTool.getCandToolCandidateId());
		return JsonData.SUCCESS_RESPONSE("candidate tools created Successfully")
				.withData(candidateToolService.save(candidateTool));
	}

	@GetMapping(value = "/v1/candidate-tools")
	public JsonData getCandidateTool() {
		return JsonData.SUCCESS_RESPONSE("All candidate tools  listed successfully")
				.withData(candidateToolService.findAll());
	}

	@GetMapping(value = "/v1/candidate-tools/{id}")
	public JsonData getCandidateToolById(@PathVariable("id") Integer candToolId) {
		Optional<CandidateTool> candidateTool = candidateToolService.findById(candToolId);

		if (!candidateTool.isPresent()) {
			throw new RecordNotFoundException("candToolId: " + candToolId);
		}

		return JsonData.SUCCESS_RESPONSE("candidate tool  by Id:" + candToolId + " listed Successfully")
				.withData(candidateTool.get());
	}

	@PutMapping(value = "/v1/candidate-tools/{id}")
	public JsonData updateCandidateToolById(@RequestBody CandidateTool candidateTool,
			@PathVariable("id") Integer candToolId) {
		Optional<CandidateTool> candidateToolOptional = candidateToolService.findById(candToolId);

		if (!candidateToolOptional.isPresent()) {
			throw new RecordNotFoundException("candToolId" + candToolId);
		}

		candidateTool.setCandToolId(candToolId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateToolService.save(candidateTool));
	}

}

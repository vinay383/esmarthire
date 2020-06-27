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
import com.eSmartHire.model.Candidate;
import com.eSmartHire.service.CandidateService;

@RestController
@RequestMapping(value = "/api")
public class CandidateController {

	@Autowired
	CandidateService candidateService;

	@PostMapping(value = "/v1/candidates")
	public JsonData createCandidates(@RequestBody Candidate candidate) {
		return JsonData.SUCCESS_RESPONSE().withData(candidateService.save(candidate));
	}

	@GetMapping(value = "/v1/candidates")
	public JsonData getCandidates() {
		return JsonData.SUCCESS_RESPONSE("All candidates listed successfully").withData(candidateService.findAll());
	}

	@GetMapping(value = "/v1/candidates/{id}")
	public JsonData getCandidatesById(@PathVariable("id") Integer candId) {
		Optional<Candidate> candidate = candidateService.findById(candId);

		if (!candidate.isPresent()) {
			throw new RecordNotFoundException("candId" + candId);
		}

		return JsonData.SUCCESS_RESPONSE("All candidates listed successfully").withData(candidate.get());
	}

	@PutMapping(value = "/v1/candidate/{id}")
	public JsonData updateCandidateById(@RequestBody Candidate candidate, @PathVariable("id") Integer candId) {
		Optional<Candidate> candidateOptional = candidateService.findById(candId);

		if (!candidateOptional.isPresent()) {
			throw new RecordNotFoundException("candId" + candId);
		}

		candidate.setCandId(candId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateService.save(candidate));
	}

//    @DeleteMapping(value = "/v1/candidate/{id}")
//    public JsonData deleteCandidateById(@RequestBody Candidate candidate, @PathVariable("id") Integer candId) {
//        Optional<Candidate> candidateOptional = candidateService.findById(candId);
//
//        if(!candidateOptional.isPresent()) {
//        	throw new RecordNotFoundException("candId" + candId);        	
//        }
//        
//        candidateOptional.get().setCandIsDeleted(true);
//    }

}
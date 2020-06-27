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
import com.eSmartHire.model.CandidateLanguage;
import com.eSmartHire.service.CandidateLanguageService;

@RestController
@RequestMapping(value = "/api")
public class CandidateLanguageController {

	@Autowired
	CandidateLanguageService candidateLanguageService;

	@PostMapping(value = "/v1/candidate-languages")
	public JsonData createCandidateLanguages(@RequestBody CandidateLanguage candidateLanguage) {

		System.out.println("name: " + candidateLanguage.getCandLangCandidateId() + "master language id: "
				+ candidateLanguage.getCandLangMasterLangId() + "Language Percentage: "
				+ candidateLanguage.getCandLangPercentage());
		return JsonData.SUCCESS_RESPONSE("Master Language created Successfully")
				.withData(candidateLanguageService.save(candidateLanguage));
	}

	@GetMapping(value = "/v1/candidate-languages")
	public JsonData getCandidateLanguages() {
		return JsonData.SUCCESS_RESPONSE("All candidate languages  listed successfully")
				.withData(candidateLanguageService.findAll());
	}

	@GetMapping(value = "/v1/candidate-languages/{id}")
	public JsonData getCandidateLanguageById(@PathVariable("id") Integer candLangId) {
		Optional<CandidateLanguage> candidateLanguage = candidateLanguageService.findById(candLangId);

		if (!candidateLanguage.isPresent()) {
			throw new RecordNotFoundException("candLangId: " + candLangId);
		}

		return JsonData.SUCCESS_RESPONSE("Candidate Language  by Id:" + candLangId + " listed Successfully")
				.withData(candidateLanguage.get());
	}

	@PutMapping(value = "/v1/candidate-languages/{id}")
	public JsonData updateCandidateLanguageById(@RequestBody CandidateLanguage candidateLanguages,
			@PathVariable("id") Integer candLangId) {
		Optional<CandidateLanguage> candidateLanguagesOptional = candidateLanguageService.findById(candLangId);

		if (!candidateLanguagesOptional.isPresent()) {
			throw new RecordNotFoundException("candLangId" + candLangId);
		}

		candidateLanguages.setCandLangId(candLangId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateLanguageService.save(candidateLanguages));
	}

}

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
import com.eSmartHire.model.CandidateTemplateLanguage;
import com.eSmartHire.service.CandidateTemplateLanguageService;

@RestController
@RequestMapping(value = "/api")
public class CandidateTemplateLanguageController {
	@Autowired
	CandidateTemplateLanguageService candidateTemplateLanguageService;

	@PostMapping(value = "/v1/candidate-template-languages")
	public JsonData createCandidateTemplateLanguages(@RequestBody CandidateTemplateLanguage candidateTemplateLanguage) {

		System.out.println("temp id: " + candidateTemplateLanguage.getCtLangCandTempId() + "language id: "
				+ candidateTemplateLanguage.getCtLangMasterLanguageId() + " certifies: "
				+ candidateTemplateLanguage.getCtLangCertified() + " rate: " + candidateTemplateLanguage.getCtLangRate()
				+ " Lang Native: " + candidateTemplateLanguage.getCtLangNative());
		return JsonData.SUCCESS_RESPONSE("Master Hobby created Successfully")
				.withData(candidateTemplateLanguageService.save(candidateTemplateLanguage));
	}

	@GetMapping(value = "/v1/candidate-template-languages")
	public JsonData getCandidateTemplateLanguage() {
		return JsonData.SUCCESS_RESPONSE("All candidate template languages  listed successfully")
				.withData(candidateTemplateLanguageService.findAll());
	}

	@GetMapping(value = "/v1/candidate-template-languages/{id}")
	public JsonData getCandidateTemplateLanguageById(@PathVariable("id") Integer ctLangId) {
		Optional<CandidateTemplateLanguage> candidateTemplateLanguage = candidateTemplateLanguageService
				.findById(ctLangId);

		if (!candidateTemplateLanguage.isPresent()) {
			throw new RecordNotFoundException("ctLangId: " + ctLangId);
		}

		return JsonData.SUCCESS_RESPONSE("Candidate Template Language  by Id:" + ctLangId + " listed Successfully")
				.withData(candidateTemplateLanguage.get());
	}

	@PutMapping(value = "/v1/candidate-template-languages/{id}")
	public JsonData updateMasterHobbyById(@RequestBody CandidateTemplateLanguage candidateTemplateLanguage,
			@PathVariable("id") Integer ctLangId) {
		Optional<CandidateTemplateLanguage> masterHobbyOptional = candidateTemplateLanguageService.findById(ctLangId);

		if (!masterHobbyOptional.isPresent()) {
			throw new RecordNotFoundException("hobbId" + ctLangId);
		}

		candidateTemplateLanguage.setCtLangId(ctLangId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateTemplateLanguageService.save(candidateTemplateLanguage));
	}

}

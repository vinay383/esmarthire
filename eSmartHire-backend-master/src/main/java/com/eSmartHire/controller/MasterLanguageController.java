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
import com.eSmartHire.model.MasterLanguage;
import com.eSmartHire.service.MasterLanguageService;

@RestController
@RequestMapping(value = "/api")
public class MasterLanguageController {

	@Autowired
	MasterLanguageService masterLanguageService;

	@PostMapping(value = "/v1/master-languages")
	public JsonData createMasterLanguages(@RequestBody MasterLanguage masterLanguage) {

		System.out.println("name: " + masterLanguage.getLangName());
		return JsonData.SUCCESS_RESPONSE("Master Language created Successfully")
				.withData(masterLanguageService.save(masterLanguage));
	}

	@GetMapping(value = "/v1/master-languages")
	public JsonData getMasterLanguage() {
		return JsonData.SUCCESS_RESPONSE("All master Languages  listed successfully")
				.withData(masterLanguageService.findAll());
	}

	@GetMapping(value = "/v1/master-languages/{id}")
	public JsonData getMasterLanguagesById(@PathVariable("id") Integer langId) {
		Optional<MasterLanguage> masterLanguage = masterLanguageService.findById(langId);

		if (!masterLanguage.isPresent()) {
			throw new RecordNotFoundException("langId: " + langId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Language  by Id:" + langId + " listed Successfully")
				.withData(masterLanguage.get());
	}

	@PutMapping(value = "/v1/master-languages/{id}")
	public JsonData updateMasterLanguageById(@RequestBody MasterLanguage masterLanguage,
			@PathVariable("id") Integer langId) {
		Optional<MasterLanguage> masterLanguageOptional = masterLanguageService.findById(langId);

		if (!masterLanguageOptional.isPresent()) {
			throw new RecordNotFoundException(" langId" + langId);
		}

		masterLanguage.setLangId(langId);
		return JsonData.SUCCESS_RESPONSE().withData(masterLanguageService.save(masterLanguage));
	}

}

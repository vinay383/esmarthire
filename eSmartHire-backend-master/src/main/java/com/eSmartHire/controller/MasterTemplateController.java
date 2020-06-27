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
import com.eSmartHire.model.MasterTemplate;
import com.eSmartHire.service.MasterTemplateService;

@RestController
@RequestMapping(value = "/api")
public class MasterTemplateController {

	@Autowired
	MasterTemplateService masterTemplateService;

	@PostMapping(value = "/v1/master-templates")
	public JsonData createMasterTemplatess(@RequestBody MasterTemplate masterTemplate) {

		System.out.println("name: " + masterTemplate.getTempName() + "rating:" + masterTemplate.getTempRating()
				+ "description:" + masterTemplate.getTempDescription() + "url:" + masterTemplate.getTempUrl()
				+ "filepath:" + masterTemplate.getTempFilepath());
		return JsonData.SUCCESS_RESPONSE("Master Templates created Successfully")
				.withData(masterTemplateService.save(masterTemplate));
	}

	@GetMapping(value = "/v1/master-templates")
	public JsonData getMasterTemplate() {
		return JsonData.SUCCESS_RESPONSE("All master templates  listed successfully")
				.withData(masterTemplateService.findAll());
	}

	@GetMapping(value = "/v1/master-templates/{id}")
	public JsonData getMasterTemplateById(@PathVariable("id") Integer tempId) {
		Optional<MasterTemplate> masterTemplate = masterTemplateService.findById(tempId);

		if (!masterTemplate.isPresent()) {
			throw new RecordNotFoundException("tempId: " + tempId);
		}

		return JsonData.SUCCESS_RESPONSE("Master template  by Id:" + tempId + " listed Successfully")
				.withData(masterTemplate.get());
	}

	@PutMapping(value = "/v1/master-templates/{id}")
	public JsonData updateMasterTemplateById(@RequestBody MasterTemplate masterTemplate,
			@PathVariable("id") Integer tempId) {
		Optional<MasterTemplate> masterTemplateOptional = masterTemplateService.findById(tempId);

		if (!masterTemplateOptional.isPresent()) {
			throw new RecordNotFoundException("hobbId" + tempId);
		}

		masterTemplate.setTempId(tempId);
		return JsonData.SUCCESS_RESPONSE().withData(masterTemplateService.save(masterTemplate));
	}

}

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
import com.eSmartHire.model.MasterSocialAccountType;
import com.eSmartHire.service.MasterSocialAccountTypeService;

@RestController
@RequestMapping(value = "/api")
public class MasterSocialAccountTypeController {

	@Autowired
	MasterSocialAccountTypeService masterSocialAccountTypeService;

	@PostMapping(value = "/v1/master-social-account-types")
	public JsonData createMasterSocialAccountType(@RequestBody MasterSocialAccountType masterSocialAccountType) {

		System.out.println("name: " + masterSocialAccountType.getSociAccoTypeName() + " about: "
				+ masterSocialAccountType.getSociAccoTypeUrl() + "filepath: "
				+ masterSocialAccountType.getSociAccoTypeFilepath());
		return JsonData.SUCCESS_RESPONSE("Master Hobby created Successfully")
				.withData(masterSocialAccountTypeService.save(masterSocialAccountType));
	}

	@GetMapping(value = "/v1/master-social-account-types")
	public JsonData getMasterSocialAccountType() {
		return JsonData.SUCCESS_RESPONSE("All master social account types   listed successfully")
				.withData(masterSocialAccountTypeService.findAll());
	}

	@GetMapping(value = "/v1/master-social-account-types/{id}")
	public JsonData getMasterSocialAccountTypeById(@PathVariable("id") Integer sociAccoTypeId) {
		Optional<MasterSocialAccountType> masterSocialAccountType = masterSocialAccountTypeService
				.findById(sociAccoTypeId);

		if (!masterSocialAccountType.isPresent()) {
			throw new RecordNotFoundException("sociAccoTypeId: " + sociAccoTypeId);
		}

		return JsonData.SUCCESS_RESPONSE("Master social account type  by Id:" + sociAccoTypeId + " listed Successfully")
				.withData(masterSocialAccountType.get());
	}

	@PutMapping(value = "/v1/master-social-account-types/{id}")
	public JsonData updateMasterSocialAccountTypeById(@RequestBody MasterSocialAccountType masterSocialAccountType,
			@PathVariable("id") Integer sociAccoTypeId) {
		Optional<MasterSocialAccountType> masterSocialAccountTypeOptional = masterSocialAccountTypeService
				.findById(sociAccoTypeId);

		if (!masterSocialAccountTypeOptional.isPresent()) {
			throw new RecordNotFoundException("sociAccoTypeId" + sociAccoTypeId);
		}

		masterSocialAccountType.setSociAccoTypeId(sociAccoTypeId);
		return JsonData.SUCCESS_RESPONSE().withData(masterSocialAccountTypeService.save(masterSocialAccountType));
	}

}

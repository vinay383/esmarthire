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
import com.eSmartHire.model.MasterSkill;
import com.eSmartHire.service.MasterSkillService;

@RestController
@RequestMapping(value = "/api")
public class MasterSkillController {

	@Autowired
	MasterSkillService masterSkillService;

	@PostMapping(value = "/v1/master-skills")
	public JsonData createMasterSkills(@RequestBody MasterSkill masterSkill) {

		System.out.println("name: " + masterSkill.getSkilName());
		return JsonData.SUCCESS_RESPONSE("Master Skill created Successfully")
				.withData(masterSkillService.save(masterSkill));
	}

	@GetMapping(value = "/v1/master-skills")
	public JsonData getMasterSkill() {
		return JsonData.SUCCESS_RESPONSE("All master skills  listed successfully")
				.withData(masterSkillService.findAll());
	}

	@GetMapping(value = "/v1/master-skills/{id}")
	public JsonData getMasterSkillById(@PathVariable("id") Integer skilId) {
		Optional<MasterSkill> masterSkill = masterSkillService.findById(skilId);

		if (!masterSkill.isPresent()) {
			throw new RecordNotFoundException("skilId: " + skilId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Skill  by Id:" + skilId + " listed Successfully")
				.withData(masterSkill.get());
	}

	@PutMapping(value = "/v1/master-skills/{id}")
	public JsonData updateMasterSkillById(@RequestBody MasterSkill masterSkill, @PathVariable("id") Integer skilId) {
		Optional<MasterSkill> masterSkillOptional = masterSkillService.findById(skilId);

		if (!masterSkillOptional.isPresent()) {
			throw new RecordNotFoundException("skilId" + skilId);
		}

		masterSkill.setSkilId(skilId);
		return JsonData.SUCCESS_RESPONSE().withData(masterSkillService.save(masterSkill));
	}

}

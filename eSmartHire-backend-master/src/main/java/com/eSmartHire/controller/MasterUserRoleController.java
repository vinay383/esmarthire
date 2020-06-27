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
import com.eSmartHire.model.MasterUserRole;
import com.eSmartHire.service.MasterUserRoleService;

@RestController
@RequestMapping(value = "/api")
public class MasterUserRoleController {

	@Autowired
	MasterUserRoleService masterUserRoleService;

	@PostMapping(value = "/v1/master-user-roles")
	public JsonData createMasterUserRole(@RequestBody MasterUserRole masterUserRole) {

		return JsonData.SUCCESS_RESPONSE("Master user roles created Successfully")
				.withData(masterUserRoleService.save(masterUserRole));
	}

	@GetMapping(value = "/v1/master-user-roles")
	public JsonData getMasterUserRole() {
		return JsonData.SUCCESS_RESPONSE("All master User roles  listed successfully")
				.withData(masterUserRoleService.findAll());
	}

	@GetMapping(value = "/v1/master-user-roles/{id}")
	public JsonData getMasterUserRoleById(@PathVariable("id") Integer urId) {
		Optional<MasterUserRole> masterUserRole = masterUserRoleService.findById(urId);

		if (!masterUserRole.isPresent()) {
			throw new RecordNotFoundException("urId: " + urId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Hobby  by Id:" + urId + " listed Successfully")
				.withData(masterUserRole.get());
	}

	@PutMapping(value = "/v1/master-user-roles/{id}")
	public JsonData updateMasterUserRoleById(@RequestBody MasterUserRole masterUserRole,
			@PathVariable("id") Integer urId) {
		Optional<MasterUserRole> masterUserRoleOptional = masterUserRoleService.findById(urId);

		if (!masterUserRoleOptional.isPresent()) {
			throw new RecordNotFoundException("urId" + urId);
		}

		masterUserRole.setUrId(urId);
		return JsonData.SUCCESS_RESPONSE().withData(masterUserRoleService.save(masterUserRole));
	}

}

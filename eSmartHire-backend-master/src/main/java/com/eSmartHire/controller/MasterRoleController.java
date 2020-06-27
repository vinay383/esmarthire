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
import com.eSmartHire.model.MasterRole;
import com.eSmartHire.service.MasterRoleService;

@RestController
@RequestMapping(value = "/api")
public class MasterRoleController {

	@Autowired
	MasterRoleService masterRoleService;

	@PostMapping(value = "/v1/master-roles")
	public JsonData createMasterRoles(@RequestBody MasterRole masterRole) {

		System.out.println("name: " + masterRole.getRoleName());
		return JsonData.SUCCESS_RESPONSE("Master Role created Successfully")
				.withData(masterRoleService.save(masterRole));
	}

	@GetMapping(value = "/v1/master-roles")
	public JsonData getMasterRole() {
		return JsonData.SUCCESS_RESPONSE("All master roles  listed successfully").withData(masterRoleService.findAll());
	}

	@GetMapping(value = "/v1/master-roles/{id}")
	public JsonData getMasterRoleById(@PathVariable("id") Integer roleId) {
		Optional<MasterRole> masterRole = masterRoleService.findById(roleId);

		if (!masterRole.isPresent()) {
			throw new RecordNotFoundException("hobbId: " + roleId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Role  by Id:" + roleId + " listed Successfully")
				.withData(masterRole.get());
	}

	@PutMapping(value = "/v1/master-roles/{id}")
	public JsonData updateMasterRoleById(@RequestBody MasterRole masterRole, @PathVariable("id") Integer roleId) {
		Optional<MasterRole> masterRoleOptional = masterRoleService.findById(roleId);

		if (!masterRoleOptional.isPresent()) {
			throw new RecordNotFoundException("roleId" + roleId);
		}

		masterRole.setRoleId(roleId);
		return JsonData.SUCCESS_RESPONSE().withData(masterRoleService.save(masterRole));
	}

}

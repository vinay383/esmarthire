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
import com.eSmartHire.model.MasterUser;
import com.eSmartHire.service.MasterUserService;

@RestController
@RequestMapping(value = "/api")
public class MasterUserController {

	@Autowired
	MasterUserService masterUserService;

	@PostMapping(value = "/v1/master-users")
	public JsonData createMasterUsers(@RequestBody MasterUser masterUser) {

		System.out.println("name: " + masterUser.getUserFirstName() + "last name: " + masterUser.getUserLastName()
				+ "emailid: " + masterUser.getUserEmailId() + "password: " + masterUser.getUserPassword()
				+ "contactnumber: " + masterUser.getUserContactNumber() + "gender: " + masterUser.getUserGender()
				+ "date of birth: " + masterUser.getUserDateOfBirth() + "picture url: " + masterUser.getUserPictureUrl()
				+ "picture path: " + masterUser.getUserPictureFilepath());
		return JsonData.SUCCESS_RESPONSE("Master User created Successfully")
				.withData(masterUserService.save(masterUser));
	}

	@GetMapping(value = "/v1/master-users")
	public JsonData getMasterUser() {
		return JsonData.SUCCESS_RESPONSE("All master Users  listed successfully").withData(masterUserService.findAll());
	}

	@GetMapping(value = "/v1/master-users/{id}")
	public JsonData getMasterUserById(@PathVariable("id") Integer userId) {
		Optional<MasterUser> masterUser = masterUserService.findById(userId);

		if (!masterUser.isPresent()) {
			throw new RecordNotFoundException("hobbId: " + userId);
		}

		return JsonData.SUCCESS_RESPONSE("Master User by Id:" + userId + " listed Successfully")
				.withData(masterUser.get());
	}

	@PutMapping(value = "/v1/master-users/{id}")
	public JsonData updateMasterUserById(@RequestBody MasterUser masterUser, @PathVariable("id") Integer userId) {
		Optional<MasterUser> masterUserOptional = masterUserService.findById(userId);

		if (!masterUserOptional.isPresent()) {
			throw new RecordNotFoundException("hobbId" + userId);
		}

		masterUser.setUserId(userId);
		return JsonData.SUCCESS_RESPONSE().withData(masterUserService.save(masterUser));
	}

}

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
import com.eSmartHire.model.MasterHobby;
import com.eSmartHire.service.MasterHobbyService;

@RestController
@RequestMapping(value = "/api")
public class MasterHobbyController {

	@Autowired
	MasterHobbyService masterHobbyService;

	@PostMapping(value = "/v1/master-hobbies")
	public JsonData createMasterHobbies(@RequestBody MasterHobby masterHobby) {

		System.out.println("name: " + masterHobby.getHobbName());
		return JsonData.SUCCESS_RESPONSE("Master Hobby created Successfully")
				.withData(masterHobbyService.save(masterHobby));
	}

	@GetMapping(value = "/v1/master-hobbies")
	public JsonData getMasterHobby() {
		return JsonData.SUCCESS_RESPONSE("All master Hobbiess  listed successfully")
				.withData(masterHobbyService.findAll());
	}

	@GetMapping(value = "/v1/master-hobbies/{id}")
	public JsonData getMasterHobbyById(@PathVariable("id") Integer hobbId) {
		Optional<MasterHobby> masterHobby = masterHobbyService.findById(hobbId);

		if (!masterHobby.isPresent()) {
			throw new RecordNotFoundException("hobbId: " + hobbId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Hobby  by Id:" + hobbId + " listed Successfully")
				.withData(masterHobby.get());
	}

	@PutMapping(value = "/v1/master-hobbies/{id}")
	public JsonData updateMasterHobbyById(@RequestBody MasterHobby masterHobby, @PathVariable("id") Integer hobbId) {
		Optional<MasterHobby> masterHobbyOptional = masterHobbyService.findById(hobbId);

		if (!masterHobbyOptional.isPresent()) {
			throw new RecordNotFoundException("hobbId" + hobbId);
		}

		masterHobby.setHobbId(hobbId);
		return JsonData.SUCCESS_RESPONSE().withData(masterHobbyService.save(masterHobby));
	}

}

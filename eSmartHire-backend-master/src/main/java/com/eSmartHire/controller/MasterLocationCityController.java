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
import com.eSmartHire.model.MasterLocationCity;
import com.eSmartHire.service.MasterLocationCityService;

@RestController
@RequestMapping(value = "/api")
public class MasterLocationCityController {

	@Autowired
	MasterLocationCityService masterLocationCityService;

	@PostMapping(value = "/v1/master-location-cities")
	public JsonData createMasterLocationCities(@RequestBody MasterLocationCity masterLocationCity) {

		System.out.println("name: " + masterLocationCity.getLocationCityName());
		return JsonData.SUCCESS_RESPONSE("Master Hobby created Successfully")
				.withData(masterLocationCityService.save(masterLocationCity));
	}

	@GetMapping(value = "/v1/master-location-cities")
	public JsonData getMasterLocationCity() {
		return JsonData.SUCCESS_RESPONSE("All master Location Cities   listed successfully")
				.withData(masterLocationCityService.findAll());
	}

	@GetMapping(value = "/v1/master-location-cities/{id}")
	public JsonData getMasterLocationCityById(@PathVariable("id") Integer locationCityId) {
		Optional<MasterLocationCity> masterLocationCity = masterLocationCityService.findById(locationCityId);

		if (!masterLocationCity.isPresent()) {
			throw new RecordNotFoundException("locationCityId: " + locationCityId);
		}

		return JsonData.SUCCESS_RESPONSE("Master  City by Id:" + locationCityId + " listed Successfully")
				.withData(masterLocationCity.get());
	}

	@PutMapping(value = "/v1/master-location-cities/{id}")
	public JsonData updateMasterLocationCityById(@RequestBody MasterLocationCity masterLocationCity,
			@PathVariable("id") Integer locationCityId) {
		Optional<MasterLocationCity> masterLocationCityOptional = masterLocationCityService.findById(locationCityId);

		if (!masterLocationCityOptional.isPresent()) {
			throw new RecordNotFoundException("locationCityId" + locationCityId);
		}

		masterLocationCity.setLocationCityId(locationCityId);
		return JsonData.SUCCESS_RESPONSE().withData(masterLocationCityService.save(masterLocationCity));
	}

}
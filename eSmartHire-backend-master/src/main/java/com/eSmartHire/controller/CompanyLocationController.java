package com.eSmartHire.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eSmartHire.common.JsonData;
import com.eSmartHire.exception.RecordNotFoundException;
import com.eSmartHire.model.CompanyLocation;
import com.eSmartHire.service.CompanyLocationService;

@RestController
@RequestMapping(value = "/api")
public class CompanyLocationController {

	@Autowired
	CompanyLocationService companyLocationService;

	@PostMapping(value = "/v1/company-locations")
	public JsonData createCompanyLocations(@RequestBody CompanyLocation companyLocation) {
		return JsonData.SUCCESS_RESPONSE("Company Location created Successfully")
				.withData(companyLocationService.save(companyLocation));
	}

	@GetMapping(value = "/v1/company-locations")
	public JsonData getCompanyLocations() {
		return JsonData.SUCCESS_RESPONSE("All Company Locations listed Successfully")
				.withData(companyLocationService.findAll());
	}

	@GetMapping(value = "/v1/company-locations/{id}")
	public JsonData getCompanyLocationsById(@PathVariable("id") Integer compLocaId) {
		Optional<CompanyLocation> companyLocation = companyLocationService.findById(compLocaId);

		if (!companyLocation.isPresent()) {
			throw new RecordNotFoundException("compLocaId: " + compLocaId);
		}

		return JsonData.SUCCESS_RESPONSE("Company Location by Id:" + compLocaId + " listed Successfully")
				.withData(companyLocation.get());
	}

	@PutMapping(value = "/v1/company-locations/{id}")
	public JsonData updateCompanyLocationsById(@RequestBody CompanyLocation companyLocation,
			@PathVariable("id") Integer compLocaId) {
		Optional<CompanyLocation> companyLocationOptional = companyLocationService.findById(compLocaId);

		if (!companyLocationOptional.isPresent()) {
			throw new RecordNotFoundException("compLocaId: " + compLocaId);
		}
		companyLocation.setCompLocaId(compLocaId);
		return JsonData.SUCCESS_RESPONSE("Company Location by Id:" + compLocaId + " updated Successfully")
				.withData(companyLocationService.save(companyLocation));
	}

	@DeleteMapping(value = "/v1/company-locations/{id}")
	public JsonData deleteCompanyLocationsById(@PathVariable("id") Integer compLocaId) {
		Optional<CompanyLocation> companyLocationOptional = companyLocationService.findById(compLocaId);

		if (!companyLocationOptional.isPresent()) {
			throw new RecordNotFoundException("compLocaId: " + compLocaId);
		}
		companyLocationOptional.get().setCompLocaIsDeleted(true);
		return JsonData.SUCCESS_RESPONSE("Company Location by Id:" + compLocaId + " deleted Successfully")
				.withData(companyLocationService.save(companyLocationOptional.get()));
	}

}

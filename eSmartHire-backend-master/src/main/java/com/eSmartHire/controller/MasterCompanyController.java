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
import com.eSmartHire.model.MasterCompany;
import com.eSmartHire.service.MasterCompanyService;

@RestController
@RequestMapping(value = "/api")
public class MasterCompanyController {

	@Autowired
	MasterCompanyService masterCompanyService;

	@PostMapping(value = "/v1/master-companies")
	public JsonData createMasterCompanies(@RequestBody MasterCompany masterCompany) {

		System.out.println("name: " + masterCompany.getCompName() + " about: " + masterCompany.getCompAbout());
		return JsonData.SUCCESS_RESPONSE("Master Company created Successfully")
				.withData(masterCompanyService.save(masterCompany));
	}

	@GetMapping(value = "/v1/master-companies")
	public JsonData getMasterCompany() {
		return JsonData.SUCCESS_RESPONSE("All master companies  listed successfully")
				.withData(masterCompanyService.findAll());
	}

	@GetMapping(value = "/v1/master-companies/{id}")
	public JsonData getMasterCompaniesById(@PathVariable("id") Integer compId) {
		Optional<MasterCompany> masterCompany = masterCompanyService.findById(compId);

		if (!masterCompany.isPresent()) {
			throw new RecordNotFoundException("compId: " + compId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Company  by Id:" + compId + " listed Successfully")
				.withData(masterCompany.get());
	}

	@PutMapping(value = "/v1/master-companies/{id}")
	public JsonData updateMasterCompanyById(@RequestBody MasterCompany masterCompany,
			@PathVariable("id") Integer compId) {
		Optional<MasterCompany> masterCompanyOptional = masterCompanyService.findById(compId);

		if (!masterCompanyOptional.isPresent()) {
			throw new RecordNotFoundException("compId" + compId);
		}

		masterCompany.setCompId(compId);
		return JsonData.SUCCESS_RESPONSE().withData(masterCompanyService.save(masterCompany));
	}

	/*
	 * @DeleteMapping(value = "/master-companies/{id}") public JsonData
	 * deleteMasterCompaniesById(@PathVariable("id")Integer mastCompId) {
	 * Optional<MasterCompany> masterCompanyOptional =
	 * masterCompanyService.findById(mastCompId);
	 * 
	 * if(!masterCompanyOptional.isPresent()) { throw new
	 * RecordNotFoundException("compId: "+ compId); }
	 * masterCompanyOptional.get().setmastCompIsDeleted(true); return
	 * JsonData.SUCCESS_RESPONSE("Master Company Location by Id:"
	 * +compId+" deleted Successfully").withData(masterCompanyService.save(
	 * masterCompanyOptional.get())); }
	 */
}

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
import com.eSmartHire.model.Recruiter;
import com.eSmartHire.service.RecruiterService;

@RestController
@RequestMapping(value = "/api")
public class RecruiterController {

	@Autowired
	RecruiterService recruiterService;

	@PostMapping(value = "/v1/recruiters")
	public JsonData createRecruiters(@RequestBody Recruiter recruiter) {

		System.out.println("plan id: " + recruiter.getRecrMasterPlanId() + "company name: "
				+ recruiter.getRecrCompanyName() + "Address: " + recruiter.getRecrAddress() + "Job title: "
				+ recruiter.getRecrJobTitle() + "Company website: " + recruiter.getRecrCompanyWebsite());
		return JsonData.SUCCESS_RESPONSE("Recruiter created Successfully").withData(recruiterService.save(recruiter));
	}

	@GetMapping(value = "/v1/recruiters")
	public JsonData getRecruiter() {
		return JsonData.SUCCESS_RESPONSE("All recruiters  listed successfully").withData(recruiterService.findAll());
	}

	@GetMapping(value = "/v1/recruiters/{id}")
	public JsonData getRecruiterById(@PathVariable("id") Integer recrId) {
		Optional<Recruiter> recruiter = recruiterService.findById(recrId);

		if (!recruiter.isPresent()) {
			throw new RecordNotFoundException("recrId: " + recrId);
		}

		return JsonData.SUCCESS_RESPONSE("Recruiter  by Id:" + recrId + " listed Successfully")
				.withData(recruiter.get());
	}

	@PutMapping(value = "/v1/recruiters/{id}")
	public JsonData updateRecruiterById(@RequestBody Recruiter recruiter, @PathVariable("id") Integer recrId) {
		Optional<Recruiter> recruiterOptional = recruiterService.findById(recrId);

		if (!recruiterOptional.isPresent()) {
			throw new RecordNotFoundException("recrId" + recrId);
		}

		recruiter.setRecrId(recrId);
		return JsonData.SUCCESS_RESPONSE().withData(recruiterService.save(recruiter));
	}

}

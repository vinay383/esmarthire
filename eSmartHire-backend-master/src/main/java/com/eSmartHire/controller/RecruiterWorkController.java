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
import com.eSmartHire.model.RecruiterWork;
import com.eSmartHire.service.RecruiterWorkService;

@RestController
@RequestMapping(value = "/api")
public class RecruiterWorkController {

	@Autowired
	RecruiterWorkService recruiterWorkService;

	@PostMapping(value = "/v1/recruiter-works")
	public JsonData createRecruiterWorks(@RequestBody RecruiterWork recruiterWork) {

		System.out.println("name: " + recruiterWork.getRecrWorkRecruiterId());
		return JsonData.SUCCESS_RESPONSE("Recruiter Work  created Successfully")
				.withData(recruiterWorkService.save(recruiterWork));
	}

	@GetMapping(value = "/v1/recruiter-works")
	public JsonData getRecruiterWork() {
		return JsonData.SUCCESS_RESPONSE("All Recruiter Works listed successfully")
				.withData(recruiterWorkService.findAll());
	}

	@GetMapping(value = "/v1/recruiter-works/{id}")
	public JsonData getRecruiterWorkById(@PathVariable("id") Integer recrWorkId) {
		Optional<RecruiterWork> recruiterWork = recruiterWorkService.findById(recrWorkId);

		if (!recruiterWork.isPresent()) {
			throw new RecordNotFoundException("recrWorkId: " + recrWorkId);
		}

		return JsonData.SUCCESS_RESPONSE("Recruiter Work  by Id:" + recrWorkId + " listed Successfully")
				.withData(recruiterWork.get());
	}

	@PutMapping(value = "/v1/recruiter-works/{id}")
	public JsonData updateRecruiterWorkById(@RequestBody RecruiterWork recruiterWork,
			@PathVariable("id") Integer recrWorkId) {
		Optional<RecruiterWork> recruiterWorkOptional = recruiterWorkService.findById(recrWorkId);

		if (!recruiterWorkOptional.isPresent()) {
			throw new RecordNotFoundException("recrWorkId" + recrWorkId);
		}

		recruiterWork.setRecrWorkId(recrWorkId);
		return JsonData.SUCCESS_RESPONSE().withData(recruiterWorkService.save(recruiterWork));
	}
}

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
import com.eSmartHire.model.CandidateCertificate;
import com.eSmartHire.service.CandidateCertificateService;

@RestController
@RequestMapping(value = "/api")
public class CandidateCertificateController {

	@Autowired
	CandidateCertificateService candidateCertificateService;

	@PostMapping(value = "/v1/candidate-certificates")
	public JsonData createMasterHobbies(@RequestBody CandidateCertificate candidateCertificate) {

		System.out.println("candidateid: " + candidateCertificate.getCandCertCandidateId()
				+ "candidate certificate name: " + candidateCertificate.getCandCertName()
				+ "candidate certificate description: " + candidateCertificate.getCandCertDescription());
		return JsonData.SUCCESS_RESPONSE("Candidate Certificate created Successfully")
				.withData(candidateCertificateService.save(candidateCertificate));
	}

	@GetMapping(value = "/v1/candidate-certificates")
	public JsonData getCandidateCertificate() {
		return JsonData.SUCCESS_RESPONSE("All candidate certificates  listed successfully")
				.withData(candidateCertificateService.findAll());
	}

	@GetMapping(value = "/v1/candidate-certificates/{id}")
	public JsonData getCandidateCertificateById(@PathVariable("id") Integer candCertId) {
		Optional<CandidateCertificate> candidateCertificate = candidateCertificateService.findById(candCertId);

		if (!candidateCertificate.isPresent()) {
			throw new RecordNotFoundException("candCertId: " + candCertId);
		}

		return JsonData.SUCCESS_RESPONSE("Candidate Certificate  by Id:" + candCertId + " listed Successfully")
				.withData(candidateCertificate.get());
	}

	@PutMapping(value = "/v1/candidate-certificates/{id}")
	public JsonData updateCandidateCertificateById(@RequestBody CandidateCertificate candidateCertificate,
			@PathVariable("id") Integer candCertId) {
		Optional<CandidateCertificate> candidateCertificateOptional = candidateCertificateService.findById(candCertId);

		if (!candidateCertificateOptional.isPresent()) {
			throw new RecordNotFoundException("candCertId" + candCertId);
		}

		candidateCertificate.setCandCertId(candCertId);
		return JsonData.SUCCESS_RESPONSE().withData(candidateCertificateService.save(candidateCertificate));
	}

}

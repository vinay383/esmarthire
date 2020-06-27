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
import com.eSmartHire.model.CandidateTemplateCertificate;
import com.eSmartHire.service.CandidateTemplateCertificateService;

@RestController
@RequestMapping(value = "/api")
public class CandidateTemplateCertificateController {

	@Autowired
	CandidateTemplateCertificateService candidateTemplateCertificateService;

	@PostMapping(value = "/v1/candidate-template-certificates")
	public JsonData createCandidateTemplateCertificates(
			@RequestBody CandidateTemplateCertificate candidateTemplateCertificate) {

		System.out.println("temp id: " + candidateTemplateCertificate.getCtCertCandTempId() + "cert name: "
				+ candidateTemplateCertificate.getCtCertName() + "credential id: "
				+ candidateTemplateCertificate.getCtCertCredentialId());
		return JsonData.SUCCESS_RESPONSE("candidate template certificates created Successfully")
				.withData(candidateTemplateCertificateService.save(candidateTemplateCertificate));
	}

	@GetMapping(value = "/v1/candidate-template-certificates")
	public JsonData getCandidateTemplateCertificate() {
		return JsonData.SUCCESS_RESPONSE("All candidate template certificates  listed successfully")
				.withData(candidateTemplateCertificateService.findAll());
	}

	@GetMapping(value = "/v1/candidate-template-certificates/{id}")
	public JsonData getMasterHobbyById(@PathVariable("id") Integer ctCertId) {
		Optional<CandidateTemplateCertificate> candidateTemplateCertificate = candidateTemplateCertificateService
				.findById(ctCertId);

		if (!candidateTemplateCertificate.isPresent()) {
			throw new RecordNotFoundException("ctCertId: " + ctCertId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Hobby  by Id:" + ctCertId + " listed Successfully")
				.withData(candidateTemplateCertificate.get());
	}

	@PutMapping(value = "/v1/candidate-template-certificates/{id}")
	public JsonData updateMasterHobbyById(@RequestBody CandidateTemplateCertificate candidateTemplateCertificate,
			@PathVariable("id") Integer ctCertId) {
		Optional<CandidateTemplateCertificate> candidateTemplateCertificateOptional = candidateTemplateCertificateService
				.findById(ctCertId);

		if (!candidateTemplateCertificateOptional.isPresent()) {
			throw new RecordNotFoundException("ctCertId" + ctCertId);
		}

		candidateTemplateCertificate.setCtCertId(ctCertId);
		return JsonData.SUCCESS_RESPONSE()
				.withData(candidateTemplateCertificateService.save(candidateTemplateCertificate));
	}

}

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
import com.eSmartHire.model.CandidateTemplateProfileSocialLink;
import com.eSmartHire.service.CandidateTemplateProfileSocialLinkService;

@RestController
@RequestMapping(value = "/api")
public class CandidateTemplateProfileSocialLinkController {

	@Autowired
	CandidateTemplateProfileSocialLinkService candidateTemplateProfileSocialLinkService;

	@PostMapping(value = "/v1/candidate-template-profile-social-link-services")
	public JsonData createCandidateTemplateProfileSocialLinks(
			@RequestBody CandidateTemplateProfileSocialLink candidateTemplateProfileSocialLink) {

		System.out.println("name: " + candidateTemplateProfileSocialLink.getCtpSociLinkCtProfileId());
		return JsonData.SUCCESS_RESPONSE("candidate template profile social link service  created Successfully")
				.withData(candidateTemplateProfileSocialLinkService.save(candidateTemplateProfileSocialLink));
	}

	@GetMapping(value = "/v1/candidate-template-profile-social-link-services")
	public JsonData getCandidateTemplateProfileSocialLink() {
		return JsonData.SUCCESS_RESPONSE("All master Hobbiess  listed successfully")
				.withData(candidateTemplateProfileSocialLinkService.findAll());
	}

	@GetMapping(value = "/v1/candidate-template-profile-social-link-services/{id}")
	public JsonData getCandidateTemplateProfileSocialLinkById(@PathVariable("id") Integer ctpSociLinkId) {
		Optional<CandidateTemplateProfileSocialLink> candidateTemplateProfileSocialLink = candidateTemplateProfileSocialLinkService
				.findById(ctpSociLinkId);

		if (!candidateTemplateProfileSocialLink.isPresent()) {
			throw new RecordNotFoundException("ctpSociLinkId: " + ctpSociLinkId);
		}

		return JsonData
				.SUCCESS_RESPONSE(
						"candidate template profile social link  by Id:" + ctpSociLinkId + " listed Successfully")
				.withData(candidateTemplateProfileSocialLink.get());
	}

	@PutMapping(value = "/v1/candidate-template-profile-social-link-services/{id}")
	public JsonData updateMasterHobbyById(
			@RequestBody CandidateTemplateProfileSocialLink candidateTemplateProfileSocialLink,
			@PathVariable("id") Integer ctpSociLinkId) {
		Optional<CandidateTemplateProfileSocialLink> candidateTemplateProfileSocialLinkOptional = candidateTemplateProfileSocialLinkService
				.findById(ctpSociLinkId);

		if (!candidateTemplateProfileSocialLinkOptional.isPresent()) {
			throw new RecordNotFoundException("ctpSociLinkId" + ctpSociLinkId);
		}

		candidateTemplateProfileSocialLink.setCtpSociLinkId(ctpSociLinkId);
		return JsonData.SUCCESS_RESPONSE()
				.withData(candidateTemplateProfileSocialLinkService.save(candidateTemplateProfileSocialLink));
	}

}

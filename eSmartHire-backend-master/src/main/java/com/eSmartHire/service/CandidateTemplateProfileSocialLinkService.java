package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTemplateProfileSocialLink;

public interface CandidateTemplateProfileSocialLinkService {

	CandidateTemplateProfileSocialLink save(CandidateTemplateProfileSocialLink candidateTemplateProfileSocialLink);

	List<CandidateTemplateProfileSocialLink> findAll();

	Optional<CandidateTemplateProfileSocialLink> findById(Integer ctpSociLinkId);

}

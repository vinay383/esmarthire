package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTemplateProfileSocialLink;
import com.eSmartHire.repository.CandidateTemplateProfileSocialLinkRepository;
import com.eSmartHire.service.CandidateTemplateProfileSocialLinkService;

@Component
public class CandidateTemplateProfileSocialLinkServiceImpl implements CandidateTemplateProfileSocialLinkService {

	@Autowired
	CandidateTemplateProfileSocialLinkRepository candidateTemplateProfileSocialLinkRepository;

	@Override
	public CandidateTemplateProfileSocialLink save(
			CandidateTemplateProfileSocialLink candidateTemplateProfileSocialLink) {
		return candidateTemplateProfileSocialLinkRepository.save(candidateTemplateProfileSocialLink);
	}

	@Override
	public List<CandidateTemplateProfileSocialLink> findAll() {
		return candidateTemplateProfileSocialLinkRepository.findAll();
	}

	@Override
	public Optional<CandidateTemplateProfileSocialLink> findById(Integer ctpSociLinkId) {
		return candidateTemplateProfileSocialLinkRepository.findById(ctpSociLinkId);
	}

}

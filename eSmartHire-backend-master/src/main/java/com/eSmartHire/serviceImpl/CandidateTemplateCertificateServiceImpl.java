package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateTemplateCertificate;
import com.eSmartHire.repository.CandidateTemplateCertificateRepository;
import com.eSmartHire.service.CandidateTemplateCertificateService;

@Component
public class CandidateTemplateCertificateServiceImpl implements CandidateTemplateCertificateService {

	@Autowired
	CandidateTemplateCertificateRepository candidateTemplateCertificateRepository;

	@Override
	public CandidateTemplateCertificate save(CandidateTemplateCertificate candidateTemplateCertificate) {
		return candidateTemplateCertificateRepository.save(candidateTemplateCertificate);
	}

	@Override
	public List<CandidateTemplateCertificate> findAll() {
		return candidateTemplateCertificateRepository.findAll();
	}

	@Override
	public Optional<CandidateTemplateCertificate> findById(Integer ctCertId) {
		return candidateTemplateCertificateRepository.findById(ctCertId);
	}

}

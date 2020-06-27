package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CandidateTemplateCertificate;

public interface CandidateTemplateCertificateService {

	CandidateTemplateCertificate save(CandidateTemplateCertificate candidateTemplateCertificate);

	List<CandidateTemplateCertificate> findAll();

	Optional<CandidateTemplateCertificate> findById(Integer ctCertId);

}

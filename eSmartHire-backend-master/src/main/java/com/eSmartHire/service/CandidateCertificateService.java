package com.eSmartHire.service;

import java.util.Optional;

import com.eSmartHire.model.CandidateCertificate;

public interface CandidateCertificateService {

	CandidateCertificate save(CandidateCertificate candidateCertificate);

	Object findAll();

	Optional<CandidateCertificate> findById(Integer candCertId);

}

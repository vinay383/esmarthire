package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CandidateCertificate;
import com.eSmartHire.repository.CandidateCertificateRepository;
import com.eSmartHire.service.CandidateCertificateService;

@Component
public class CandidateCertificateServiceImpl implements CandidateCertificateService {

	@Autowired
	CandidateCertificateRepository candidateCertificateRepository;

	@Override
	public CandidateCertificate save(CandidateCertificate candidateCertificate) {
		return candidateCertificateRepository.save(candidateCertificate);
	}

	@Override
	public List<CandidateCertificate> findAll() {
		return candidateCertificateRepository.findAll();
	}

	@Override
	public Optional<CandidateCertificate> findById(Integer candCertId) {
		return candidateCertificateRepository.findById(candCertId);
	}
}

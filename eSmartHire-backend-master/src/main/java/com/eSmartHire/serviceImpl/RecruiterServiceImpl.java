package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.Recruiter;
import com.eSmartHire.repository.RecruiterRepository;
import com.eSmartHire.service.RecruiterService;

@Component
public class RecruiterServiceImpl implements RecruiterService {

	@Autowired
	RecruiterRepository recruiterRepository;

	@Override
	public Recruiter save(Recruiter recruiter) {
		return recruiterRepository.save(recruiter);
	}

	@Override
	public List<Recruiter> findAll() {
		return recruiterRepository.findAll();
	}

	@Override
	public Optional<Recruiter> findById(Integer recrId) {
		return recruiterRepository.findById(recrId);
	}

}

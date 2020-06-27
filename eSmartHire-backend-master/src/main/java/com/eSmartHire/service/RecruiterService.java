package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.Recruiter;

public interface RecruiterService {

	Recruiter save(Recruiter recruiter);

	List<Recruiter> findAll();

	Optional<Recruiter> findById(Integer recrId);

}

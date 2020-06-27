package com.eSmartHire.service;

import java.util.Optional;

import com.eSmartHire.model.RecruiterWork;

public interface RecruiterWorkService {

	RecruiterWork save(RecruiterWork recruiterWork);

	Object findAll();

	Optional<RecruiterWork> findById(Integer recrWorkId);

}

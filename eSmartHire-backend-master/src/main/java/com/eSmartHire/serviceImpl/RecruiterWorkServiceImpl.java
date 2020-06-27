package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.RecruiterWork;
import com.eSmartHire.repository.RecruiterWorkRepository;
import com.eSmartHire.service.RecruiterWorkService;

@Component
public class RecruiterWorkServiceImpl implements RecruiterWorkService {

	@Autowired
	RecruiterWorkRepository recruiterWorkRepository;

	@Override
	public RecruiterWork save(RecruiterWork recruiterwork) {
		return recruiterWorkRepository.save(recruiterwork);
	}

	@Override
	public List<RecruiterWork> findAll() {
		return recruiterWorkRepository.findAll();
	}

	@Override
	public Optional<RecruiterWork> findById(Integer recrWorkId) {
		return recruiterWorkRepository.findById(recrWorkId);
	}

}

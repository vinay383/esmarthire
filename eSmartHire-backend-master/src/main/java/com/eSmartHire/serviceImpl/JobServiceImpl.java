package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.Job;
import com.eSmartHire.repository.JobRepository;
import com.eSmartHire.service.JobService;

@Component
public class JobServiceImpl implements JobService {

	@Autowired
	JobRepository jobRepository;

	@Override
	public Job save(Job job) {
		return jobRepository.save(job);
	}

	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public Optional<Job> findById(Integer jobId) {
		return jobRepository.findById(jobId);
	}
}

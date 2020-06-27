package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.Job;

public interface JobService {

	Job save(Job job);

	List<Job> findAll();

	Optional<Job> findById(Integer jobId);

}

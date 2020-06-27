package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.JobInterviewProcess;

public interface JobInterviewProcessService {

	JobInterviewProcess save(JobInterviewProcess jobInterviewProcess);

	List<JobInterviewProcess> findAll();

	Optional<JobInterviewProcess> findById(Integer jInteProcId);

}

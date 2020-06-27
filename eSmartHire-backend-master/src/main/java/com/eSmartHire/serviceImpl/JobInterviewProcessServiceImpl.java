package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.JobInterviewProcess;
import com.eSmartHire.repository.JobInterviewProcessRepository;
import com.eSmartHire.service.JobInterviewProcessService;

@Component
public class JobInterviewProcessServiceImpl implements JobInterviewProcessService {

	@Autowired
	JobInterviewProcessRepository jobInterviewProcessRepository;

	@Override
	public JobInterviewProcess save(JobInterviewProcess jobInterviewProcess) {
		return jobInterviewProcessRepository.save(jobInterviewProcess);
	}

	@Override
	public List<JobInterviewProcess> findAll() {
		return jobInterviewProcessRepository.findAll();
	}

	@Override
	public Optional<JobInterviewProcess> findById(Integer jInteProcId) {
		return jobInterviewProcessRepository.findById(jInteProcId);
	}
}

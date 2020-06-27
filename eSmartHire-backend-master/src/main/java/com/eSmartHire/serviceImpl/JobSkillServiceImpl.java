package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.JobSkill;
import com.eSmartHire.repository.JobSkillRepository;
import com.eSmartHire.service.JobSkillService;

@Component
public class JobSkillServiceImpl implements JobSkillService {

	@Autowired
	JobSkillRepository jobSkillRepository;

	@Override
	public JobSkill save(JobSkill jobSkill) {
		return jobSkillRepository.save(jobSkill);
	}

	@Override
	public Optional<JobSkill> findById(Integer jSkilId) {
		return jobSkillRepository.findById(jSkilId);
	}

	@Override
	public List<JobSkill> findAll() {
		return jobSkillRepository.findAll();
	}

}

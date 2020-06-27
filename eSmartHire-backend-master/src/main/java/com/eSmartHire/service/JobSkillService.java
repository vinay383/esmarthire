package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.JobSkill;

public interface JobSkillService {

	JobSkill save(JobSkill jobSkill);

	List<JobSkill> findAll();

	Optional<JobSkill> findById(Integer jSkilId);

}

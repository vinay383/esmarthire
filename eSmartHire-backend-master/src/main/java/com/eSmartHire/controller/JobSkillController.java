package com.eSmartHire.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eSmartHire.common.JsonData;
import com.eSmartHire.exception.RecordNotFoundException;
import com.eSmartHire.model.JobSkill;
import com.eSmartHire.service.JobSkillService;

@RestController
@RequestMapping(value = "/api")
public class JobSkillController {

	@Autowired
	JobSkillService jobSkillService;

	@PostMapping(value = "/v1/job-skills")
	public JsonData createJobSkills(@RequestBody JobSkill jobSkill) {

		// System.out.println("name: " + jobSkill.getJSkilJobId());
		return JsonData.SUCCESS_RESPONSE("Job Skill created Successfully").withData(jobSkillService.save(jobSkill));
	}

	@GetMapping(value = "/v1/job-skills")
	public JsonData getJobSkill() {
		return JsonData.SUCCESS_RESPONSE("All Job Skills  listed successfully").withData(jobSkillService.findAll());
	}

	@GetMapping(value = "/v1/job-skills/{id}")
	public JsonData getJobSkillById(@PathVariable("id") Integer jSkilId) {
		Optional<JobSkill> jobSkill = jobSkillService.findById(jSkilId);

		if (!jobSkill.isPresent()) {
			throw new RecordNotFoundException("jSkilId: " + jSkilId);
		}

		return JsonData.SUCCESS_RESPONSE("Job Skill by Id:" + jSkilId + " listed Successfully")
				.withData(jobSkill.get());
	}

	@PutMapping(value = "/v1/job-skills/{id}")
	public JsonData updateJobSkillById(@RequestBody JobSkill jobSkill, @PathVariable("id") Integer jSkilId) {
		Optional<JobSkill> jobSkillOptional = jobSkillService.findById(jSkilId);

		if (!jobSkillOptional.isPresent()) {
			throw new RecordNotFoundException("jSkilId" + jSkilId);
		}

		jobSkill.setJSkilId(jSkilId);
		return JsonData.SUCCESS_RESPONSE().withData(jobSkillService.save(jobSkill));
	}
}

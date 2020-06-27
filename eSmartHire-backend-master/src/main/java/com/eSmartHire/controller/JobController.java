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
import com.eSmartHire.model.Job;
import com.eSmartHire.service.JobService;

@RestController
@RequestMapping(value = "/api")
public class JobController {
	@Autowired
	JobService jobService;

	@PostMapping(value = "/v1/jobs")
	public JsonData createJobs(@RequestBody Job job) {

		System.out.println("r: " + job.getJobRecruiterId());
		return JsonData.SUCCESS_RESPONSE("Job  created Successfully").withData(jobService.save(job));
	}

	@GetMapping(value = "/v1/jobs")
	public JsonData getJob() {
		return JsonData.SUCCESS_RESPONSE("All Jobs  listed successfully").withData(jobService.findAll());
	}

	@GetMapping(value = "/v1/jobs/{id}")
	public JsonData JobById(@PathVariable("id") Integer jobId) {
		Optional<Job> job = jobService.findById(jobId);

		if (!job.isPresent()) {
			throw new RecordNotFoundException("hobbId: " + jobId);
		}

		return JsonData.SUCCESS_RESPONSE("Job by Id:" + jobId + " listed Successfully").withData(job.get());
	}

	@PutMapping(value = "/v1/jobs/{id}")
	public JsonData updateJobById(@RequestBody Job job, @PathVariable("id") Integer jobId) {
		Optional<Job> jobOptional = jobService.findById(jobId);

		if (!jobOptional.isPresent()) {
			throw new RecordNotFoundException("jobId" + jobId);
		}

		job.setJobId(jobId);
		return JsonData.SUCCESS_RESPONSE().withData(jobService.save(job));
	}

}

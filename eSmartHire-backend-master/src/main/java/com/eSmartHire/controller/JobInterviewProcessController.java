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
import com.eSmartHire.model.JobInterviewProcess;
import com.eSmartHire.service.JobInterviewProcessService;

@RestController
@RequestMapping(value = "/api")
public class JobInterviewProcessController {

	@Autowired
	JobInterviewProcessService jobInterviewProcessService;

	@PostMapping(value = "/v1/job-interview-processes")
	public JsonData createJobInterviewProcesses(@RequestBody JobInterviewProcess jobInterviewProcess) {

		//System.out.println("process id: " + jobInterviewProcess.getJInteProcId()+"process name: " + jobInterviewProcess.getJInteProcName());
		return JsonData.SUCCESS_RESPONSE("Job Interview Process created Successfully")
				.withData(jobInterviewProcessService.save(jobInterviewProcess));
	}

	@GetMapping(value = "/v1/job-interview-processes")
	public JsonData getJobInterviewProcess() {
		return JsonData.SUCCESS_RESPONSE("All job interview processes   listed successfully")
				.withData(jobInterviewProcessService.findAll());
	}

	@GetMapping(value = "/v1/job-interview-processes/{id}")
	public JsonData getMJobInterviewProcess(@PathVariable("id") Integer jInteProcId) {
		Optional<JobInterviewProcess> jobInterviewProcess = jobInterviewProcessService.findById(jInteProcId);

		if (!jobInterviewProcess.isPresent()) {
			throw new RecordNotFoundException("jInteProcId: " + jInteProcId);
		}

		return JsonData.SUCCESS_RESPONSE("Job Interview process By  by Id:" + jInteProcId + " listed Successfully")
				.withData(jobInterviewProcess.get());
	}

	@PutMapping(value = "/v1/job-interview-processes/{id}")
	public JsonData updateJobInterviewProcessById(@RequestBody JobInterviewProcess jobInterviewProcess,
			@PathVariable("id") Integer jInteProcId) {
		Optional<JobInterviewProcess> jobInterviewProcessOptional = jobInterviewProcessService.findById(jInteProcId);

		if (!jobInterviewProcessOptional.isPresent()) {
			throw new RecordNotFoundException("jInteProcId" + jInteProcId);
		}

		jobInterviewProcess.setJInteProcId(jInteProcId);
		return JsonData.SUCCESS_RESPONSE().withData(jobInterviewProcessService.save(jobInterviewProcess));
	}

}

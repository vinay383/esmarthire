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
import com.eSmartHire.model.MasterPlan;
import com.eSmartHire.service.MasterPlanService;

@RestController
@RequestMapping(value = "/api")
public class MasterPlanController {

	@Autowired
	MasterPlanService masterPlanService;

	@PostMapping(value = "/v1/master-plans")
	public JsonData createMasterPlans(@RequestBody MasterPlan masterPlan) {

		System.out.println("name: " + masterPlan.getPlanName() + "benefit: " + masterPlan.getPlanBenefit() + "price: "
				+ masterPlan.getPlanPrice() + "duration: " + masterPlan.getPlanDuration());
		return JsonData.SUCCESS_RESPONSE("Master Plan created Successfully")
				.withData(masterPlanService.save(masterPlan));
	}

	@GetMapping(value = "/v1/master-plans")
	public JsonData getMasterPlan() {
		return JsonData.SUCCESS_RESPONSE("All master plans  listed successfully").withData(masterPlanService.findAll());
	}

	@GetMapping(value = "/v1/master-plans/{id}")
	public JsonData getMasterPlanById(@PathVariable("id") Integer planId) {
		Optional<MasterPlan> masterPlan = masterPlanService.findById(planId);

		if (!masterPlan.isPresent()) {
			throw new RecordNotFoundException("hobbId: " + planId);
		}

		return JsonData.SUCCESS_RESPONSE("Master Plan  by Id:" + planId + " listed Successfully")
				.withData(masterPlan.get());
	}

	@PutMapping(value = "/v1/master-plans/{id}")
	public JsonData updateMasterPlanById(@RequestBody MasterPlan masterPlan, @PathVariable("id") Integer planId) {
		Optional<MasterPlan> masterPlanOptional = masterPlanService.findById(planId);

		if (!masterPlanOptional.isPresent()) {
			throw new RecordNotFoundException("planId" + planId);
		}

		masterPlan.setPlanId(planId);
		return JsonData.SUCCESS_RESPONSE().withData(masterPlanService.save(masterPlan));
	}

}

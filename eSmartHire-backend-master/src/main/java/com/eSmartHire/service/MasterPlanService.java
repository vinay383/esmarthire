package com.eSmartHire.service;

import java.util.Optional;

import com.eSmartHire.model.MasterPlan;

public interface MasterPlanService {

	MasterPlan save(MasterPlan masterPlan);

	Object findAll();

	Optional<MasterPlan> findById(Integer planId);

}

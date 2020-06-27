package com.eSmartHire.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterPlan;
import com.eSmartHire.repository.MasterPlanRepository;
import com.eSmartHire.service.MasterPlanService;

@Component
public class MasterPlanServiceImpl implements MasterPlanService {

	@Autowired
	MasterPlanRepository masterPlanRepository;

	@Override
	public MasterPlan save(MasterPlan masterPlan) {
		return masterPlanRepository.save(masterPlan);
	}

	@Override
	public Object findAll() {
		return masterPlanRepository.findAll();

	}

	@Override
	public Optional<MasterPlan> findById(Integer planId) {
		return masterPlanRepository.findById(planId);
	}

}

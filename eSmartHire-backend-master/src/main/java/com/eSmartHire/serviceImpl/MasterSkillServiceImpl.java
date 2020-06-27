package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterSkill;
import com.eSmartHire.repository.MasterSkillRepository;
import com.eSmartHire.service.MasterSkillService;

@Component
public class MasterSkillServiceImpl implements MasterSkillService {

	@Autowired
	MasterSkillRepository masterSkillRepository;

	@Override
	public MasterSkill save(MasterSkill masterSkill) {
		return masterSkillRepository.save(masterSkill);
	}

	@Override
	public List<MasterSkill> findAll() {
		return masterSkillRepository.findAll();

	}

	@Override
	public Optional<MasterSkill> findById(Integer skilId) {
		return masterSkillRepository.findById(skilId);
	}
}

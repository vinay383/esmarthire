package com.eSmartHire.service;

import java.util.Optional;

import com.eSmartHire.model.MasterSkill;

public interface MasterSkillService {

	MasterSkill save(MasterSkill masterSkill);

	Object findAll();

	Optional<MasterSkill> findById(Integer skilId);

}

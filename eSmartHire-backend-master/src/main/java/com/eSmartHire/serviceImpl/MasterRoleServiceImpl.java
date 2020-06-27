package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterRole;
import com.eSmartHire.repository.MasterRoleRepository;
import com.eSmartHire.service.MasterRoleService;

@Component
public class MasterRoleServiceImpl implements MasterRoleService {

	@Autowired
	MasterRoleRepository masterRoleRepository;

	@Override
	public MasterRole save(MasterRole masterRole) {
		return masterRoleRepository.save(masterRole);
	}

	@Override
	public List<MasterRole> findAll() {
		return masterRoleRepository.findAll();
	}

	@Override
	public Optional<MasterRole> findById(Integer roleId) {
		return masterRoleRepository.findById(roleId);
	}

}

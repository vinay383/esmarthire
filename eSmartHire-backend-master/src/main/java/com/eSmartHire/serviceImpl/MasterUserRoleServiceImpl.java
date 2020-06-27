package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterUserRole;
import com.eSmartHire.repository.MasterUserRoleRepository;
import com.eSmartHire.service.MasterUserRoleService;

@Component
public class MasterUserRoleServiceImpl implements MasterUserRoleService {

	@Autowired
	MasterUserRoleRepository masterUserRoleRepository;

	@Override
	public MasterUserRole save(MasterUserRole masterUserRole) {
		return masterUserRoleRepository.save(masterUserRole);
	}

	@Override
	public List<MasterUserRole> findAll() {
		return masterUserRoleRepository.findAll();
	}

	@Override
	public Optional<MasterUserRole> findById(Integer urId) {
		return masterUserRoleRepository.findById(urId);
	}

}

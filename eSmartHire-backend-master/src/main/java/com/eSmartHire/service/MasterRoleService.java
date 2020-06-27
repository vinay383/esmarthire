package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.MasterRole;

public interface MasterRoleService {

	MasterRole save(MasterRole masterRole);

	List<MasterRole> findAll();

	Optional<MasterRole> findById(Integer roleId);
}

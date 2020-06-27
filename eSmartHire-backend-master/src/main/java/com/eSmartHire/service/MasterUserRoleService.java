package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.MasterUserRole;

public interface MasterUserRoleService {

	MasterUserRole save(MasterUserRole masterUserRole);

	List<MasterUserRole> findAll();

	Optional<MasterUserRole> findById(Integer urId);

}

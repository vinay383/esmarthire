package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.MasterUser;

public interface MasterUserService {

	MasterUser save(MasterUser masterUser);

	List<MasterUser> findAll();

	Optional<MasterUser> findById(Integer userId);

}

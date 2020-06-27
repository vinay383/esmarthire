package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.MasterCompany;

public interface MasterCompanyService {

	// Object save(MasterCompany masterCompany);
	MasterCompany save(MasterCompany masterCompany);

	List<MasterCompany> findAll();

	Optional<MasterCompany> findById(Integer compId);

}

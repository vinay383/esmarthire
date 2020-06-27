package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.CompanyLocation;

public interface CompanyLocationService {

	List<CompanyLocation> findAll();

	Optional<CompanyLocation> findById(Integer compLocaId);

//	CompanyLocation updateById(Integer compLocaId);

	CompanyLocation save(CompanyLocation companyLocation);

}

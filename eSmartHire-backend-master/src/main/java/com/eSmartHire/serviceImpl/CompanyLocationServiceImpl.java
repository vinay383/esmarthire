package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.CompanyLocation;
import com.eSmartHire.repository.CompanyLocationRepository;
import com.eSmartHire.service.CompanyLocationService;

@Component
public class CompanyLocationServiceImpl implements CompanyLocationService {

	@Autowired
	CompanyLocationRepository companyLocationRepository;

	@Override
	public List<CompanyLocation> findAll() {
		return companyLocationRepository.findAll();
	}

	@Override
	public Optional<CompanyLocation> findById(Integer compLocaId) {
		return companyLocationRepository.findById(compLocaId);
	}

//	@Override
//	public CompanyLocation updateById(Integer compLocaId) {
//		//return companyLocationRepository.updateById(compLocaId);
//		return null;
//	}

	@Override
	public CompanyLocation save(CompanyLocation companyLocation) {
		return companyLocationRepository.save(companyLocation);
	}
}

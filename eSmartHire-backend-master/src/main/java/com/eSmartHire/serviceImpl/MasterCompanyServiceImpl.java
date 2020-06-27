package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterCompany;
import com.eSmartHire.repository.MasterCompanyRepository;
import com.eSmartHire.service.MasterCompanyService;

@Component
public class MasterCompanyServiceImpl implements MasterCompanyService {

	@Autowired
	MasterCompanyRepository masterCompanyRepository;

	@Override
	public MasterCompany save(MasterCompany masterCompany) {
		return masterCompanyRepository.save(masterCompany);
	}

	@Override
	public List<MasterCompany> findAll() {
		return masterCompanyRepository.findAll();
	}

	@Override
	public Optional<MasterCompany> findById(Integer compId) {
		// TODO Auto-generated method stub
		return masterCompanyRepository.findById(compId);
	}

}

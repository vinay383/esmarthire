package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterSocialAccountType;
import com.eSmartHire.repository.MasterSocialAccountTypeRepository;
import com.eSmartHire.service.MasterSocialAccountTypeService;

@Component
public class MasterSocialAccountTypeServiceImpl implements MasterSocialAccountTypeService {

	@Autowired
	MasterSocialAccountTypeRepository masterSocialAccountTypeRepository;

	@Override
	public MasterSocialAccountType save(MasterSocialAccountType masterSocialAccountType) {
		return masterSocialAccountTypeRepository.save(masterSocialAccountType);
	}

	@Override
	public List<MasterSocialAccountType> findAll() {
		return masterSocialAccountTypeRepository.findAll();
	}

	@Override
	public Optional<MasterSocialAccountType> findById(Integer sociAccoTypeId) {
		return masterSocialAccountTypeRepository.findById(sociAccoTypeId);
	}

}

package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.MasterSocialAccountType;

public interface MasterSocialAccountTypeService {

	MasterSocialAccountType save(MasterSocialAccountType masterSocialAccountType);

	List<MasterSocialAccountType> findAll();

	Optional<MasterSocialAccountType> findById(Integer sociAccoTypeId);

}

package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.MasterLocationCity;

public interface MasterLocationCityService {

	MasterLocationCity save(MasterLocationCity masterLocationCity);

	List<MasterLocationCity> findAll();

	Optional<MasterLocationCity> findById(Integer locationCityId);

}

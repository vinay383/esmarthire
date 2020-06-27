package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterLocationCity;
import com.eSmartHire.repository.MasterLocationCityRepository;
import com.eSmartHire.service.MasterLocationCityService;

@Component
public class MasterLocationCityServiceImpl implements MasterLocationCityService {

	@Autowired
	MasterLocationCityRepository masterLocationCityRepository;

	@Override
	public MasterLocationCity save(MasterLocationCity masterLocationCity) {
		return masterLocationCityRepository.save(masterLocationCity);
	}

	@Override
	public List<MasterLocationCity> findAll() {
		return masterLocationCityRepository.findAll();
	}

	@Override
	public Optional<MasterLocationCity> findById(Integer hobbId) {
		return masterLocationCityRepository.findById(hobbId);
	}

}

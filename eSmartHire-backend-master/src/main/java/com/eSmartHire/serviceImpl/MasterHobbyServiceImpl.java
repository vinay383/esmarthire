package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterHobby;
import com.eSmartHire.repository.MasterHobbyRepository;
import com.eSmartHire.service.MasterHobbyService;

@Component
public class MasterHobbyServiceImpl implements MasterHobbyService {

	@Autowired
	MasterHobbyRepository masterHobbyRepository;

	@Override
	public MasterHobby save(MasterHobby masterHobby) {
		return masterHobbyRepository.save(masterHobby);
	}

	@Override
	public Optional<MasterHobby> findById(Integer locationCityId) {
		return masterHobbyRepository.findById(locationCityId);
	}

	@Override
	public List<MasterHobby> findAll() {
		return masterHobbyRepository.findAll();
	}

}

package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.MasterHobby;

public interface MasterHobbyService {

	MasterHobby save(MasterHobby masterHobby);

	List<MasterHobby> findAll();

	Optional<MasterHobby> findById(Integer hobbId);

}

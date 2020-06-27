package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterUser;
import com.eSmartHire.repository.MasterUserRepository;
import com.eSmartHire.service.MasterUserService;

@Component
public class MasterUserServiceImpl implements MasterUserService {

	@Autowired
	MasterUserRepository masterUserRepository;

	@Override
	public MasterUser save(MasterUser masterUser) {
		return masterUserRepository.save(masterUser);
	}

	@Override
	public List<MasterUser> findAll() {
		return masterUserRepository.findAll();
	}

	@Override
	public Optional<MasterUser> findById(Integer userId) {
		return masterUserRepository.findById(userId);
	}
}

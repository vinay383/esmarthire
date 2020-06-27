package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterTool;
import com.eSmartHire.repository.MasterToolRepository;
import com.eSmartHire.service.MasterToolService;

@Component
public class MasterToolServiceImpl implements MasterToolService {

	@Autowired
	MasterToolRepository masterToolRepository;

	@Override
	public MasterTool save(MasterTool masterTool) {
		return masterToolRepository.save(masterTool);
	}

	@Override
	public List<MasterTool> findAll() {
		return masterToolRepository.findAll();
	}

	@Override
	public Optional<MasterTool> findById(Integer toolId) {
		return masterToolRepository.findById(toolId);
	}

}

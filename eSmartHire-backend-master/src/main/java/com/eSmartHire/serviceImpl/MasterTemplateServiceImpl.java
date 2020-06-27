package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterTemplate;
import com.eSmartHire.repository.MasterTemplateRepository;
import com.eSmartHire.service.MasterTemplateService;

@Component
public class MasterTemplateServiceImpl implements MasterTemplateService {

	@Autowired
	MasterTemplateRepository masterTemplateRepository;

	@Override
	public MasterTemplate save(MasterTemplate masterTemplate) {
		return masterTemplateRepository.save(masterTemplate);
	}

	@Override
	public List<MasterTemplate> findAll() {
		return masterTemplateRepository.findAll();
	}

	@Override
	public Optional<MasterTemplate> findById(Integer tempId) {
		return masterTemplateRepository.findById(tempId);
	}

}

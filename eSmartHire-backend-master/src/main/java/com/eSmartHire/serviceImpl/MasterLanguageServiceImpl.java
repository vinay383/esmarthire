package com.eSmartHire.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterLanguage;
import com.eSmartHire.repository.MasterLanguageRepository;
import com.eSmartHire.service.MasterLanguageService;

@Component
public class MasterLanguageServiceImpl implements MasterLanguageService {

	@Autowired
	MasterLanguageRepository masterLanguageRepository;

	@Override
	public MasterLanguage save(MasterLanguage masterLanguage) {
		return masterLanguageRepository.save(masterLanguage);
	}

	@Override
	public List<MasterLanguage> findAll() {
		return masterLanguageRepository.findAll();
	}

	@Override
	public Optional<MasterLanguage> findById(Integer langId) {
		return masterLanguageRepository.findById(langId);
	}

}

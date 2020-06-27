package com.eSmartHire.service;

import java.util.Optional;

import com.eSmartHire.model.MasterLanguage;

public interface MasterLanguageService {

	MasterLanguage save(MasterLanguage masterLanguage);

	Object findAll();

	Optional<MasterLanguage> findById(Integer langId);

}

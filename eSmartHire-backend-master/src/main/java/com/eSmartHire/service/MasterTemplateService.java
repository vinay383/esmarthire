package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.MasterTemplate;

public interface MasterTemplateService {

	MasterTemplate save(MasterTemplate masterTemplate);

	List<MasterTemplate> findAll();

	Optional<MasterTemplate> findById(Integer tempId);

}

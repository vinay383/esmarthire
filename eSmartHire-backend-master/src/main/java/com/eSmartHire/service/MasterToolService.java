package com.eSmartHire.service;

import java.util.List;
import java.util.Optional;

import com.eSmartHire.model.MasterTool;

public interface MasterToolService {

	MasterTool save(MasterTool masterTool);

	List<MasterTool> findAll();

	Optional<MasterTool> findById(Integer toolId);

}

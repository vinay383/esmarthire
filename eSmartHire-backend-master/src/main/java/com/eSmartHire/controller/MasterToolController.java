package com.eSmartHire.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eSmartHire.common.JsonData;
import com.eSmartHire.exception.RecordNotFoundException;
import com.eSmartHire.model.MasterTool;
import com.eSmartHire.service.MasterToolService;

@RestController
@RequestMapping(value = "/api")
public class MasterToolController {
	
	@Autowired
	MasterToolService masterToolService;
	
	@PostMapping(value = "/v1/master-tools")
	    public JsonData createMasterTools(@RequestBody MasterTool masterTool) {
		 
			System.out.println("name: "+masterTool.getToolName()+"url: "+masterTool.getToolUrl()+"filepath: "+masterTool.getToolFilepath());
			return JsonData.SUCCESS_RESPONSE("Master Tool created Successfully")
					.withData(masterToolService.save(masterTool));	
			}

	 
	 @GetMapping(value = "/v1/master-tools")
		public JsonData getMasterTool() {
			return JsonData.SUCCESS_RESPONSE("All master tools  listed successfully")
					.withData(masterToolService.findAll());
		}
	 
	 
	 @GetMapping(value = "/v1/master-tools/{id}")
		public JsonData getMasterToolById(@PathVariable("id") Integer toolId) {
			Optional<MasterTool> masterTool = masterToolService.findById(toolId);

			if (!masterTool.isPresent()) {
				throw new RecordNotFoundException("toolId: " + toolId);
			}

			return JsonData.SUCCESS_RESPONSE("Master Hobby  by Id:" + toolId + " listed Successfully")
					.withData(masterTool.get());
		}
	 
	 
		@PutMapping(value = "/v1/master-tools/{id}")
		public JsonData updateMasterToolById(@RequestBody MasterTool masterTool,
				@PathVariable("id") Integer toolId) {
			Optional<MasterTool> masterToolOptional = masterToolService.findById(toolId);

			if (!masterToolOptional.isPresent()) {
				throw new RecordNotFoundException("toolId" + toolId);
			}

			masterTool.setToolId(toolId);
			return JsonData.SUCCESS_RESPONSE().withData(masterToolService.save(masterTool));
		}
	
}

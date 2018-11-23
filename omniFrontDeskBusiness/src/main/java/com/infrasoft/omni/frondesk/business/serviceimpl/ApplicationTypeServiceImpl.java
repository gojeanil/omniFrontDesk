package com.infrasoft.omni.frondesk.business.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.infrasoft.omni.frondesk.business.service.ApplicationTypeService;
import com.infrasoft.omni.frontdesk.dto.ApplicationTypeDTO;
import com.infrasoft.omni.frontdesk.dto.dtoservice.ApplicationTypeDTOService;

@Component("applicationTypeService")
public class ApplicationTypeServiceImpl implements ApplicationTypeService {

	@Autowired
	ApplicationTypeDTOService applicationTypeDTOService;
	
	public List<ApplicationTypeDTO> readAll() {
		return applicationTypeDTOService.readAll();
	}

}

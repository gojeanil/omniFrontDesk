package com.infrasoft.omni.frontdesk.dto.dtoservice;


import java.util.List;

import com.infrasoft.omni.frontdesk.dto.ApplicationTypeDTO;

/**
 * Author: Anil Goje
 * Company: Self
 * Date: Nov 22 , 2018
 * Time: 11:26:13 AM
 */

public interface ApplicationTypeDTOService extends DtoService<ApplicationTypeDTO, Long>  {
	
	List<ApplicationTypeDTO> findAll();

}

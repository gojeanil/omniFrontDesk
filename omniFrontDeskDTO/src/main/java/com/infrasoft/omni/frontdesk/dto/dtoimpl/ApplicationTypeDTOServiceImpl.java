package com.infrasoft.omni.frontdesk.dto.dtoimpl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.infrasoft.omni.frontdesk.dto.ApplicationTypeDTO;
import com.infrasoft.omni.frontdesk.dto.dtoservice.ApplicationTypeDTOService;

/**
 * Author: Anil Goje
 * Company: Self
 * Date: Nov 22 , 2018
 * Time: 11:26:13 AM
 */

@Repository("applicationTypeDTOService")
public class ApplicationTypeDTOServiceImpl extends DtoSetviceImpl<ApplicationTypeDTO,Long> implements ApplicationTypeDTOService {

	
	@PersistenceContext
    private EntityManager em;

    public List<ApplicationTypeDTO> findAll() {
        System.out.println("ApplicationTypeDTOSeriveImpl.findAll: ");
        Query query = em.createQuery("select o from ApplicationTypeDTO ");
        //query.setParameter("companyCode", companyCode);
        return query.getResultList();
    }
    

	

}

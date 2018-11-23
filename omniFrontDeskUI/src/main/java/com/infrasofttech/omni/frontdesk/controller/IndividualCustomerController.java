package com.infrasofttech.omni.frontdesk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.infrasoft.omni.frondesk.business.service.ApplicationTypeService;
import com.infrasoft.omni.frontdesk.dto.ApplicationTypeDTO;
import com.infrasofttech.omni.frontdesk.VO.ApplicationTypeVO;

@Controller
public class IndividualCustomerController {

	
	@Autowired
	ApplicationTypeService  applicationTypeService;
	
	
	@GetMapping("/hello")
	public String hello(Model model) {
		System.out.println("Welcome...");
		model.addAttribute("name", "Tushar");
		
		List<ApplicationTypeDTO> dtos=applicationTypeService.readAll();
		
		List<ApplicationTypeVO> vos=new ArrayList<ApplicationTypeVO>();
		
		dtos.forEach(dto -> {
			System.out.println(dto);
			ApplicationTypeVO vo=new ApplicationTypeVO();
			vo.setId(dto.getId());
			vo.setName(dto.getName());
			vos.add(vo);
			
		});
		
		System.out.println(dtos);
		model.addAttribute("applicationTypes", vos);
		
		return "individualcustomer";
	}
}
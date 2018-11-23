package com.infrasofttech.omni.frontdesk.VO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Author: Anil Goje
 * Company: Self
 * Date: Nov 22 , 2018
 * Time: 11:26:13 AM
 */

public class ApplicationTypeVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Integer Id;
	
	String Name;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

}

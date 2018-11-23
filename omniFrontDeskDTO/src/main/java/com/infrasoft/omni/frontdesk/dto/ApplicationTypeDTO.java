package com.infrasoft.omni.frontdesk.dto;

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

@Entity
@Table(name = "APPLICATION_TYPE")
//@NamedQuery(name = "ApplicationType.findAll", query = "SELECT e FROM ApplicationType e")
public class ApplicationTypeDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4752617964198954563L;

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Anil : you can use sequence 
	@Column(name = "id") 
	Integer Id;
	
	@Column(name = "name") 
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
	@Override
	public String toString() {
		return "ApplicationTypeDTO [Id=" + Id + ", Name=" + Name + "]";
	}

}

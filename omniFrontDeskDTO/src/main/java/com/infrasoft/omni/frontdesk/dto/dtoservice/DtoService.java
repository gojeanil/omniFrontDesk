package com.infrasoft.omni.frontdesk.dto.dtoservice;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;


/**
 * Author: Anil Kumar Goje
 * Company: Self
 * Date: Nov 22, 2018
 * Time: 2:07:08 PM
 */

public interface DtoService<T, ID extends Serializable> {
    public List<T> read();

    public T read(ID id);
    
    public List<T> readAll();

    public T read(String id) throws NoResultException;

	public List<T>  orderByList(String fieldName, String sortType);

    public void save(T t);

    public void delete(T t);

    public void update(T object);

    public void flush();

    public T findBy(String fieldName, Object value);

    public List<T> findAllBy(String fieldName, Object value);

    public T getSingleResult(Query query);
    
    
    
}

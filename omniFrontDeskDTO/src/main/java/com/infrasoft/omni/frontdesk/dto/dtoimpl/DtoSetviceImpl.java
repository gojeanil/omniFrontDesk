package com.infrasoft.omni.frontdesk.dto.dtoimpl;

import org.apache.log4j.Logger;

import com.infrasoft.omni.frontdesk.dto.dtoservice.DtoService;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Author: Anil Kumar Goje
 * Company: Self
 * Date: Nov 22, 2018
 * Time: 2:07:08 PM
 */

public abstract class DtoSetviceImpl<T,ID extends Serializable> implements DtoService<T,ID> {
    
	@PersistenceContext
    private EntityManager em;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public DtoSetviceImpl() {
        entityClass = (Class<T>)
            ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];
    }

    public void save(T object) {
//        log.debug("save called for "+entityClass.getName());
        em.persist(object);
    }

    public void delete(T object) {
        em.remove(object);
    }

    public T read(ID id) {
        return em.find(entityClass, id);
    }

    public T read(String id) throws NoResultException {
        return em.find(entityClass, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<T> read() {
        return em.createQuery("from " + entityClass.getName()).getResultList();
    }

	@SuppressWarnings("unchecked")
    public List<T> orderByList(String fieldName, String sortType) {
        return em.createQuery("from " + entityClass.getName() + " e Order by e." + fieldName + "  " + sortType).getResultList();
    }

    public void update(T object) {
//        log.debug("update called for "+entityClass.getName());
        em.merge(object);
    }

    public void flush() {
        em.flush();
    }

    public T findBy(String fieldName, Object value) {
        Query query = em.createQuery(getQuery(fieldName)).setParameter(fieldName, value);
        return getSingleResult(query);
    }

    @SuppressWarnings("unchecked")
	public List<T> findAllBy(String fieldName, Object value) {
        Query query = em.createQuery(getQuery(fieldName)).setParameter(fieldName, value);
        return query.getResultList();
    }

    private String getQuery(String fieldName){
//        log.debug("query = "+"from " + entityClass.getName() + " t where t." + fieldName + " = :" + fieldName);
        return "from " + entityClass.getName() + " t where t." + fieldName + " = :" + fieldName;
    }

    @SuppressWarnings("unchecked")
    public T getSingleResult(Query query) throws NoResultException {
        try {
            return (T) query.getSingleResult();
        }
        catch (NonUniqueResultException exc) {
            return (T) query.getResultList().get(0);
        }
//        catch (NoResultException exc) {
//            return null;
//        }
    }
    
    @SuppressWarnings("unchecked")
    public List<T> readAll() throws NoResultException {
    	Query query = em.createQuery("from "+entityClass.getName());
        return query.getResultList();
    }
    
    
    
    
}
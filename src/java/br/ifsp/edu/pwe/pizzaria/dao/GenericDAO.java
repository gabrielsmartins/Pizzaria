package br.ifsp.edu.pwe.pizzaria.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.ifsp.edu.pwe.pizzaria.util.HibernateUtil;

public abstract class GenericDAO<T, I extends Serializable> {



   protected EntityManager entityManager;

   private Class<T> persistedClass;

   protected GenericDAO() {
   }

   protected GenericDAO(Class<T> persistedClass) {
       this();
       this.persistedClass = persistedClass;
       entityManager = 	HibernateUtil.getEntityManager();
   }

   public T insert(T entity) {
       EntityTransaction t = entityManager.getTransaction();
       t.begin();
       entityManager.persist(entity);
       entityManager.flush();
       t.commit();
       return entity;
   }

   public T update(T entity) {
       EntityTransaction t = entityManager.getTransaction();
       t.begin();
       entityManager.merge(entity);
       entityManager.flush();
       t.commit();
       return entity;
   }

   public void delete(I id) {
       T entity = find(id);
       EntityTransaction t = entityManager.getTransaction();
       t.begin();
       //T mergedEntity = entityManager.merge(entity);
       entityManager.remove(entity);
       entityManager.flush();
       t.commit();
   }

   public List<T> getList() {
       CriteriaBuilder builder = entityManager.getCriteriaBuilder();
       CriteriaQuery<T> query = builder.createQuery(persistedClass);
       query.from(persistedClass);
       return entityManager.createQuery(query).getResultList();
   }
   
   public T find(I id) {
       return entityManager.find(persistedClass, id);
   }
}
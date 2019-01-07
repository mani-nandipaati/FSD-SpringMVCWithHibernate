package com.cts.iiht.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.Subject;

@Repository
public class SubjectDao {
	
	@PersistenceContext
	private EntityManager em;

	public void addSubject(Subject subject) {
		/*EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
        txn.begin();*/
        em.persist(subject);
        //txn.commit();
		System.out.println("Subject added succesfully");
	}

	public void deleteSubject(long id) {
		Subject subject = searchSubject(id);
		if(subject != null) {
			/*EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction txn = em.getTransaction();
	        txn.begin();*/
	        em.remove(em.merge(subject));
	        //txn.commit();
			System.out.println("Subject with id: "+ id + " has been deleted successfully");
		}
		else {
			System.out.println("No Subject found with id: "+ id );
		}
	}

	public Subject searchSubject(long id) {
		//EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		return em.find(Subject.class, id);
	}
	
	public List<Subject> getAllSubjects() {
		//EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		return em.createQuery("FROM Subject s").getResultList();
	}
	
	public List<Subject> getAllSubjectsSortBySubTitle(){
		//EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		return em.createQuery("FROM Subject s order by s.subtitle").getResultList();
	}
	
	
}
package com.cts.iiht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.dao.SubjectDao;
import com.cts.iiht.model.Subject;

@Service
@Transactional
public class SubjectService {
	
	@Autowired
	SubjectDao subjectDao;
	
	public void addSubject(Subject subject) {
		subjectDao.addSubject(subject);
	}
	
	public void deleteSubject(long id) {
		subjectDao.deleteSubject(id);
	}

	public Subject searchSubject(long id) {
		return subjectDao.searchSubject(id);
	}
}

package com.ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssa.entity.Student;

@Transactional
@Component
@Repository
public class StudentDAO implements IStudentDAO {

	    @Autowired
	    private HibernateTemplate  hibernateTemplate;

	    @SuppressWarnings("unchecked")
	    @Override
	    public List<Student> getAllStudents() {
	        String hql = "FROM Student as s ORDER BY s.id";
	        return (List<Student>) hibernateTemplate.find(hql);
	    }

	    @Override
	    public Student getStudentById(int studentId) {
	        return (Student) hibernateTemplate.get(Student.class, studentId);
	    
		}

		@Override
		public boolean addStudent(Student student) {
			// TODO Auto-generated method stub
			return false;
		}

//		@Override
//		public void updateStudent(Student student) {
//			hibernateTemplate.update(Student.class, studentId);
//		}

		@Override
		public void deleteStudent(int studentId) {
			hibernateTemplate.delete(hibernateTemplate.get(Student.class,studentId));
			
		}

		@Override
		public void updateStudent(Student student) {
			// TODO Auto-generated method stub
			
		}
	}



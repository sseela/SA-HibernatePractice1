package TestClient;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class TestClient {
	public static void main(String[] args) {
		/*Configuration cfg = new Configuration();
		cfg.configure("resources/Student.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Student stud = new Student(2,"ssdd", 345);
		s.save(stud);
		t.commit();
		s.close();
		sf.close();*/
		
		//CRUD operations - 
		// insert - save, persist, saveorupdate
		// update - update, merge
		// delete - delete
		
		Student student = new Student(9090, "eee", 233);
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/Student.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session =  sf.openSession();
		Transaction t = session.beginTransaction();
		
		session.save(student);
		session.flush();
		String s = null;
		s.concat("s");
		//using CriteriaQuery
		/*CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		criteriaQuery.select(root);
		
		List<Student> stud = session.createQuery(criteriaQuery).getResultList();
		stud.forEach(st -> System.out.println(st.getName()));*/
		
		
		//using JPQL or HQL
		/*List<Student> list = session.createQuery("From Student s where s.id =:arg").setParameter("arg", 555).getResultList();
		list.forEach(st -> System.out.println(st.getName()));*/
		
		t.commit();
		session.close();
		
		/*student.setName("sandeep");			//detached object
		
		Session session2 = sf.openSession();
		Transaction t2= session2.beginTransaction();
		session2.load(Student.class, 777).getName();
		session2.update(student);
		
		t2.commit();
		session2.close();*/
		
		
		
	}
}

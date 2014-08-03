package hibernate;

import java.text.MessageFormat;
import java.util.Formatter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {
	public static SessionFactory sesssionfactory = null;

	static {
		sesssionfactory = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory();

	}

	public void insertEmployee() {
		Session session = null;
		org.hibernate.Transaction trn = null;

		session = sesssionfactory.openSession();
		trn = session.beginTransaction();
		try {
			Employee emp = new Employee();
			emp.setAddress("ss");
			
			emp.setName("Bersabeh");

			session.persist(emp);
			trn.commit();
		} catch (HibernateException e) {
			trn.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();

		}
		
		
	}
	
	public void deleteEmployee(Employee employee){
		Session session = null;
		org.hibernate.Transaction trn = null;

		session = sesssionfactory.openSession();
		trn = session.beginTransaction();
		try {
			
			session.delete(employee);
			trn.commit();
		} catch (HibernateException e) {
			trn.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();

		}
		
	}
	public void updateEmployee(Employee employee){

		Session session = null;
		org.hibernate.Transaction trn = null;
		
		session = sesssionfactory.openSession();
		trn = session.beginTransaction();
		try{
		
		session.update(employee);
		trn.commit();
		}catch(HibernateException e){
			trn.rollback();
			e.printStackTrace();
		}
		finally{
			if(session != null)
			session.close();
			
		}
		
	}
	
	public Employee fetchEmployee(int id){
		Employee employee = null;
		Session session = null;
		org.hibernate.Transaction trn = null;

		session = sesssionfactory.openSession();
		trn = session.beginTransaction();
		try {
			
			employee = (Employee)session.get(Employee.class, id);
			trn.commit();
		} catch (HibernateException e) {
			trn.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();

		}
		return employee;
		
	}
	public static void main(String[] args) {
		Application empApp = new Application();
		empApp.insertEmployee();		
		Employee emp = new Employee();
		emp.setAddress("ss");
		
		emp.setName("NanoYe");
		
		empApp.updateEmployee(emp);
		Employee employee  = empApp.fetchEmployee(1);
		System.out.println(employee);
		empApp.deleteEmployee(emp);
		
		MessageFormat.format("","");
	}
}

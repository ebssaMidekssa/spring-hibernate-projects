package associations.xml;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeApplication {
	private static SessionFactory sessionFactory = new Configuration()
			.configure("associations/xml/hibernate-xml.cfg.xml").buildSessionFactory();

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// Create some instances of Employee.
			Office office1 = new Office(112, "Gateridge");
			Employee employee1 = new Employee("Frank Brown");
			Employee employee2 = new Employee("John doe");
			office1.addEmployee(employee1);
			office1.addEmployee(employee2);
			
			
			Office office2 = new Office(221, "McLaughlin");
			Employee employee3 = new Employee("Jane Doe");
			Employee employee4 = new Employee("Mary Long");
			office2.addEmployee(employee3);
			office2.addEmployee(employee4);
			
			session.persist(office1);
			session.persist(office2);
			
			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

            @SuppressWarnings("unchecked")
			List<Office> officeList = session.createQuery("from Office").list();
            for (Office office : officeList) {
            	System.out.println(office.getBuilding() + " room "+ office.getRoomnumber() +" contains:");
            	
            	for (Employee employee : office.getEmployees()) {
            		System.out.println("#"+employee.getEmployeenumber() + " "+ employee.getName());
            	}
            }

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
}

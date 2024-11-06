package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            /*List<Employee> emps = session.createQuery("from Employee").getResultList();
            Employee emp = session.get(Employee.class,1);
            emp.setSalary(1500);*/

            session.createQuery("update Employee set salary=2000 " + "where name = 'Macs'").executeUpdate();

            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}

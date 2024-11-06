package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Fedor", "Michailovich", "programmer", 1000000);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

            int myId = emp.getId();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class,myId);
            session.getTransaction().commit();
            System.out.println(employee.getName());

        }finally {
            factory.close();
        }
    }
}

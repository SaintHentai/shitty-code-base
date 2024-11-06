package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Macs", "Landivus", "supp2", 1000);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            System.out.println();
            System.out.println(emp);
        }finally {
            factory.close();
        }
    }
}

package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> emps = session.createQuery("from Employee").getResultList();

            for (Employee e: emps) {
                if ("Kostya"==e.getName().intern()){
                    System.out.println(true);
                }else
                    System.out.println(false);
            }

            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}


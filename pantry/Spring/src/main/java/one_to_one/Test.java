package one_to_one;

import one_to_one.entity.Detail;
import one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Nikolay","Ivanov","HR",850);
            Detail detail = new Detail("New-York","7864512","nikolay@mail.com");

            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction();
            session.save(detail);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}

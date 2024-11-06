package uni_one_to_many;

import uni_one_to_many.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Department dep = new Department("Sales",1800,500);
            Employee emp1 = new Employee("Denis","Trefilov",800);
            Employee emp2 = new Employee("Dasha","Sosalkina",1000);

            dep.addEmployeeTiDepartment(emp1);
            dep.addEmployeeTiDepartment(emp2);

            session.beginTransaction();
            session.save(dep);

            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}

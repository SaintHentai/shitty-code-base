package bi_one_to_many;

import bi_one_to_many.entity.*;
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
            /*Department dep = new Department("Sales",2500,300);
            Employee emp1 = new Employee("Oleg","Derepaska",1800);
            Employee emp2 = new Employee("Elena","Smirnova",1000);
            Employee emp3 = new Employee("Denis","Trefilov",500);

            dep.addEmployeeTiDepartment(emp1);
            dep.addEmployeeTiDepartment(emp2);
            dep.addEmployeeTiDepartment(emp3);

            session.beginTransaction();
            session.save(dep);*/

            //***********************************************************************

            session.beginTransaction();
            System.out.println("Get department");
            Department department = session.get(Department.class,4);

            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Loading our employees");
            department.getEmps().get(0);

            session.getTransaction().commit();

            System.out.println("Get employees of the department");
            System.out.println(department.getEmps());
        }finally {
            factory.close();
        }
    }
}

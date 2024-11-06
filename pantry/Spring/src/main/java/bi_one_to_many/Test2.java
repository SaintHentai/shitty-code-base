package bi_one_to_many;
import bi_one_to_many.entity.Employee;
import bi_one_to_many.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            /*Department department = session.get(Department.class,1);
            System.out.println(department);
            System.out.println(department.getEmps());*/

            //********************************************************

            /*Employee employee = session.get(Employee.class,1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
            */

            Employee employee = session.get(Employee.class,4);
            session.delete(employee);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
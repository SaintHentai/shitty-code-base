package DATABASE;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<GlnTable> listG;
    private ArrayList<String> valG = new ArrayList<>();
    private GlnTable glnTable = new GlnTable();

    public Database(){

    }

    private void connectAndRecord() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(GlnTable.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            listG = session.createQuery("from GlnTable order by StrGLN asc").getResultList();
            for (GlnTable g: listG) {
                valG.add(g.getStrGln());
            }
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    public void addToDatabase(String record){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(GlnTable.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            glnTable.setStrGln(record);
            session.save(glnTable);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    public ArrayList<String> getListGlnFromDatabase() {
        connectAndRecord();
        return valG;
    }
}

import DATABASE.GlnTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    private LogicGLN logicGLN;
    private GlnTable glnTable;
    private List<GlnTable> table;
    private ArrayList<String> fromTable = new ArrayList<>();
    private ArrayList<String> randomValues = new ArrayList<>();

    public Test2(){
        logicGLN = new LogicGLN();
    }

    public void connectedRecordDatabase(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(GlnTable.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            table = session.createQuery("from GlnTable order by StrGLN asc").getResultList();
            for (GlnTable g: table) {
                fromTable.add(g.getStrGln());
            }
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    private <T extends Comparable<T>> boolean binaryContains(List<T> list, T key){
        int low = 0;
        int high = list.size() - 1;
        while (low <= high){
            int middle = (low + high)/2;
            int comparison = list.get(middle).compareTo(key);
            if (comparison < 0){
                low = middle + 1;
            }else if (comparison > 0){
                high = middle - 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public void init(){

        for (int i = 0; i < randomValues.size(); i++){
            if (binaryContains(fromTable,randomValues.get(i))){
                System.out.println("yes " + randomValues.get(i));
                randomValues.clear();
                init();
            }else {
                System.out.println("no " + randomValues.get(i));
                glnTable = new GlnTable();
                SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(GlnTable.class)
                        .buildSessionFactory();
                try {
                    Session session = factory.getCurrentSession();
                    session.beginTransaction();
                    glnTable.setStrGln(randomValues.get(i));
                    session.save(glnTable);
                    session.getTransaction().commit();
                }finally {
                    factory.close();
                }
            }
        }
    }

    public static void main(String[] args) {

    }

}

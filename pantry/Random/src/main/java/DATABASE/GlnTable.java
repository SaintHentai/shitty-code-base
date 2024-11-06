package DATABASE;

import javax.persistence.*;

@Entity
@Table(name="glns")
public class GlnTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="IntGLN")
    private long intGln;

    @Column(name="StrGLN")
    private String strGln;

    public GlnTable() {
    }

    public GlnTable(long intGln, String strGln) {
        this.intGln = intGln;
        this.strGln = strGln;
    }

    @Override
    public String toString() {
        return "GlnTable{" +
                "id=" + id +
                ", intGln=" + intGln +
                ", strGln='" + strGln + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIntGln() {
        return intGln;
    }

    public void setIntGln(long intGln) {
        this.intGln = intGln;
    }

    public String getStrGln() {
        return strGln;
    }

    public void setStrGln(String strGln) {
        this.strGln = strGln;
    }
}

import DATABASE.Database;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    private int quantityGln;
    private LogicGLN logicGLN;
    private Database database;

    public Analyzer(int enterGln){
        quantityGln = enterGln;
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

    };

    /*public ArrayList<String> check(){
        logicGLN.createGLN();
        ArrayList<String> end = new ArrayList<>();
        for (int i = 0; i < logicGLN.getGln().size(); i++){
            if (binaryContains(database.getListGlnFromDatabase(),logicGLN.getGln().get(i))){
                System.out.println("yes");
                //check();
            }else {
                System.out.println("no");
                end = logicGLN.getGln();
            }
        }
        return end;
    }*/

}

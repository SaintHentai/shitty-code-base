import DATABASE.Database;

import java.util.List;

public class Test1 {

    static private <T extends Comparable<T>> boolean binaryContains(List<T> list, T key){
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

    public static void main(String[] args) {
        /*LogicGLN logicGLN = new LogicGLN(10);
        logicGLN.createGLN();

        Database database = new Database();

        for (int i = 0; i < logicGLN.getGln().size(); i++ ){
            if (binaryContains(database.getListGlnFromDatabase(),logicGLN.getGln().get(i))){
                System.out.println("yes");
            }else
                System.out.println("no");
        }*/
    }
}

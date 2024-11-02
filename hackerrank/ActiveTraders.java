package hackerrank;

import java.util.*;

public class ActiveTraders {

    public static List<String> calcActive(List<String> customers) {
        // list for storing the answer
        List<String> answer = new ArrayList<>();
        // hasMap to count the no of occurrence of each String
        HashMap<String,Integer> hm = new HashMap<>();
        int sizeTrades = customers.size();

        for(int i = 0 ; i < sizeTrades ; i++) {
            String item = customers.get(i);
            if(hm.containsKey(item)) { // if map already contains the string , then increment its occurrence
                hm.put(item , hm.get(item) + 1);
            }else { // if String is not there , then it is its first occurrence
                hm.put(item, 1);
            }
        }

        //we are use keySet, don't need sort
        for (String ect: hm.keySet()) {
            float value = hm.get(ect);
            float n = (float) sizeTrades;
            float percentage = (value / n) * (float) 100.0;
            if (5.0 <= percentage) answer.add(ect);
        }

        return answer;
    }

    public static void main(String[] args)  {

        Scanner sn = new Scanner(System.in);

        int countCostumers = sn.nextInt();

        List<String> customers = new ArrayList<>();

        for(int i = 0 ; i < countCostumers ; i++)
            customers.add(sn.next());

        List<String> result = calcActive(customers);

        for(int i = 0 ; i < result.size() ; i++)
            System.out.println(result.get(i));
    }

}

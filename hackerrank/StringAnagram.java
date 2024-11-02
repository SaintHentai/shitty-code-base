package hackerrank;

/*
5
heater cold clod reheat dolc
3
codl heatre abcd
*/

import java.util.*;

public class StringAnagram {

    public static List<Integer> getStrAnagram(List<String> dictionary, List<String> query){
        List<Integer> ans = new ArrayList<>();
        HashMap<String,Integer> hm = new HashMap<>();

        for (String ect: dictionary) {
            char[] wordArr = ect.toCharArray();
            Arrays.sort(wordArr);
            String wordDict = Arrays.toString(wordArr);

            if (!hm.containsKey(wordDict)) hm.put(wordDict, 1);
            else hm.put(wordDict, hm.get(wordDict) + 1);
        }

        for (String ect: query) {
            char[] wordArr = ect.toCharArray();
            Arrays.sort(wordArr);
            String wordQuery = Arrays.toString(wordArr);

            if (hm.containsKey(wordQuery)) ans.add(hm.get(wordQuery));
            else ans.add(0);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        List<String> query = new ArrayList<>();
        Scanner sn = new Scanner(System.in);

        int sizeDict = sn.nextInt();
        for (int i = 0; i < sizeDict; i++) dictionary.add(sn.next());

        int sizeQuery = sn.nextInt();
        for (int i = 0; i < sizeQuery; i++) query.add(sn.next());

        List<Integer> result = getStrAnagram(dictionary,query);
        for (int i = 0; i < result.size(); i++) System.out.print(result.get(i) + " ");
    }

}

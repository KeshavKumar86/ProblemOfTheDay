package year2025.january;

import java.util.*;

public class PrintAnagramsTogether {
    public static void main(String[] args) {

        //arr[] = ["act", "god", "cat", "dog", "tac"]
        String[] arr = new String[]{"listen", "silent", "enlist", "abc", "cab", "bac", "rat",
                "tar", "art"};
        System.out.println("Result: " + anagrams(arr));
    }

    private static ArrayList<ArrayList<String>> anagrams(String[] arr) {

        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s : arr) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            ArrayList<String> value;
            if (map.containsKey(key)) {
                value = map.get(key);
                value.add(s);
            } else {
                value = new ArrayList<>();
                value.add(s);
                map.put(key, value);
            }

        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            result.add(map.get(key));
        }
        return result;
    }
}
/*
Solution1: Brute Force Approach

 */
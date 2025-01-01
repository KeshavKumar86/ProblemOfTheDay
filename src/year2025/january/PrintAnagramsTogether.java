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
For every String iterate every other string to check if they are anagrams.
To iterate time required = O(n*n)
to check if two strings are anagrams = o(m) where m is the length of the strings
Overall Time complexity: O(n*n*m)
Space complexity: (n*m) to store result ( n Strings of m lengths each)

Solution2: Optimal Approach
Utilize the fact that Strings are anagram. So sorting of anagrams gives the same string.
for every String, sort the string and use this sorted string as key.
Anagrams will have same key because sort of anagrams will give same string.
so it will create hashmap of hashmap<String,List<String>>.
List<String> will have all the anagrams.
Time Complexity: O(n⋅mlogm)
Space Complexity: O(n⋅m)
 */
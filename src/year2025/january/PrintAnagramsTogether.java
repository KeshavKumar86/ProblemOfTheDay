package year2025.january;

import java.util.*;

public class PrintAnagramsTogether {
    public static void main(String[] args) {

        //arr[] = ["act", "god", "cat", "dog", "tac"]
        String[] arr = new String[]{"listen", "silent", "enlist", "abc", "cab", "bac", "rat",
                "tar", "art"};
        System.out.println("Result: " + anagramsII(arr));
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
    private static ArrayList<ArrayList<String>> anagramsII(String[] arr) {

        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s : arr) {
            String key = uniqueKey(s);
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
    private static String uniqueKey(String s) {

        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c-'a']++;

        }
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {

                key.append((char)(i + 'a'));
                key.append(arr[i]);
            }
        }
        return key.toString();
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

Solution3: Improved Optimal Solution
Intuition: Instead of sorting the string and using sorted string as key we will count the frequency
of each character and generate a unique key like
aab-> a2b1
aba->a2b1
baa->a2b1 so anagrams have same key like sort, but here we can generate the key in O(length of String)
time instead of sort O(mlogm)
after that follow the same code as of above.
Time Complexity: O(n⋅m)
Space Complexity: O(n⋅m)
 */
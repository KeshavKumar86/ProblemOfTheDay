package year2024.november;

public class Anagram {
    public static void main(String[] args) {

        String s1 = "g", s2 = "g";
        System.out.println("Result: " + areAnagrams(s1, s2));
    }

    public static boolean areAnagrams(String s1, String s2) {

        //This will take constant space
        int[] charCount = new int[26];
        //This will take linear O(n) time
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }
        //This will take linear o(m) time
        for (char c : s2.toCharArray()) {
            charCount[c - 'a']--;
        }
        //This will take constant O(1) time
        for (int i : charCount) {
            if (i != 0)
                return false;
        }
        return true;
    }
}

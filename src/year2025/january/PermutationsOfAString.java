package year2025.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfAString {
    public static void main(String[] args) {

        String s = "ABC";
        ArrayList<String> list = findPermutation(s);
        System.out.println(list);
    }
    private static ArrayList<String> findPermutation(String s) {

        List<String> permutations = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // To generate permutations in lexicographical order
        boolean[] used = new boolean[chars.length];

        backtrack(chars, new StringBuilder(), used, permutations);
        return new ArrayList<>(permutations);

    }

    private static void backtrack(char[] chars, StringBuilder current, boolean[] used, List<String> result) {
        // Base case: if the current length matches the input length
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // Skip used characters or duplicates
            if (used[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            // Choose the character
            current.append(chars[i]);
            used[i] = true;

            // Explore further
            backtrack(chars, current, used, result);

            // Undo the choice (backtrack)
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}

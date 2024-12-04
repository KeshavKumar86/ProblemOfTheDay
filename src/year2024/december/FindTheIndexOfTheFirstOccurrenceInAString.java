package year2024.december;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {

        String s1 = "sadbutsad";
        String s2 = "but";
        System.out.println("Result: " + strStr(s1, s2));
    }

    static int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length()) {
            return -1;
        }
        int i, j;
        for (i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = i;
                for (j = 0; j < needle.length(); j++) {
                    if (k >= haystack.length() || haystack.charAt(k) != needle.charAt(j)) {
                        break;
                    }
                    k++;
                }
                if (j == needle.length()) {
                    return i;
                }
                /*if(i+needle.length()<=haystack.length() && haystack.substring(i,i+needle.length()).equals(needle)){
                    return i;
                }*/
            }
        }
        return -1;
    }
}

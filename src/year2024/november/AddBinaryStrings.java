package year2024.november;

public class AddBinaryStrings {
    public static void main(String[] args) {

        String s1 = "00100";
        String s2 = "010";
        System.out.println("Result: " + addBinary(s1, s2));

    }

    private static String addBinary(String s1, String s2) {

        s1 = removeZeros(s1);
        s2 = removeZeros(s2);
        int i = s1.length() - 1, j = s2.length() - 1;
        String carry = "0";
        StringBuilder result = new StringBuilder();
        String expression;

        while (i >= 0 && j >= 0) {
            expression = s1.charAt(i) + String.valueOf(s2.charAt(j)) + carry;
            carry = switch (expression) {
                case "000" -> {
                    result.append('0');
                    yield "0";
                }
                case "001", "010", "100" -> {
                    result.append('1');
                    yield "0";
                }
                case "011", "101", "110" -> {
                    result.append('0');
                    yield "1";
                }
                case "111" -> {
                    result.append('1');
                    yield "1";
                }
                default -> carry;
            };
            i--;
            j--;
        }
        while (i >= 0) {
            if (carry.equals("1") && s1.charAt(i) == '1') {
                result.append('0');
                carry = "1";
            } else if (carry.equals("0") && s1.charAt(i) == '1' || carry.equals("1") && s1.charAt(i) == '0') {
                result.append('1');
                carry = "0";
            } else if (carry.equals("0") && s1.charAt(i) == '0') {
                result.append('0');
                carry = "0";
            }
            i--;
        }
        while (j >= 0) {
            if (carry.equals("1") && s2.charAt(j) == '1') {
                result.append('0');
                carry = "1";
            } else if (carry.equals("0") && s2.charAt(j) == '1' || carry.equals("1") && s2.charAt(j) == '0') {
                result.append('1');
                carry = "0";
            } else if (carry.equals("0") && s2.charAt(j) == '0') {
                result.append('0');
                carry = "0";
            }
            j--;
        }
        if(carry.equals("1"))
            result.append('1');
        return result.reverse().toString();
    }
    static String removeZeros(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                break;
            }
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }
}

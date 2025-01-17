package year2025.january;

import java.util.Arrays;

public class ProductArrayPuzzle {
    public static void main(String[] args) {

        //arr[] = [10, 3, 5, 6, 2]
        int[] arr = new int[]{12, 0, 0};
        System.out.println("Result: " + Arrays.toString(productExceptSelf(arr)));
    }

    private static int[] productExceptSelf(int[] arr) {
        // code here
        int countZero = 0;
        int product = 1;
        int[] result = new int[arr.length];
        int indexZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                product = product * arr[i];
            } else {
                countZero++;
                if (countZero == 1) {
                    indexZero = i;
                }
            }
        }
        if (countZero > 0) {
            if (countZero == 1) {
                result[indexZero] = product;
            }
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            result[i] = product / arr[i];
        }
        return result;
    }
}
/*
Solution1: Brute Force Solution
The idea is simple, for every element arr[i], we compute product of all elements except itself.
To compute the product, we run an inner loop.
Time Complexity: O(n^2)
Space Complexity: O(1)

Solution2: Better Approach
The above approach can be optimized by avoiding the repetitive calculation of products of elements.
The idea is to precompute the prefix and suffix products and store them in two arrays.
Now we can find the product of array except i-th element, by using these precomputed arrays in
constant time.
product of array except i-th element = prefProduct[i] * suffProduct[i]
prefProduct[i] stores product of all elements before i-th index in the array.
suffProduct[i] stores product of all elements after i-th index in the array.
Time Complexity: O(n)
Space Complexity: O(n)

Solution3: Optimal Solution
Intuition: Instead of calculating product again and again, first calculate the total product and for
every index divide that element to calculate the product of other elements.
Special Case: 1.when array contain 1 zero than product for that 0'th index will be product of all other
elements and for other indexes product will be zero.
2.if there are more than 1 zero that product for all will be zero.
 */
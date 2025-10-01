import java.util.*;

public class NumbersWithKOnes {

    // Main function to test
    public static void main(String[] args) {
        int n = 4;  // number of bits
        int k = 2;  // number of 1's
        List<Integer> result = new ArrayList<>();
        generateCombinations(0,n, k,0,result);
        System.out.println(result);
    }

    
    static void generateCombinations(int start, int n, int k, int currentNumber, List<Integer> result) {
        // Base case: if we've chosen k bits
        if (k == 0) {
            result.add(currentNumber);
            return;
        }

        // No more bits to choose from
        if (start >= n) return;

        for (int i = start; i < n; i++) {
            // set bit i
            int newNumber = currentNumber | (1 << i);
            // choose next bits from i+1
            generateCombinations(i + 1, n, k - 1, newNumber, result);
        }
    }
}

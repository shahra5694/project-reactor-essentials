package practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ElementPairToFindSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, -2, 6, 8, 3, 3};
        int targetSum = 6;

        // Call the pairedElements function
        pairedElements(arr, targetSum);
//        printPairs(arr, arr.length, targetSum);
    }

    public static void pairedElements(int[] arr, int targetSum) {
        // sort the array
        Arrays.sort(arr);
        // Initialize pointers

        int low = 0;
        int high = arr.length - 1;

        // Map to track unique pairs
        Map<Integer, Boolean> uniquePairs = new HashMap<>();

        // Iterate with two pointers
        while (low < high) {
            // Check if sum equals the target
            if (arr[low] + arr[high] == targetSum) {
                // Print pair if elements are not already in the map
                if (!uniquePairs.containsKey(arr[low]) || !uniquePairs.containsKey(arr[high])) {
                    System.out.println("The pair is : (" + arr[low] + ", " + arr[high] + ")");
                    uniquePairs.put(arr[low], true);
                    uniquePairs.put(arr[high], true);
                }
                low++;
                high--;
            } else if (arr[low] + arr[high] > targetSum) {
                high--;
            }
            else {
                low++;
            }
        }
    }

    static void printPairs(int arr[], int n, int sum)
    {
        // int count = 0;

        // Consider all possible pairs
        // and check their sums
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] + arr[j] == sum)
                    System.out.println("(" + arr[i] + ", "
                            + arr[j] + ")");
    }

}


package rental.assignment_problems;

import java.util.Scanner;

public class PlacementCutoff {

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    static int quickSelect(int[] arr, int low, int high, int target) {

        if (low == high) {
            return arr[low];
        }

        int pivotIndex = partition(arr, low, high);

        if (pivotIndex == target) {
            return arr[pivotIndex];
        } else if (target < pivotIndex) {
            return quickSelect(arr, low, pivotIndex - 1, target);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, target);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of placement scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter placement scores:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter k (kth highest): ");
        int k = sc.nextInt();

        if (k < 1 || k > n) {
            System.out.println("Invalid value of k.");
        } else {
            // kth highest corresponds to index n-k
            // when the array is arranged in ascending order.
            int target = n - k;

            int result = quickSelect(scores, 0, n - 1, target);

            System.out.println(k + "th Highest Score: " + result);
        }

        sc.close();
    }
}

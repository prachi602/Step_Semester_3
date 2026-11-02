
package rental.assignment_problems;

import java.util.Scanner;

public class AttendanceDisorderScore {

    static long mergeSort(int[] arr, int left, int right) {

        long count = 0;

        if (left < right) {

            int mid = left + (right - left) / 2;

            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);

            count += merge(arr, left, mid, right);
        }

        return count;
    }

    static long merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        long count = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                // All remaining elements in the left half
                // are greater than arr[j - 1].
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of attendance records: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter attendance values:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long result = mergeSort(arr, 0, n - 1);

        System.out.println("Inversion Count: " + result);

        sc.close();
    }
}

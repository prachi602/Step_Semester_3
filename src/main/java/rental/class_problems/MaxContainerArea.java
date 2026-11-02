package rental.class_problems;

public class MaxContainerArea {

    // Approach 1: Brute Force
    public static int maxAreaBruteForce(int[] heights) {

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            for (int j = i + 1; j < heights.length; j++) {

                int height = Math.min(heights[i], heights[j]);
                int width = j - i;

                int area = height * width;

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    // Approach 2: Two Pointers
    public static int maxContainerArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {

            int height = Math.min(heights[left], heights[right]);
            int width = right - left;

            int area = height * width;

            if (area > maxArea) {
                maxArea = area;
            }

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("Brute Force: "
                + maxAreaBruteForce(heights));

        System.out.println("Two Pointers: "
                + maxContainerArea(heights));
    }
}
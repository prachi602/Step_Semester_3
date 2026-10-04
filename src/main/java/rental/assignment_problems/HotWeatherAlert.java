package rental.assignment_problems;

public class HotWeatherAlert {

    public static int countAlerts(int[] readings, int k, int threshold) {

        int sum = 0;

        // Calculate the sum of the first k readings
        for (int i = 0; i < k; i++) {
            sum += readings[i];
        }

        int alertCount = 0;

        // Check the first window
        if (sum >= k * threshold) {
            alertCount++;
        }

        // Slide the window
        for (int i = k; i < readings.length; i++) {
            sum += readings[i];
            sum -= readings[i - k];

            if (sum >= k * threshold) {
                alertCount++;
            }
        }

        return alertCount;
    }

    public static void main(String[] args) {

        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        System.out.println("Number of Alerts: "
                + countAlerts(readings, k, threshold));
    }
}
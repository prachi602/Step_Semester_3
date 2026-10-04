package rental.assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class MostPopular {

    public static String mostPopular(String[] orders) {

        Map<String, Integer> countMap = new HashMap<>();

        // Count each item
        for (String order : orders) {
            countMap.put(order, countMap.getOrDefault(order, 0) + 1);
        }

        // Find the first item with the highest count
        String bestItem = orders[0];
        int bestCount = countMap.get(bestItem);

        for (String order : orders) {
            int count = countMap.get(order);

            if (count > bestCount) {
                bestItem = order;
                bestCount = count;
            }
        }

        return "(\"" + bestItem + "\", " + bestCount + ")";
    }

    public static void main(String[] args) {

        String[] orders1 = {
                "dosa", "idli", "vada", "dosa",
                "idli", "dosa", "tea"
        };

        System.out.println(mostPopular(orders1));

        String[] orders2 = {
                "tea", "coffee", "coffee", "tea"
        };

        System.out.println(mostPopular(orders2));
    }
}
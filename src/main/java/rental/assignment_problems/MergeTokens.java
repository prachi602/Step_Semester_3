package rental.assignment_problems;

public class MergeTokens {

    public static int[] mergeTokens(int[] counterA, int[] counterB) {

        int[] result = new int[counterA.length + counterB.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < counterA.length && j < counterB.length) {

            if (counterA[i] <= counterB[j]) {
                result[k] = counterA[i];
                i++;
            } else {
                result[k] = counterB[j];
                j++;
            }

            k++;
        }

        while (i < counterA.length) {
            result[k] = counterA[i];
            i++;
            k++;
        }

        while (j < counterB.length) {
            result[k] = counterB[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] counterA = {3, 8, 15, 20};
        int[] counterB = {5, 8, 12};

        int[] result = mergeTokens(counterA, counterB);

        System.out.print("Merged Tokens: ");

        for (int token : result) {
            System.out.print(token + " ");
        }
    }
}
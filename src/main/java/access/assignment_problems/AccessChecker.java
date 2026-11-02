package access.assignment_problems;

public class AccessChecker {

    static String classifyAccess(
            String fieldModifier,
            String accessorContext) {

        switch (fieldModifier) {

            case "private":
                if (accessorContext.equals("SAME_CLASS")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "default":
                if (accessorContext.equals("SAME_CLASS") ||
                        accessorContext.equals("SAME_PACKAGE")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "protected":
                if (accessorContext.equals("SAME_CLASS") ||
                        accessorContext.equals("SAME_PACKAGE") ||
                        accessorContext.equals(
                                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "public":
                return "ALLOWED";

            default:
                return "DENIED";
        }
    }

    static String summarizeByModifier(String[][] attempts) {

        String[] modifiers = {
                "private",
                "default",
                "protected",
                "public"
        };

        int[] allowed = new int[4];
        int[] denied = new int[4];

        for (String[] attempt : attempts) {

            if (attempt == null || attempt.length < 2) {
                continue;
            }

            String modifier = attempt[0];
            String context = attempt[1];

            String result =
                    classifyAccess(modifier, context);

            for (int i = 0; i < modifiers.length; i++) {

                if (modifier.equals(modifiers[i])) {

                    if (result.equals("ALLOWED")) {
                        allowed[i]++;
                    } else {
                        denied[i]++;
                    }

                    break;
                }
            }
        }
        return "private: " + allowed[0] + " allowed / "
                + denied[0] + " denied | "
                + "default: " + allowed[1] + " allowed / "
                + denied[1] + " denied | "
                + "protected: " + allowed[2] + " allowed / "
                + denied[2] + " denied | "
                + "public: " + allowed[3] + " allowed / "
                + denied[3] + " denied";
    }

    static String firstDeniedAttempt(String[][] attempts) {

        if (attempts == null) {
            return "None Denied";
        }

        for (int i = 0; i < attempts.length; i++) {

            if (attempts[i] == null || attempts[i].length < 2) {
                continue;
            }

            String modifier = attempts[i][0];
            String context = attempts[i][1];

            String result =
                    classifyAccess(modifier, context);

            if (result.equals("DENIED")) {

                return modifier
                        + " via "
                        + context
                        + " (attempt #"
                        + (i + 1)
                        + ")";
            }
        }

        return "None Denied";
    }

    public static void main(String[] args) {
        String[][] attempts3 = {
                {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(
                firstDeniedAttempt(attempts3)
        );


    }
}

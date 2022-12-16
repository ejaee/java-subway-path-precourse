package subway.utils.parser;

public class EmptyChecker {
    private EmptyChecker() {
    }

    public static void check(final String input) {
        if (isEmptyOrNull(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEmptyOrNull(String str) {
        return str == null || str.isEmpty();
    }
}

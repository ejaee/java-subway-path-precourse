package subway.utils.parser;

import java.util.List;

public class ContainedChecker {
    public static boolean isValidateCommand(String input, List<String> commands) {

        for (String command : commands) {
            if (input.equals(command)) {
                return true;
            }
        }
        return false;
    }
}

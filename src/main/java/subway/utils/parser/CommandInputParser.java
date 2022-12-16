package subway.utils.parser;

import java.util.Arrays;
import java.util.List;
import subway.utils.Constants;

public class CommandInputParser {



    private CommandInputParser() {
    }

    public static String parseMainInput(final String input) {
        List<String> commands = Arrays.asList(Constants.MAIN_STANDARD_START, Constants.MAIN_STANDARD_EXIT);

        return parseWithEmptyCheck(input, commands);
    }

    public static String parsePathInput(final String input) {
        List<String> commands = Arrays.asList
                (Constants.PATH_STANDARD_DISTANCE, Constants.PATH_STANDARD_TIME, Constants.PATH_STANDARD_BACK);

        return parseWithEmptyCheck(input, commands);
    }

    private static String parseWithEmptyCheck(final String input, final List<String> commands) {
        EmptyChecker.check(input);


        return parse(input, commands);
    }

    private static String parse(final String input, List<String> commands) {

        if (!ContainedChecker.isValidateCommand(input, commands)) {
            throw new IllegalArgumentException();
        }
        return input;
    }


}

package subway.utils.parser;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Constants;

public class StationInputParser {
    private StationInputParser() {
    }

    public static Station parseStationInput(final String input) {

        return parseWithEmptyCheck(input);
    }

    private static Station parseWithEmptyCheck(final String input) {
        EmptyChecker.check(input);

    return parse(input);
    }

    private static Station parse(final String input) {

        return StationRepository.getStation(input);
    }
}

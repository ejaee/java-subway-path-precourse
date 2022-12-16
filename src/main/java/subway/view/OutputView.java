package subway.view;

import subway.domain.Station;
import subway.domain.path.Path;

public class OutputView {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String STANDARD_PREFIX = "[INFO] ";
    public static final String OUTPUT_BLANK = "---";
    public static final String FULL_DISTANCE = "총 거리: %dkm";
    public static final String FULL_TIME = "총 소요 시간: %d분";

    public void printErrorMessage(Exception e) {
        print(ERROR_PREFIX + e.getMessage());
    }

    public void printResult(Path stationList) {
        print(STANDARD_PREFIX + OUTPUT_BLANK);
        printData(stationList);
        print(STANDARD_PREFIX + OUTPUT_BLANK);
        printStations(stationList);
    }

    private void printData(Path stationList) {
        print(String.format(FULL_DISTANCE, stationList.getFullDistance()));
        print(String.format(FULL_TIME, stationList.getFullTime()));
    }

    private void printStations(Path stationList) {
        for (Station station : stationList.getPath()) {
            print(STANDARD_PREFIX + station);
        }
    }

    private void print(String message) {
        System.out.println(message);
    }
}

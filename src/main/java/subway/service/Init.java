package subway.service;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.path.DistanceGraphRepository;
import subway.domain.path.TimeGraphRepository;
import subway.utils.Constants;

public class Init {

    public static void initiate() {
        setStationRepository();
        setLineRepository();
        setDistanceSectionRepository();
        setTimeSectionRepository();
    }

    private static void setStationRepository() {
        List<String> stationList = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");

        for (String station : stationList) {
            StationRepository.addStation(new Station(station));
        }
        DistanceGraphRepository.addAllStation();
        TimeGraphRepository.addAllStation();
    }

    private static void setLineRepository() {
        List<String> lineList = Arrays.asList("2호선", "3호선", "신분당선");

        for (String line : lineList) {
            LineRepository.addLine(new Line(line));
        }
    }
    private static void setDistanceSectionRepository() {

        for (List<String> section : Constants.DISTANCE_SECTION_LIST) {
            DistanceGraphRepository.setUpSection(
                StationRepository.getStation(section.get(0)),
                StationRepository.getStation(section.get(1)),
                Integer.parseInt(section.get(2))
            );
        }

    }

    private static void setTimeSectionRepository() {


        for (List<String> section : Constants.TIME_SECTION_LIST) {
            TimeGraphRepository.setUpSection(
                StationRepository.getStation(section.get(0)),
                StationRepository.getStation(section.get(1)),
                Integer.parseInt(section.get(2))
            );
        }
    }

}

package subway.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final List<List<String>> DISTANCE_SECTION_LIST = Arrays.asList(
        Arrays.asList("교대역", "강남역", "2"),
        Arrays.asList("강남역", "역삼역", "2"),
        Arrays.asList("교대역", "남부터미널역", "3"),
        Arrays.asList("남부터미널역", "양재역", "6"),
        Arrays.asList("양재역", "매봉역", "1"),
        Arrays.asList("강남역", "양재역", "2"),
        Arrays.asList("양재역", "양재시민의숲역", "10")
    );

    public static final List<List<String>> TIME_SECTION_LIST = Arrays.asList(
        Arrays.asList("교대역", "강남역", "3"),
        Arrays.asList("강남역", "역삼역", "3"),
        Arrays.asList("교대역", "남부터미널역", "2"),
        Arrays.asList("남부터미널역", "양재역", "5"),
        Arrays.asList("양재역", "매봉역", "1"),
        Arrays.asList("강남역", "양재역", "8"),
        Arrays.asList("양재역", "양재시민의숲역", "3")
    );

    public static final String MAIN_INPUT_MESSAGE = "## 메인 화면\n"
        + "1. 경로 조회\n"
        + "Q. 종료\n"
        + "\n"
        + "## 원하는 기능을 선택하세요.";

    public static final String PATH_INPUT_MESSAGE = "## 경로 기준\n"
        + "1. 최단 거리\n"
        + "2. 최소 시간\n"
        + "B. 돌아가기\n"
        + "\n"
        + "## 원하는 기능을 선택하세요.";

    public static final String START_STATION_INPUT_MESSAGE = "## 출발역을 입력하세요.\n";
    public static final String END_STATION_INPUT_MESSAGE = "## 도착역을 입력하세요.\n";

    public static final String MAIN_STANDARD_START = "1";
    public static final String MAIN_STANDARD_EXIT = "Q";

    public static final String PATH_STANDARD_DISTANCE = "1";
    public static final String PATH_STANDARD_TIME = "2";
    public static final String PATH_STANDARD_BACK = "B";

}

package subway.controller;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import subway.domain.Station;
import subway.domain.path.DistanceGraphRepository;
import subway.domain.path.Path;
import subway.domain.path.ShortestPathFunction;
import subway.domain.path.TimeGraphRepository;
import subway.service.Init;
import subway.service.InputViewService;
import subway.utils.Constants;
import subway.view.OutputView;

public class SubwayController {

    private final InputViewService inputViewService;
    private final OutputView outputView;

    public SubwayController(Scanner scanner) {
        this.inputViewService = new InputViewService(scanner);
        this.outputView = new OutputView();

        run();
    }

    public void run() {
        boolean flag = true;

        Init.initiate();
        mainInput();
        pathInput(flag);
        if (!flag) {
            return ;
        }
        run();
    }

    private void mainInput() {

        String inputCommand = inputViewService.getMainInput();

        if (inputCommand.equals(Constants.MAIN_STANDARD_EXIT)) {
            System.exit(0);
        }
    }

    private void pathInput(boolean flag) {
        String inputCommand = inputViewService.getPathInput();

        if (inputCommand.equals(Constants.PATH_STANDARD_BACK)) {
            run();
            flag = false;
        }
        Station startStation = inputViewService.getStartStation();
        Station endStation = inputViewService.getEndStation();

        if (Objects.equals(startStation.toString(), endStation.toString())) {
            System.out.println("[ERROR] 출발역과 도착역이 동일합니다.");
            pathInput(flag);
            return ;
        }
        shortestPathFunction(inputCommand, startStation, endStation);
    }

    private void shortestPathFunction(String inputCommand, Station startStation, Station endStation) {

        Path path = null;

        if (Objects.equals(inputCommand, Constants.PATH_STANDARD_DISTANCE)) {
            path = Path.from(distanceShortestFunction(startStation, endStation));
        }
        if (Objects.equals(inputCommand, Constants.PATH_STANDARD_TIME)) {
            path = Path.from(timeShortestFunction(startStation, endStation));
        }

        calculateOutputData(path);
    }

    private List<Station> distanceShortestFunction(Station startStation, Station endStation) {

        return ShortestPathFunction.getPathList(DistanceGraphRepository.distanceGraph(), startStation, endStation);
    }

    private List<Station> timeShortestFunction(Station startStation, Station endStation) {

        return ShortestPathFunction.getPathList(TimeGraphRepository.timeGraph(), startStation, endStation);
    }

    private void calculateOutputData(Path path) {

        outputView.printResult(path);
    }

}

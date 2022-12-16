package subway.service;

import java.util.Scanner;
import subway.domain.Station;
import subway.utils.Constants;
import subway.utils.parser.CommandInputParser;
import subway.utils.parser.StationInputParser;
import subway.view.InputView;

public class InputViewService {

    private final InputView inputView;

    public InputViewService(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public String getMainInput() {
        try {
            return CommandInputParser.parseMainInput(inputView.scanFor(Constants.MAIN_INPUT_MESSAGE));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMainInput();
        }
    }

    public String getPathInput() {
        try {
            return CommandInputParser.parsePathInput(inputView.scanFor(Constants.PATH_INPUT_MESSAGE));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPathInput();
        }
    }

    public Station getStartStation() {
        try {
            return StationInputParser.parseStationInput(inputView.scanFor(Constants.START_STATION_INPUT_MESSAGE));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getStartStation();
        }
    }

    public Station getEndStation() {
        try {
            return StationInputParser.parseStationInput(inputView.scanFor(Constants.END_STATION_INPUT_MESSAGE));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getEndStation();
        }
    }

}

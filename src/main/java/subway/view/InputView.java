package subway.view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String scanFor(String message) {
        System.out.println(message);

        return scan();
    }

    private String scan() {
        return scanner.nextLine();
    }

}

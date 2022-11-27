package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import static pairmatching.validator.CommandValidator.validateInvalidType;

public class InputView {

    public static String readFeatureNumber() {
        OutputView.printStartMessage();
        OutputView.printFeatureList();
        String input = Console.readLine();

        validateInvalidType(input);
        return input;
    }

    public static String readMatchingCourseAndMission() {
        OutputView.printCourseAndMission();
        OutputView.printChooseMessage();

        return Console.readLine();
    }
}

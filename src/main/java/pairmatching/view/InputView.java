package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import static pairmatching.validator.CommandValidator.validateInvalidType;

public class InputView {

    public static String readFunctionNumber() {
        OutputView.printStartMessage();
        OutputView.printFeatureList();
        String input = Console.readLine();

        validateInvalidType(input);
        return input;
    }
}

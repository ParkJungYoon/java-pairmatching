package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import static pairmatching.validator.CommandValidator.validateInvalidMenuCommand;

public class PairMatchingController {

    private String initMenuCommand() {
        String command;
        try {
            command = InputView.readMenuCommand();
            validateInvalidMenuCommand(command);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initMenuCommand();
        }
        return command;
    }
}

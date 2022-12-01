package pairmatching.controller;

import pairmatching.view.InputView;

import static pairmatching.validator.CommandValidator.validateInvalidMenuCommand;

public class PairMatchingController {

    private String initMenuCommand() {
        String command = InputView.readMenuCommand();

        validateInvalidMenuCommand(command);
        return command;
    }
}

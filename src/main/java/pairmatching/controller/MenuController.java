package pairmatching.controller;

import pairmatching.domain.PairMatchingResult;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import static pairmatching.validator.CommandValidator.validateInvalidMenuCommand;

public class MenuController {
    private static final PairMatchingController pairMatchingController = new PairMatchingController();

    public void selectMenu() {
        PairMatchingResult pairMatchingResult = new PairMatchingResult();

        String menu = initMenuCommand();
        if (menu.equals("1")) {
//            startPairMatching(pairMatchingResult, );
        }
    }

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

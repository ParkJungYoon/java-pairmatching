package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import static pairmatching.validator.CommandValidator.validateInvalidMenuCommand;

public class MenuController {
    private static final String PAIR_MATCHING = "1";
    private static final String PAIR_LOOKUP = "2";
    private static final String INITIALIZATION = "3";
    private static final String QUIT = "Q";
    private static final PairMatchingController pairMatchingController = new PairMatchingController();

    public void selectMenu() {
        String menu = initMenuCommand();
        if (menu.equals(PAIR_MATCHING)) {
            pairMatchingController.startPairMatching();
        }
        if (menu.equals(PAIR_LOOKUP)) {
            pairMatchingController.startPairLookUp();
        }
        if (menu.equals(INITIALIZATION)) {
            pairMatchingController.startInitialization();
        }
        if (menu.equals(QUIT)) {
            return;
        }
        selectMenu();
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

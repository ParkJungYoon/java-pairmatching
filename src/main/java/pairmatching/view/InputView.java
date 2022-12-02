package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readMenuCommand() {
        OutputView.printSelectFeatureMessage();
        OutputView.printFeatureList();

        return Console.readLine();
    }

    public static String readCourseLevelMission() {
        OutputView.printCourseLevelMission();
        return Console.readLine();
    }

    public static String readRematching() {
        OutputView.printRematchingMessage();
        return Console.readLine();
    }
}

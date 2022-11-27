package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

import static pairmatching.view.InputView.readMatchingCourseAndMission;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
//        readMatchingCourseAndMission();
//        validateInvalidCourse("유유");
        PairMatchingController pairMatchingController = new PairMatchingController();
        pairMatchingController.matchingStart();
    }
}

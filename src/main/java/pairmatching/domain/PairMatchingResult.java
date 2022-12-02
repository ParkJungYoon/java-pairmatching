package pairmatching.domain;

import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchingResult {
    private static final Map<String, List<Pair>> frontEndResult = new HashMap<>();
    private static final Map<String, List<Pair>> backEndResult = new HashMap<>();

    public static boolean hasMatchingResult(Course course, String missionName) {
        if (course == Course.FRONTEND && frontEndResult.containsKey(missionName)) return true;
        if (course == Course.BACKEND && backEndResult.containsKey(missionName)) return true;
        return false;
    }

    public static void savePairMatchingResult(Course course, String missionName, List<Pair> pairMatchingResult) {
        if (course == Course.FRONTEND) frontEndResult.put(missionName, pairMatchingResult);
        if (course == Course.BACKEND) backEndResult.put(missionName, pairMatchingResult);
    }

    public static void printPairMatching(Course course, String missionName) {
        List<Pair> pairResult = new ArrayList<>();
        if (course == Course.FRONTEND) pairResult = frontEndResult.get(missionName);
        if (course == Course.BACKEND) pairResult = backEndResult.get(missionName);

        OutputView.printPairMatchingResult(pairResult);
    }

    public static void initialization() {
        frontEndResult.clear();
        backEndResult.clear();
    }
}

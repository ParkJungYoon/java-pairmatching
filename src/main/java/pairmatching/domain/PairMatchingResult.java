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

    public static void initialization() {
        frontEndResult.clear();
        backEndResult.clear();
    }

    public static List<Pair> getPairByCourseMission(Course course, String missionName) {
        if (course == Course.FRONTEND) return frontEndResult.get(missionName);
        return  backEndResult.get(missionName);
    }

//    private static void validateDuplicatePairMatching(Course course, String missionName) {
//        if (course == Course.FRONTEND) {
//            List<String> sameLevelMissions = Level.getMissionAtTheSameLevel(missionName);
//            for (String mission : sameLevelMissions) {
//                if (frontEndResult.containsKey(mission)) {
//                    List<Pair> oneResult = frontEndResult.get(mission);
//                }
//            }
//        }
//        if (course == Course.BACKEND) {
//            backEndResult.get(missionName);
//        }
//    }
}

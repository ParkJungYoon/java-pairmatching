package pairmatching.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchingResult {
    private final Map<String, List<Pair>> frontEndResult = new HashMap<>();
    private final Map<String, List<Pair>> backEndResult = new HashMap<>();

    public boolean hasMatchingResult(Course course, String missionName) {
        if (course == Course.FRONTEND && frontEndResult.containsKey(missionName)) return true;
        if (course == Course.BACKEND && backEndResult.containsKey(missionName)) return true;
        return false;
    }

    public void savePairMatchingResult(Course course, String missionName, List<Pair> pairMatchingResult) {
        if (course == Course.FRONTEND) frontEndResult.put(missionName, pairMatchingResult);
        if (course == Course.BACKEND) backEndResult.put(missionName, pairMatchingResult);
    }
}

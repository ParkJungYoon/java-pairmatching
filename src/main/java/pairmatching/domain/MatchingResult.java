package pairmatching.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingResult {
    private Course course;
    // 미션, 페어 매칭 결과
    private Map<String, List<Crews>> level1Matching = new HashMap<>();

    public void saveLevel1MatchingResult(String mission, List<Crews> pair) {
        // 레벨1의 미션마다 매칭 결과
        // 이미 해당 미션에 대한 매칭 결과가 존재할 경우
//        for(String i : level1Matching.keySet()){ //저장된 key값 확인
//            if (i.equals(mission))
//        }
        level1Matching.put(mission, pair);
    }
}

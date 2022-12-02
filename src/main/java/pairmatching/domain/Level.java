package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니","결제","지하철노선도")),
    LEVEL3("레벨3", Arrays.asList("")),
    LEVEL4("레벨4", Arrays.asList("성능개선","배포")),
    LEVEL5("레벨5", Arrays.asList(""));

    private final String name;
    private final List<String> missionName;

    Level(String name, List<String> missionName) {
        this.name = name;
        this.missionName = missionName;
    }

    // 추가 기능 구현
    public String getName() {
        return this.name;
    }

    public List<String> getMissionName() {
        return this.missionName;
    }
}
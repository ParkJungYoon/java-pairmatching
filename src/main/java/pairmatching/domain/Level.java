package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1", "자동차경주 | 로또 | 숫자야구게임"),
    LEVEL2("레벨2", "장바구니 | 결제 | 지하철노선도"),
    LEVEL3("레벨3", ""),
    LEVEL4("레벨4", "성능개선 | 배포"),
    LEVEL5("레벨5", "");

    private final String name;
    private final String mission;

    Level(String name, String mission) {
        this.name = name;
        this.mission = mission;
    }

    public String getName() {
        return name;
    }

    public String getMission() {
        return mission;
    }

    public static Level findContainLevel(String name) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(name))
                .findAny()
                .orElse(null);
    }
}
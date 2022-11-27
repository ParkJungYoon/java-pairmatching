package pairmatching.view;

public class OutputView {
    private final static String PAIR_MATCHING_START_MESSAGE = "기능을 선택하세요.";
    private final static String FEATURE_ONE = "1. 페어 매칭";
    private final static String FEATURE_TWO = "2. 페어 조회";
    private final static String FEATURE_THREE = "3. 페어 초기화";
    private final static String FEATURE_FOUR = "Q. 종료";

    public static void printStartMessage() {
        System.out.println(PAIR_MATCHING_START_MESSAGE);
    }
    public static void printFeatureList() {
        System.out.println(FEATURE_ONE);
        System.out.println(FEATURE_TWO);
        System.out.println(FEATURE_THREE);
        System.out.println(FEATURE_FOUR);
    }
}

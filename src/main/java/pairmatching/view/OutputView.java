package pairmatching.view;

public class OutputView {
    private static final String SELECT_FEATURES_MESSAGE = "기능을 선택하세요.";
    private static final String PAIR_MATCHING_FEATURE = "1. 페어 매칭";
    private static final String PAIR_LOOKUP_FEATURE = "2. 페어 조회";
    private static final String PAIR_INITIALIZATION_FEATURE = "3. 페어 초기화";
    private static final String END_OF_PAIR_MATCHING = "Q. 종료";

    public static void printSelectFeatureMessage() {
        System.out.println(SELECT_FEATURES_MESSAGE);
    }

    public static void printFeatureList() {
        System.out.println(PAIR_MATCHING_FEATURE);
        System.out.println(PAIR_LOOKUP_FEATURE);
        System.out.println(PAIR_INITIALIZATION_FEATURE);
        System.out.println(END_OF_PAIR_MATCHING);
    }

    public static void printErrorMessage(String error) {
        System.out.println(error);
    }
}

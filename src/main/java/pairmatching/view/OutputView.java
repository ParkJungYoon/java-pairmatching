package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private final static String PAIR_MATCHING_START_MESSAGE = "기능을 선택하세요.";
    private final static String FEATURE_ONE = "1. 페어 매칭";
    private final static String FEATURE_TWO = "2. 페어 조회";
    private final static String FEATURE_THREE = "3. 페어 초기화";
    private final static String FEATURE_FOUR = "Q. 종료";
    private final static String COURSE_LIST = "과정: ";
    private final static String MISSION_LIST = "미션: ";
    private final static String MISSION_LEVEL_LIST = "  - %s: ";
    private final static String DIVIDING_LINE = "#############################################";
    private final static String CHOOSE_MESSAGE = "과정, 레벨, 미션을 선택하세요.";

    public static void printStartMessage() {
        System.out.println(PAIR_MATCHING_START_MESSAGE);
    }

    public static void printFeatureList() {
        System.out.println(FEATURE_ONE);
        System.out.println(FEATURE_TWO);
        System.out.println(FEATURE_THREE);
        System.out.println(FEATURE_FOUR);
    }

    private static void printCourse() {
        StringJoiner sj = new StringJoiner(" | ");
        for (Course courseName : Course.values()) {
            sj.add(courseName.getName());
        }
        System.out.println(COURSE_LIST + sj.toString());
    }

    private static void printMission() {
        System.out.println(MISSION_LIST);
        for (Level levelName : Level.values()) {
            System.out.printf(MISSION_LEVEL_LIST, levelName.getName());
            System.out.println(levelName.getMission());
        }
    }

    public static void printCourseAndMission() {
        System.out.println(DIVIDING_LINE);
        printCourse();
        printMission();
        System.out.println(DIVIDING_LINE);
    }

    public static void printChooseMessage() {
        System.out.println(CHOOSE_MESSAGE);
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printPairMatchingResult(List<List<Crew>> pair) {
        System.out.println("페어 매칭 결과입니다.");
        StringJoiner sj;
        for (List<Crew> onePair : pair) {
            sj = new StringJoiner(" : ");
            for (Crew one : onePair) {
                sj.add(one.toString());
            }
            System.out.println(sj.toString());
        }
    }
}

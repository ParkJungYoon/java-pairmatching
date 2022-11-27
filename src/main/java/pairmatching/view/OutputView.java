package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.StringJoiner;

public class OutputView {
    private final static String PAIR_MATCHING_START_MESSAGE = "기능을 선택하세요.";
    private final static String FEATURE_ONE = "1. 페어 매칭";
    private final static String FEATURE_TWO = "2. 페어 조회";
    private final static String FEATURE_THREE = "3. 페어 초기화";
    private final static String FEATURE_FOUR = "Q. 종료";
    private final static String COURSE_LIST = "과정: ";
    private final static String MISSION_LIST = "미션: ";
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

    private static void printMisson() {
        StringJoiner sj = new StringJoiner(" | ");

        System.out.println(MISSION_LIST);
//        System.out.println(COURSE_LIST + sj.toString());
    }

    public static void printCourseAndMisson() {
        System.out.println(DIVIDING_LINE);
        printCourse();
        printMisson();
        System.out.println(DIVIDING_LINE);
    }

    public static void printChooseMessage() {
        System.out.println(CHOOSE_MESSAGE);
    }
}

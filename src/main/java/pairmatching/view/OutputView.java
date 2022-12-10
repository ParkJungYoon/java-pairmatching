package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatchingResult;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String SELECT_FEATURES_MESSAGE = "기능을 선택하세요.";
    private static final String PAIR_MATCHING_FEATURE = "1. 페어 매칭";
    private static final String PAIR_LOOKUP_FEATURE = "2. 페어 조회";
    private static final String PAIR_INITIALIZATION_FEATURE = "3. 페어 초기화";
    private static final String END_OF_PAIR_MATCHING = "Q. 종료";
    private static final String DIVIDING_LINE = "#############################################";
    private static final String COURSE = "과정: ";
    private static final String MISSION = "미션:";
    private static final String MISSION_FORMAT = "  - %s: %s";
    private static final String SELECT_COURSE_LEVEL_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
    private static final String SELECT_COURSE_LEVEL_MISSION_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String SELECT_REMATCHING_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    private static final String NOTHING_TO_LOOK_UP_MESSAGE = "[ERROR] 조회할 매칭 내역이 없습니다.";
    private static final String YES_OR_NO = "네 | 아니오";
    private static final String INITIALIZATION_MESSAGE = "초기화 되었습니다.";


    public static void printSelectFeatureMessage() {
        System.out.println(SELECT_FEATURES_MESSAGE);
    }

    public static void printFeatureList() {
        System.out.println(PAIR_MATCHING_FEATURE);
        System.out.println(PAIR_LOOKUP_FEATURE);
        System.out.println(PAIR_INITIALIZATION_FEATURE);
        System.out.println(END_OF_PAIR_MATCHING);
    }

    public static void printCourseLevelMission() {
        System.out.println(DIVIDING_LINE);
        printCourse();
        printMission();
        System.out.println(DIVIDING_LINE);
        printSelectCourseLevelMissionMessage();
    }

    private static void printCourse() {
        StringJoiner sj = new StringJoiner(" | ");
        for (Course course : Course.values()) sj.add(course.getName());

        System.out.print(COURSE);
        System.out.println(sj.toString());
    }

    private static void printMission() {
        System.out.println(MISSION);
        for (Level level : Level.values()) {
            StringJoiner sj = new StringJoiner(" | ");
            for (String mission : level.getMissionName()) sj.add(mission);

            System.out.println(String.format(MISSION_FORMAT, level.getName(), sj.toString()));
        }
    }

    private static void printSelectCourseLevelMissionMessage() {
        System.out.println(SELECT_COURSE_LEVEL_MISSION_MESSAGE);
        System.out.println(SELECT_COURSE_LEVEL_MISSION_EXAMPLE);
    }

    public static void printRematchingMessage() {
        System.out.println(SELECT_REMATCHING_MESSAGE);
        System.out.println(YES_OR_NO);
    }

//    public static void printPairMatchingResult(List<Pair> pairResult) {
//        for (Pair pair : pairResult) {
//            System.out.println(pair.toString());
//        }
//    }

    public static void printPairMatchingResult(Course course, String missionName) {
        List<Pair> pairResult = PairMatchingResult.getPairByCourseMission(course, missionName);
        for (Pair pair : pairResult) {
            System.out.println(pair.toString());
        }
    }

    public static void printNothingToLookUpMessage() {
        System.out.println(NOTHING_TO_LOOK_UP_MESSAGE);
    }

    public static void printInitializationMessage() {
        System.out.println(INITIALIZATION_MESSAGE);
    }

    public static void printErrorMessage(String error) {
        System.out.println(error);
    }
}

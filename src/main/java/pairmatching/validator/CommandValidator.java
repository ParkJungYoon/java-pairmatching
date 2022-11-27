package pairmatching.validator;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.List;
import java.util.Objects;

public class CommandValidator {
    private final static String INVALID_TYPE_ERROR_MESSAGE = "[ERROR] 1. 페어 매칭 2. 페어 조회 3. 페어 초기화 Q. 종료 다음 중 선택해주세요.";
    private final static int INPUT_SIZE = 3;
    private final static String SIZE_ERROR_MESSAGE = "[ERROR] 과정, 레벨, 미션 3가지를 입력해주세요.";
    private final static String INVALID_COURSE_NAME_ERROR = "[ERROR] 과정은 백엔드, 프론트엔드 두 가지입니다.";
    private final static String INVALID_LEVEL_NAME_ERROR = "[ERROR] 해당 레벨을 존재하지 않습니다.";
    private final static String NOT_EXIST_LEVEL_ERROR = "[ERROR] 해당 레벨에는 미션이 없습니다.";

    public static void validateInvalidType(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
    }

    public static void validateSize(List<String> input) {
        int inputSize = input.size();
        if (inputSize != INPUT_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateInvalidCourse(String course) {
        Course result = Course.findContainCourse(course);
        if (result == null) {
            throw new IllegalArgumentException(INVALID_COURSE_NAME_ERROR);
        }
    }

    private static void validateInvalidLevelMission(String level, String mission) {
        if (Objects.equals(level, Level.LEVEL3.getName()) || Objects.equals(level, Level.LEVEL5.getName())) {
            throw new IllegalArgumentException(NOT_EXIST_LEVEL_ERROR);
        }
        Level result = Level.findContainLevel(level);

        if (result == null) {
            throw new IllegalArgumentException(INVALID_LEVEL_NAME_ERROR);
        }
    }

    public static void validateInvalidCourseAndLevel(String course, String level, String mission) {
        validateInvalidCourse(course);
        validateInvalidLevelMission(level, mission);

    }
}

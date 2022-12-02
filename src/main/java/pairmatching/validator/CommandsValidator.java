package pairmatching.validator;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.List;

public class CommandsValidator {
    private final static int size = 3;
    private final static String INVALID_SIZE_ERROR = "[ERROR] 과정, 레벨, 미션을 ,(콤마) 기준으로 모두 입력해주세요.";
    private final static String INVALID_COURSE_NAME_ERROR = "[ERROR] 존재하지 않는 과정입니다. 프론트엔드, 백엔드 중에서 입력해주세요.";
    private final static String INVALID_LEVEL_ERROR = "[ERROR] 존재하지 않는 레벨입니다. 레벨1~레벨5 사이에서 입력해주세요.";

    public static void validateSize(List<String> input) {
        if (input.size() != size) {
            throw new IllegalArgumentException(INVALID_SIZE_ERROR);
        }
    }

    private static void validateNonExistentCourse(String input) {
        if (!Course.hasCourseName(input)) {
            throw new IllegalArgumentException(INVALID_COURSE_NAME_ERROR);
        }
    }

    private static void validateNonExistentLevel(String input) {
        if (!Level.hasLevel(input)) {
            throw new IllegalArgumentException(INVALID_LEVEL_ERROR);
        }
    }
}

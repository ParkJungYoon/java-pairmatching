package pairmatching.validator;

import java.util.List;

public class CommandsValidator {
    private final static int size = 3;
    private final static String INVALID_SIZE_ERROR = "[ERROR] 과정, 레벨, 미션을 ,(콤마) 기준으로 모두 입력해주세요.";

    public static void validateSize(List<String> input) {
        if (input.size() != size) {
            throw new IllegalArgumentException(INVALID_SIZE_ERROR);
        }
    }
}

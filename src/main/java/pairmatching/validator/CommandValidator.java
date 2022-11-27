package pairmatching.validator;

public class CommandValidator {
    private final static String INVALID_TYPE_ERROR_MESSAGE = "[ERROR] 1. 페어 매칭 2. 페어 조회 3. 페어 초기화 Q. 종료 다음 중 선택해주세요.";

    public static void validateInvalidType(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
    }
}

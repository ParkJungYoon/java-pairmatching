package pairmatching.validator;

import java.util.Arrays;
import java.util.List;

public class CommandValidator {
    private static final String INVALID_MENU_COMMAND = "[ERROR] 기능 선택은 1,2,3,Q로 입력해주세요.";
    private static final String INVALID_REMATCHING_COMMAND = "[ERROR] 네, 아니오로 입력해주세요.";

    public static void validateInvalidMenuCommand(String input) {
        List<String> command = Arrays.asList("1", "2", "3", "Q");
        if (!command.contains(input)) {
            throw new IllegalArgumentException(INVALID_MENU_COMMAND);
        }
    }

    public static void validateInvalidRematchingCommand(String input) {
        List<String> command = Arrays.asList("네", "아니오");
        if (!command.contains(input)) {
            throw new IllegalArgumentException(INVALID_REMATCHING_COMMAND);
        }
    }
}

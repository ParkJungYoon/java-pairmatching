package pairmatching.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {
    public static List<String> splitInput(String input) {
        String[] transformInput = Arrays.stream(input.split(","))
                .map(String::trim)
                .toArray(String[]::new);
        return new ArrayList<>(List.of(transformInput));
    }
}

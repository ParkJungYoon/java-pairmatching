package pairmatching.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {
    public List<String> splitMatchingCourseAndMission(String input) {
        String[] splitedInput = Arrays.stream(input.split(","))
                .map(String::trim)
                .toArray(String[]::new);
        List<String> courseAndMission = new ArrayList<>(List.of(splitedInput));
        return courseAndMission;
    }
}

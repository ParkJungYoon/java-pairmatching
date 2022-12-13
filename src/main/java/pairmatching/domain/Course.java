package pairmatching.domain;

import java.util.Objects;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return this.name;
    }

    public static Course getTypeByName(String input) {
        for (Course type : Course.values()) {
            if (Objects.equals(type.getName(), input)) {
                return type;
            }
        }
        return BACKEND;
    }

    public static boolean hasCourseName(String name) {
        for (Course course : Course.values()) {
            if (Objects.equals(course.getName(), name)) return true;
        }
        return false;
    }
}
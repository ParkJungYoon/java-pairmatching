package pairmatching.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crews {
    private static List<Crew> frontEndCrew;
    private static List<Crew> backEndCrew;

    static {
        frontEndCrew = initCrew(Course.FRONTEND, "./src/main/resources/frontend-crew.md");
        backEndCrew = initCrew(Course.BACKEND, "./src/main/resources/backend-crew.md");
    }

    private static List<Crew> initCrew(Course course, String pathName) {
        List<Crew> crew = new ArrayList<>();

        File file = new File(pathName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                crew.add(new Crew(course, line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crew;
    }

    public static List<Crew> getCrews(Course course) {
        if (course == Course.FRONTEND) return frontEndCrew;
        return backEndCrew;
    }
}

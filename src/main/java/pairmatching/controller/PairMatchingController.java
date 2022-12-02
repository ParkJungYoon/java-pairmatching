package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.validator.CommandValidator.validateInvalidMenuCommand;

public class PairMatchingController {
    public void startPairMatching() {
        List<Crew> frontEndCrew = initCrew(Course.FRONTEND, "./src/main/resources/frontend-crew.md");
        List<Crew> backEndCrew = initCrew(Course.BACKEND, "./src/main/resources/backend-crew.md");
    }

    private List<Crew> initCrew(Course course, String pathName) {
        List<Crew> crew = new ArrayList<>();

        File file = new File(pathName);
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                crew.add(new Crew(course, line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crew;
    }


    private String initMenuCommand() {
        String command;
        try {
            command = InputView.readMenuCommand();
            validateInvalidMenuCommand(command);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initMenuCommand();
        }
        return command;
    }
}

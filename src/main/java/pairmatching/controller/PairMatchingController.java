package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatchingResult;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;
import static pairmatching.util.Transform.splitInput;
import static pairmatching.validator.CommandValidator.validateInvalidMenuCommand;
import static pairmatching.validator.CommandValidator.validateInvalidRematchingCommand;
import static pairmatching.validator.CommandsValidator.validateCourseLevelMission;
import static pairmatching.validator.CommandsValidator.validateSize;

public class PairMatchingController {
    public void selectMenu() {
        List<Crew> frontEndCrew = initCrew(Course.FRONTEND, "./src/main/resources/frontend-crew.md");
        List<Crew> backEndCrew = initCrew(Course.BACKEND, "./src/main/resources/backend-crew.md");
        PairMatchingResult pairMatchingResult = new PairMatchingResult();

        String menu = initMenuCommand();
        if (menu.equals("1")) {
            startPairMatching(pairMatchingResult);
        }
    }

    private void startPairMatching(PairMatchingResult pairMatchingResult) {
        List<String> commands = initCourseLevelMission();
        if (pairMatchingResult.hasMatchingResult(Course.getTypeByName(commands.get(0)), commands.get(2))) {
            // 결과 있으면 재매칭 시도
            initRematching();
        }
    }

    private void createPair(List<Crew> shuffledCrew) {
        List<Pair> pairMatching = new ArrayList<>();
        int limit = 2;
        for(int id = 0; id < shuffledCrew.size(); id += limit){
            if (shuffledCrew.size() % 2 == 1 && id == shuffledCrew.size() - 3) {
                List<Crew> pair = new ArrayList<>(shuffledCrew.subList(id, shuffledCrew.size()));
                pairMatching.add(new Pair(pair));
                break;
            }
            List<Crew> pair = new ArrayList<>(shuffledCrew.subList(id, min(id + limit, shuffledCrew.size())));
            pairMatching.add(new Pair(pair));
        }
        for (Pair pair : pairMatching) {
            System.out.println(pair.toString());
        }
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

    private List<String> initCourseLevelMission() {
        List<String> commands;
        try {
            commands = splitInput(InputView.readCourseLevelMission());
            validateSize(commands);
            validateCourseLevelMission(commands);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initCourseLevelMission();
        }
        return commands;
    }

    private boolean initRematching() {
        boolean isRematching = false;
        try {
            String command = InputView.readRematching();
            validateInvalidRematchingCommand(command);
            if (command.equals("네")) isRematching = true;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initRematching();
        }
        return isRematching;
    }
}

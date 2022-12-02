package pairmatching.controller;

import pairmatching.domain.*;
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
import static pairmatching.validator.CommandValidator.validateInvalidRematchingCommand;
import static pairmatching.validator.CommandsValidator.validateCourseLevelMission;
import static pairmatching.validator.CommandsValidator.validateSize;

public class PairMatchingController {
    private final List<Crew> frontEndCrew = initCrew(Course.FRONTEND, "./src/main/resources/frontend-crew.md");
    private final List<Crew> backEndCrew = initCrew(Course.BACKEND, "./src/main/resources/backend-crew.md");

    public void startPairMatching() {
        List<String> commands = initCourseLevelMission();
        boolean hasResult = PairMatchingResult.hasMatchingResult(Course.getTypeByName(commands.get(0)), commands.get(2));
        if (hasResult) {
            if (initRematching()) {
                createPair(Course.getTypeByName(commands.get(0)), commands.get(2));
                PairMatchingResult.printPairMatching(Course.getTypeByName(commands.get(0)), commands.get(2));
            }
        }
        if (!hasResult) {
            createPair(Course.getTypeByName(commands.get(0)), commands.get(2));
            PairMatchingResult.printPairMatching(Course.getTypeByName(commands.get(0)), commands.get(2));
        }
    }

    private void createPair(Course course, String mission) {
        PairGeneratorImpl pairGenerator = new PairGeneratorImpl();
        List<Crew> shuffledCrew = new ArrayList<>();
        if (course == Course.FRONTEND) shuffledCrew = pairGenerator.generate(frontEndCrew);
        if (course == Course.BACKEND) shuffledCrew = pairGenerator.generate(backEndCrew);

        List<Pair> pairMatching = new ArrayList<>();
        int limit = 2;
        for (int id = 0; id < shuffledCrew.size(); id += limit) {
            if (shuffledCrew.size() % 2 == 1 && id == shuffledCrew.size() - 3) {
                List<Crew> pair = new ArrayList<>(shuffledCrew.subList(id, shuffledCrew.size()));
                pairMatching.add(new Pair(pair));
                break;
            }
            List<Crew> pair = new ArrayList<>(shuffledCrew.subList(id, min(id + limit, shuffledCrew.size())));
            pairMatching.add(new Pair(pair));
        }
        PairMatchingResult.savePairMatchingResult(course, mission, pairMatching);
    }

    public void startInitialization() {
        OutputView.printInitializationMessage();
        PairMatchingResult.initialization();
    }

    private List<Crew> initCrew(Course course, String pathName) {
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

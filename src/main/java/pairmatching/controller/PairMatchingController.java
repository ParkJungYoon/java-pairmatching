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
    public void startPairMatching() {
        List<String> commands = initCourseLevelMission();
        boolean hasResult = PairMatchingResult.hasMatchingResult(Course.getTypeByName(commands.get(0)), commands.get(2));
        if (hasResult) {
            if (initRematching()) {
                getPair(Course.getTypeByName(commands.get(0)), commands.get(2));
                OutputView.printPairMatchingResult(Course.getTypeByName(commands.get(0)), commands.get(2));
                return;
            }
        }
        getPair(Course.getTypeByName(commands.get(0)), commands.get(2));
        OutputView.printPairMatchingResult(Course.getTypeByName(commands.get(0)), commands.get(2));
    }

    private void getPair(Course course, String mission) {
        PairGeneratorImpl pairGenerator = new PairGeneratorImpl();
        List<Crew> shuffledCrew = new ArrayList<>();
        if (course == Course.FRONTEND) shuffledCrew = pairGenerator.generate(Crews.getCrews(Course.FRONTEND));
        if (course == Course.BACKEND) shuffledCrew = pairGenerator.generate(Crews.getCrews(Course.BACKEND));

        List<Pair> pairMatching = createPair(shuffledCrew);
        PairMatchingResult.savePairMatchingResult(course, mission, pairMatching);
    }

    private List<Pair> createPair(List<Crew> shuffledCrew) {
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
        return pairMatching;
    }

    public void startPairLookUp() {
        List<String> commands = initCourseLevelMission();

        boolean hasResult = PairMatchingResult.hasMatchingResult(Course.getTypeByName(commands.get(0)), commands.get(2));
        if (hasResult) {
            OutputView.printPairMatchingResult(Course.getTypeByName(commands.get(0)), commands.get(2));
            return;
        }
        OutputView.printNothingToLookUpMessage();
    }

    public void startInitialization() {
        OutputView.printInitializationMessage();
        PairMatchingResult.initialization();
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

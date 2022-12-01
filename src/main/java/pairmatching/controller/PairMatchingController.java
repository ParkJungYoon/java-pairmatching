package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.MatchingResult;
import pairmatching.util.Transform;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static pairmatching.validator.CommandValidator.validateInvalidCourseAndLevel;
import static pairmatching.validator.CommandValidator.validateSize;

public class PairMatchingController {
    Crews backendCrews;
    Crews frontendCrews;

    public void matchingMenu() {
        String feature = initFeatureNumber();
        if (Objects.equals(feature, "1")) {
            matchingStart();
        } else if (Objects.equals(feature, "2")) {

        }
    }

    public void matchingStart() {
        String feature = initFeatureNumber();
        do {
            List<String> courseAndMission = initCourseAndMission();
            if (Objects.equals(courseAndMission.get(0), "백엔드")) {
                initBackEndCrew();
                List<Crews> pair = createPair(backendCrews);
                OutputView.printPairMatchingResult(pair);
                feature = initFeatureNumber();
            } else if (Objects.equals(courseAndMission.get(0), "프론트엔드")) {
                initFrontEndCrew();
            }
        } while (!Objects.equals(feature, "Q"));
    }

    private List<Crews> createPair(Crews crews) {
        List<Crews> pair = new ArrayList<>();
        Crews shuffledCrew = crews.shuffleCrew();
        System.out.println(shuffledCrew.toString());
        List<Crew> temp = new ArrayList<>();

        for (int i = 0; i < shuffledCrew.size(); i++) {
            Crew crew = shuffledCrew.get(i);
            temp.add(crew);
            if (temp.size() >= 2) {
                Crews crews1 = new Crews(temp);
                pair.add(crews1);
                temp = new ArrayList<>();
            }
        }

//        for (Crew crew : shuffledCrew) {
//            temp.add(crew);
//            if (temp.size() >= 2) {
//                Crews crews1 = new Crews(temp);
//                pair.add(crews1);
//                temp = new ArrayList<>();
//            }
//        }
//        if (temp.size() == 1) {
//            pair.get(pair.size() - 1).add(temp.get(0));
//        }
        saveMatchingPair("레벨1", "자동차경주", pair);
        return pair;
    }

    private void saveMatchingPair(String level, String mission, List<Crews> pair) {
        MatchingResult matchingResult = new MatchingResult();
        if (Objects.equals(level, "레벨1")) {
            matchingResult.saveLevel1MatchingResult(mission, pair);
        }
    }

    private void initBackEndCrew() {
        List<Crew> backendCrew = new ArrayList<>();
//        System.out.println(System.getProperty("user.dir"));
        File file = new File("./src/main/resources/backend-crew.md");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Crew crew = new Crew(Course.BACKEND, line);                Crew crew = new Crew(Course.BACKEND, line);
//                Crew crew = new Crew(line);
                backendCrew.add(crew);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        backendCrews = new Crews(backendCrew);
    }

    private void initFrontEndCrew() {
        List<Crew> frontendCrew = new ArrayList<>();
        File file = new File("./src/main/resources/frontend-crew.md");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Crew crew = new Crew(Course.FRONTEND, line);
//                Crew crew = new Crew(line);
                frontendCrew.add(crew);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        frontendCrews = new Crews(frontendCrew);
    }

    private String initFeatureNumber() {
        String featureNumber = "";
        try {
            featureNumber = InputView.readFeatureNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return initFeatureNumber();
        }
        return featureNumber;
    }

    public List<String> initCourseAndMission() {
        Transform transform = new Transform();
        List<String> chooseMatching;

        try {
            String matchingCourseAndMission = InputView.readMatchingCourseAndMission();
            chooseMatching = transform.splitMatchingCourseAndMission(matchingCourseAndMission);

            validateSize(chooseMatching);
            validateInvalidCourseAndLevel(chooseMatching.get(0), chooseMatching.get(1), chooseMatching.get(2));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return initCourseAndMission();
        }
        return chooseMatching;
    }
}
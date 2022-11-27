package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Crews {
    private List<Crew> crewNames;

    public Crews(List<Crew> crewNames) {
        this.crewNames = crewNames;
    }

    public List<Crew> shuffleCrew() {
        List<Crew> shuffledCrew = Randoms.shuffle(crewNames);
//        System.out.println(shuffledCrew.toString());
//        for (Crew crew : shuffledCrew) {
//            System.out.println(crew.toString());
//        }
        return shuffledCrew;
    }

    public void makeFair() {

    }

    @Override
    public String toString() {
        return "Crews{" +
                "crewNames=" + crewNames +
                '}';
    }
}

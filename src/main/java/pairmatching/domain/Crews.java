package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Crews {
    private final List<Crew> crewNames;

    public Crews(List<Crew> crewNames) {
        this.crewNames = crewNames;
    }

    public Crews shuffleCrew() {
        List<Crew> shuffledCrew = Randoms.shuffle(crewNames);
        return new Crews(shuffledCrew);
    }

    public int size() {
        return crewNames.size();
    }

    public Crew get(int index) {
        return crewNames.get(index);
    }

    @Override
    public String toString() {
        return "Crews{" +
                "crewNames=" + crewNames +
                '}';
    }
}

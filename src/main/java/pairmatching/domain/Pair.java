package pairmatching.domain;

import java.util.List;
import java.util.StringJoiner;

public class Pair {
    private List<Crew> pair;

    public Pair(List<Crew> pair) {
        this.pair = pair;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" : ");
        for (Crew crew : pair) {
            sj.add(crew.toString());
        }

        return sj.toString();
    }
}

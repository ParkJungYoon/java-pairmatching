package pairmatching.domain;

import java.util.List;

public class Pair {
    private List<Crew> pair;

    public Pair(List<Crew> pair) {
        this.pair = pair;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "pair=" + pair.toString() +
                '}';
    }
}

package pairmatching.domain;

import java.util.List;

@FunctionalInterface
public interface PairGenerator {

    List<Crew> generate(List<Crew> crew);
}

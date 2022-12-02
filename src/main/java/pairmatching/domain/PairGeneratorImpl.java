package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class PairGeneratorImpl implements PairGenerator{

    @Override
    public List<Crew> generate(List<Crew> crew) {
        List<Crew> shuffledCrew = Randoms.shuffle(crew);
        return shuffledCrew;
    }
}

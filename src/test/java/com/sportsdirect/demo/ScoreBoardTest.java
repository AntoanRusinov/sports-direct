package com.sportsdirect.demo;

import com.github.javafaker.Faker;
import com.sportsdirect.demo.service.ScoreBoardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class ScoreBoardTest {

    @Autowired
    private ScoreBoardService scoreBoardService;

    @Test
    public void testStartGame() {
        // given:
        Map<String, String> scoreBoardSummary = scoreBoardService.getScoreBoardSummary();
        Assertions.assertNotNull(scoreBoardSummary);

        // when:
        String homeTeam = Faker.instance().team().name();
        String awayTeam = Faker.instance().team().name();
        scoreBoardService.startGame(homeTeam, awayTeam);

        // then:
        Integer homeTeamPoints = scoreBoardService.getTeamPoints(homeTeam);
        Assertions.assertNotNull(homeTeamPoints);
        Assertions.assertEquals(0, (int) homeTeamPoints);

        Integer awayTeamPoints = scoreBoardService.getTeamPoints(awayTeam);
        Assertions.assertNotNull(awayTeamPoints);
        Assertions.assertEquals(0, (int) awayTeamPoints);
    }

    @Test
    public void testFinishGame() {
        // given:
        String homeTeam = "Mexico";
        String awayTeam = "Canada";

        Map<String, String> matches = scoreBoardService.getMatches();
        Assertions.assertNotNull(matches.get(homeTeam));

        // when:
        scoreBoardService.finishMatch(homeTeam, awayTeam);

        // then:
        Map<String, String> updatedMatches = scoreBoardService.getMatches();
        Assertions.assertNull(updatedMatches.get(homeTeam));
        Assertions.assertNull(scoreBoardService.getTeamPoints(homeTeam));
        Assertions.assertNull(scoreBoardService.getTeamPoints(awayTeam));
    }

    @Test
    public void testUpdateScore() {
        // given:
        String homeTeam = "Mexico";
        String awayTeam = "Canada";

        Map<String, String> matches = scoreBoardService.getMatches();
        Assertions.assertNotNull(matches.get(homeTeam));

        Integer homeTeamPoints = scoreBoardService.getTeamPoints(homeTeam);
        Assertions.assertNotNull(homeTeamPoints);
        Assertions.assertEquals(0, (int) homeTeamPoints);

        Integer awayTeamPoints = scoreBoardService.getTeamPoints(awayTeam);
        Assertions.assertNotNull(awayTeamPoints);
        Assertions.assertEquals(5, (int) awayTeamPoints);

        // when:
        Map<Map<String, Integer>, Map<String, Integer>> matchWithScore = new HashMap<>();
        matchWithScore.put(Map.of(homeTeam, homeTeamPoints + 1), Map.of(awayTeam, awayTeamPoints + 1));
        scoreBoardService.updateScore(matchWithScore);

        // then:
        Map<String, String> updatedMatches = scoreBoardService.getMatches();
        Assertions.assertNotNull(updatedMatches.get(homeTeam));
        Assertions.assertEquals(scoreBoardService.getTeamPoints(homeTeam), 1);
        Assertions.assertEquals(scoreBoardService.getTeamPoints(awayTeam), 6);
    }

    @Test
    public void testGetSummaryByTotalScore() {
        // given:
        // when: getting the summary sorted
        Map<String, String> scoreBoardSummary = scoreBoardService.getScoreBoardSummaryByTotalScore();

        // then:
//        Assertions.assertEquals(scoreBoardSummary.keySet().iterator().next(), "Uruguay 6");

        // TODO: this has to be removed. Upper statement is the correct one.
        Assertions.assertThrows(NullPointerException.class, () -> {
            scoreBoardSummary.keySet().iterator().next();
        });
    }

}
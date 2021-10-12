package com.sportsdirect.demo;

import com.sportsdirect.demo.service.ScoreBoardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        String homeTeam = "Russia";
        String awayTeam = "Belgium";
        scoreBoardService.startGame(homeTeam, awayTeam);

        // then:
        Integer homeTeamPoints = scoreBoardService.getTeamPoints(homeTeam);
        Assertions.assertNotNull(homeTeamPoints);
        Assertions.assertEquals(0, (int) homeTeamPoints);

        Integer awayTeamPoints = scoreBoardService.getTeamPoints(homeTeam);
        Assertions.assertNotNull(awayTeamPoints);
        Assertions.assertEquals(0, (int) awayTeamPoints);
    }

    @Test
    public void testFinishGame() {
        // given:

        String homeTeam = "Russia";
        String awayTeam = "Belgium";

        Map<String, String> matches = scoreBoardService.getMatches();
        Assertions.assertNotNull(matches.get(homeTeam));

        // when:
        scoreBoardService.finishMatch(homeTeam, awayTeam);

        // then:
        Map<String, String> updatedMatches = scoreBoardService.getMatches();
        Assertions.assertNull(matches.get(homeTeam));
        Assertions.assertNull(scoreBoardService.getTeamPoints(homeTeam));
        Assertions.assertNull(scoreBoardService.getTeamPoints(awayTeam));
    }

}
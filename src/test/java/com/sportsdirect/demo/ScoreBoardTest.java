package com.sportsdirect.demo;

import com.github.javafaker.Faker;
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
        String homeTeam = Faker.instance().team().name();
        String awayTeam = Faker.instance().team().name();
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

        // when:

        // then:
    }

}
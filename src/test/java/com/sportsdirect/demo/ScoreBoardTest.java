package com.sportsdirect.demo;

import com.sportsdirect.demo.service.ScoreBoardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Map;

@SpringBootTest
public class ScoreBoardTest {

    @Autowired
    private ScoreBoardService scoreBoardService;

    @Test
    public void testStartGame() {
        // given:
        Map<Map<String, String>, Map<Integer, Integer>> scoreBoardSummary = scoreBoardService.getScoreBoardSummary();
        Assertions.assertNull(scoreBoardSummary.get(Collections.singletonMap("Home Team", "Away Team")));

        // when:
        scoreBoardService.startGame("Home Team", "Away Team");

        // then:
        Map<Map<String, String>, Map<Integer, Integer>> updatedScoreBoardSummary = scoreBoardService.getScoreBoardSummary();
        Map<Integer, Integer> result = updatedScoreBoardSummary.get((Collections.singletonMap("Home Team", "Away Team")));
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, (int) result.get(0));
    }

}
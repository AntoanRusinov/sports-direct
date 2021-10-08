package com.sportsdirect.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;

@SpringBootTest
public class ScoreBoardTest {

    Map<String, String> matches = Stream.of(
                    new AbstractMap.SimpleEntry<>("Mexico", "Canada"),
                    new AbstractMap.SimpleEntry<>("Spain", "Brazil"),
                    new AbstractMap.SimpleEntry<>("Germany", "France"),
                    new AbstractMap.SimpleEntry<>("Uruguay", "Italy"),
                    new AbstractMap.SimpleEntry<>("Argentina", "Australia"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    Map<String, Integer> teamPoints = Stream.of(
                    new AbstractMap.SimpleEntry<>("Mexico", 0),
                    new AbstractMap.SimpleEntry<>("Spain", 2),
                    new AbstractMap.SimpleEntry<>("Germany", 4),
                    new AbstractMap.SimpleEntry<>("Uruguay", 1),
                    new AbstractMap.SimpleEntry<>("Argentina", 4),
                    new AbstractMap.SimpleEntry<>("Canada", 3),
                    new AbstractMap.SimpleEntry<>("Brazil", 3),
                    new AbstractMap.SimpleEntry<>("France", 1),
                    new AbstractMap.SimpleEntry<>("Italy", 5),
                    new AbstractMap.SimpleEntry<>("Australia", 4))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    @Test
    public void testStartGame() {
        // given:
        Map<Map<String, String>, Map<Integer, Integer>> scoreBoardSummary = scoreBoardService.getScoreBoardSummary();
        // when:
        scoreBoardService.startGame("Home Team", "Away Team");
        // then:
        Map<Map<String, String>, Map<Integer, Integer>> updatedScoreBoardSummary = scoreBoardService.getScoreBoardSummary();
        Assertions.assertNotNull(updatedScoreBoardSummary.get(Collections.singletonMap("Home Team", "Away Team")));
    }


}
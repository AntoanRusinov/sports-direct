package com.sportsdirect.demo.service;

import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ScoreBoardService {

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

    public Map<Map<String, String>, Map<Integer, Integer>> getScoreBoardSummary() {
        // TODO: implement
        // TODO: refactor after implementation
        return null;
    }


    public void startGame(String home_team, String away_team) {
        // TODO: implement
        // TODO: refactor after implementation
    }

}
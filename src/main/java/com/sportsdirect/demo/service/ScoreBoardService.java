package com.sportsdirect.demo.service;

import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.HashMap;
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
                    new AbstractMap.SimpleEntry<>("Spain", 10),
                    new AbstractMap.SimpleEntry<>("Germany", 2),
                    new AbstractMap.SimpleEntry<>("Uruguay", 6),
                    new AbstractMap.SimpleEntry<>("Argentina", 3),
                    new AbstractMap.SimpleEntry<>("Canada", 5),
                    new AbstractMap.SimpleEntry<>("Brazil", 2),
                    new AbstractMap.SimpleEntry<>("France", 2),
                    new AbstractMap.SimpleEntry<>("Italy", 6),
                    new AbstractMap.SimpleEntry<>("Australia", 1))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public Map<String, String> getScoreBoardSummary() {
        // TODO: refactor after implementation

        Map<String, String> summary = new HashMap<>();

        for (Map.Entry<String, String> matchEntry : matches.entrySet()) {
            String firstTeam = matchEntry.getKey();
            String secondTeam = matchEntry.getValue();

            String firstTeamWithScore = firstTeam + " " + teamPoints.get(firstTeam);
            String secondTeamWithScore = firstTeam + " " + teamPoints.get(secondTeam);

            summary.put(firstTeamWithScore, secondTeamWithScore);
        }

        return summary;
    }

    public void startGame(String homeTeam, String awayTeam) {
        // TODO: refactor after implementation
        matches.put(homeTeam, awayTeam);
        teamPoints.put(homeTeam, 0);
        teamPoints.put(awayTeam, 0);
    }

    public Integer getTeamPoints(String teamName) {
        return teamPoints.get(teamName);
    }

    public Map<String, String> getMatches() {
        return matches;
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        matches.remove(homeTeam);
        teamPoints.remove(homeTeam);
        teamPoints.remove(awayTeam);
    }

}
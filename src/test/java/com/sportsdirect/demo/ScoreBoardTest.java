package com.sportsdirect.demo;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class ScoreBoardTest {

    Map<String, String> teams = Stream.of(
                    new AbstractMap.SimpleEntry<>("Mexico", "Canada"),
                    new AbstractMap.SimpleEntry<>("Spain", "Brazil"),
                    new AbstractMap.SimpleEntry<>("Germany", "France"),
                    new AbstractMap.SimpleEntry<>("Uruguay", "Italy"),
                    new AbstractMap.SimpleEntry<>("Argentina", "Australia"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


}
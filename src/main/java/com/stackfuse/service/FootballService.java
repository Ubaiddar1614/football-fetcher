package com.stackfuse.service;

import com.stackfuse.api.ApiClient;
import com.stackfuse.config.AppConfig;
import com.stackfuse.model.Match;
import com.stackfuse.parser.MatchParser;
import java.util.ArrayList;
import java.util.List;

public class FootballService {
    private final ApiClient apiClient;
    private final MatchParser matchParser;

    public FootballService() {
        this.apiClient = new ApiClient();
        this.matchParser = new MatchParser();
    }

    public List<Match> getLiveMatches() {
        String endpoint = AppConfig.BASE_URL + "/matches?status=IN_PLAY";
        try {
            String jsonResponse = apiClient.get(endpoint);
            return matchParser.parseMatches(jsonResponse);
        } catch (Exception e) {
            System.err.println("Error fetching live matches: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Match> getAllTodayMatches() {
        String endpoint = AppConfig.BASE_URL + "/matches";
        try {
            String jsonResponse = apiClient.get(endpoint);
            return matchParser.parseMatches(jsonResponse);
        } catch (Exception e) {
            System.err.println("Error fetching today's matches: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
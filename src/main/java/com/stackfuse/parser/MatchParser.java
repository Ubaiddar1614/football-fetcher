package com.stackfuse.parser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stackfuse.model.Match;
import java.util.ArrayList;
import java.util.List;

public class MatchParser {

    /**
     * Parses the JSON string and returns a List of Match objects.
     * Safely handles null scores for unplayed (TIMED) matches.
     */
    public List<Match> parseMatches(String jsonResponse) {
        List<Match> matchList = new ArrayList<>();

        JsonObject root = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonArray matchesArray = root.getAsJsonArray("matches");

        for (JsonElement element : matchesArray) {
            JsonObject matchObj = element.getAsJsonObject();
            String status = matchObj.get("status").getAsString();
            String utcDate = matchObj.get("utcDate").getAsString();
            String homeTeamName = matchObj.getAsJsonObject("homeTeam")
                    .get("name").getAsString();
            String awayTeamName = matchObj.getAsJsonObject("awayTeam")
                    .get("name").getAsString();
            JsonObject fullTime = matchObj.getAsJsonObject("score")
                    .getAsJsonObject("fullTime");
            int homeScore = fullTime.get("home").isJsonNull() ? 0 : fullTime.get("home").getAsInt();
            int awayScore = fullTime.get("away").isJsonNull() ? 0 : fullTime.get("away").getAsInt();
            Match match = new Match(homeTeamName, awayTeamName, homeScore, awayScore, status, utcDate);
            matchList.add(match);
        }

        return matchList;
    }
}
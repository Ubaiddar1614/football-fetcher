package com.stackfuse.display;

import com.stackfuse.model.Match;
import java.util.List;

public class DisplayService {

    public void showMatches(List<Match> matches) {
        if (matches == null || matches.isEmpty()) {
            System.out.println("No matches found for the selected criteria.");
            return;
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.printf("%-35s | %-10s | %-10s\n", "MATCH", "SCORE", "STATUS");
        System.out.println("-".repeat(70));

        for (Match m : matches) {
            String teams = m.getHomeTeam() + " vs " + m.getAwayTeam();
            String scoreDisplay;


            String status = m.getMatchStatus();

            if (status.equals("TIMED") || status.equals("SCHEDULED")) {
                scoreDisplay = " - vs - ";
            } else {

                scoreDisplay = String.format("  %d - %d  ", m.getHomeTeamGoals(), m.getAwayTeamGoals());
            }

            System.out.printf("%-35s | %-10s | %-10s\n", teams, scoreDisplay, status);
        }

        System.out.println("=".repeat(70) + "\n");
    }
}
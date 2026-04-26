package com.stackfuse;

import com.stackfuse.display.DisplayService;
import com.stackfuse.model.Match;
import com.stackfuse.service.FootballService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FootballService footballService = new FootballService();
        DisplayService displayService = new DisplayService();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        System.out.println("Welcome to the Football Score Tracker!");

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\nFetching live matches...");
                    List<Match> liveMatches = footballService.getLiveMatches();
                    displayService.showMatches(liveMatches);
                    break;

                case "2":
                    System.out.println("\nFetching today's schedule...");
                    List<Match> todayMatches = footballService.getAllTodayMatches();
                    displayService.showMatches(todayMatches);
                    break;

                case "3":
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please pick 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. View Live Matches");
        System.out.println("2. View All Today's Matches");
        System.out.println("3. Exit");
    }
}
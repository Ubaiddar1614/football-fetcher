# Football Score Fetcher

A simple Java CLI app that pulls live football data from the internet and displays it in the terminal. Built this as my first real Java project without a framework.

## What it does
- View live matches happening right now
- View all today's scheduled and finished matches
- Scores, teams, and match status all in one place

## Tech
- Java 25
- Maven
- Gson (JSON parsing)
- football-data.org API

## How to run

**1. Clone the repo**
git clone https://github.com/Ubaiddar1614/football-fetcher.git

**2. Get a free API key**
Register at football-data.org — takes 2 minutes, they email you the key.

**3. Create the config file**
Create this file manually (it's gitignored so it won't be in the repo):
src/main/resources/config.properties

Add this inside it:
API_KEY=your_key_here

**4. Run it**
mvn compile
mvn exec:java -Dexec.mainClass="com.stackfuse.Main"

## Notes
Free tier of the API covers Premier League, La Liga, Bundesliga, Serie A, Ligue 1 and a few others.
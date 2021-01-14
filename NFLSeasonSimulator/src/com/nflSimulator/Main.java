package com.nflSimulator;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
		
		ArrayList<Conference> NFL = new ArrayList<Conference>();
		
		Conference NFC = new Conference("NFC");
		NFL.add(NFC);
		Division nfcNorth = new Division("NFC North");
		Division nfcSouth = new Division("NFC South");
		NFC.addDivision(nfcNorth);
		NFC.addDivision(nfcSouth);
		
		
		Team vikings = new Team(0, 0, 0, "Vikings");
		Team bears = new Team(0, 0, 0, "Bears");
		Team packers = new Team(0, 0, 0, "Packers");
		Team lions = new Team(0, 0, 0, "Lions");
		nfcNorth.addTeam(vikings);
		nfcNorth.addTeam(bears);
		nfcNorth.addTeam(packers);
		nfcNorth.addTeam(lions);
		
		Team saints = new Team(0, 0, 0,  "Saints");
		Team buccaneers = new Team(0, 0, 0, "Buccaneers");
		Team ravens = new Team(0, 0, 0, "Ravens");
		Team panthers = new Team(0, 0, 0, "Panthers");
		nfcSouth.addTeam(saints);
		nfcSouth.addTeam(buccaneers);
		nfcSouth.addTeam(ravens);
		nfcSouth.addTeam(panthers);
		System.out.println("Teams added");
		ArrayList<Game> games = new ArrayList<Game>();
		games.add(new Game(vikings, packers, 50));
		games.add(new Game(packers, vikings, 50));
		games.add(new Game(vikings, bears, 50));
		games.add(new Game(bears, vikings, 50));
		games.add(new Game(vikings, lions, 50));
		games.add(new Game(lions, vikings, 50));
		games.add(new Game(packers, bears, 50));
		games.add(new Game(bears, packers, 50));
		games.add(new Game(packers, lions, 50));
		games.add(new Game(lions, packers, 50));
		games.add(new Game(bears, lions, 50));
		games.add(new Game(lions, bears, 50));
		games.add(new Game(saints, buccaneers, 50));
		games.add(new Game(saints, ravens, 50));
		games.add(new Game(saints, panthers, 50));
		games.add(new Game(buccaneers, saints, 50));
		games.add(new Game(ravens, saints, 50));
		games.add(new Game(panthers, saints, 50));
		games.add(new Game(buccaneers, ravens, 50));
		games.add(new Game(buccaneers, panthers, 50));
		games.add(new Game(ravens, buccaneers, 50));
		games.add(new Game(panthers, buccaneers, 50));
		games.add(new Game(ravens, panthers, 50));
		games.add(new Game(panthers, ravens, 50));
		
		
		Season firstSeason = new Season(NFL, games, new ArrayList<Game>());
		firstSeason.simulateSeason();
		
		int counter = 0;
		System.out.println("Things are happening?");
		out.println(firstSeason.getStandingsString(NFC));
		out.println(firstSeason.getPlayoffSeeds(NFC));
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}

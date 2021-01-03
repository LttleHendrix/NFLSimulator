package com.nflSimulator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Team {
	
	private int wins;
	private int losses;
	private int ties;
	private int originalWins;
	private int originalLosses;
	private int originalTies;
	private String teamName;
	
	public Team() {
		wins = 0;
		losses = 0;
	}
	
	public Team(int wins, int losses, int ties, String teamName) {
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
		originalLosses = losses;
		originalWins = wins;
		originalTies = ties;
		this.teamName = teamName;
	}
	
	public void addWin() {
		wins = wins + 1;
	}
	
	public void addLoss() {
		losses = losses + 1;
	}
	
	public void addTie() {
		ties = ties + 1;
	}
	
	public String getRecord() {
		return wins + "-" + losses;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public int getWins() {
		return wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public int getTies() {
		return ties;
	}
	
	public String toString() {
		if(ties == 0 ) {
			return teamName + " "+wins+"-"+losses;
		} else {
			return teamName + " "+wins+"-"+losses+"-"+ties;
		}
	}

	public void resetTeam() {
		wins = originalWins;
		losses = originalLosses;
	}
	
}

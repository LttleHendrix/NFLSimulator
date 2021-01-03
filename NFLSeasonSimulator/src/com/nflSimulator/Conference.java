package com.nflSimulator;
import java.util.ArrayList;
import java.util.Collections;
public class Conference {
	
	private String conferenceName;
	private ArrayList<Division> divisions = new ArrayList<Division>();

	public Conference(String conferenceName) {
		this.conferenceName = conferenceName;
	}
	
	public void addDivision(Division newDivision) {
		divisions.add(newDivision);
	}
	
	public ArrayList<Team> getWildCardWinners() {
		ArrayList<Team> contenders = new ArrayList<Team>();
		ArrayList<Team> winners = new ArrayList<Team>();
		
		for(int i=0; i<divisions.size(); i++) {
			contenders.addAll((ArrayList<Team>)divisions.get(i).getWildCardContenders());
		}
		Collections.sort(contenders, new TeamComparator());
		
		if(contenders.size() < 4) {
			throw new NullPointerException();
		}
		
		for(int i=0; i<4; i++) {
			winners.add(contenders.get(i));
		}
		return winners;
	}
	
	public ArrayList<Team> getDivisionWinners() {
		ArrayList<Team> winners = new ArrayList<Team>();
		for(int i=0; i<divisions.size(); i++) {
			winners.add(divisions.get(i).getDivisionWinner());
		}
		Collections.sort(winners, new TeamComparator());
		return winners;
	}
	
	public ArrayList<Team> getPlayoffSeeds() {
		ArrayList<Team> seeds = new ArrayList<Team>();
		seeds.addAll(getDivisionWinners());
		seeds.addAll(getWildCardWinners());
		return seeds;
	}
	
	public String getPlayoffTeams() {
		ArrayList<Team> playoffTeams = getPlayoffSeeds();
		String toReturn = "";
		for(int i=0; i<playoffTeams.size(); i++) {
			toReturn = toReturn + playoffTeams.get(i) + "\n";
		}
		return toReturn;
	}
	
	public ArrayList<Team> getOverallStandings() {
		ArrayList<Team> toReturn = new ArrayList<Team>();
		for(int i=0; i<divisions.size(); i++) {
			toReturn.addAll(divisions.get(i).getStandings());
		}
		Collections.sort(toReturn, new TeamComparator());
		return toReturn;
	}
	
	public ArrayList<Division> getDivisions() {
		return divisions;
	}

	public void resetConference() {
		for(int i=0; i<divisions.size(); i++) {
			divisions.get(i).resetDivision();
		}
	}
	
	
}

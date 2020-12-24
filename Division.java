import java.util.Collections;
import java.util.ArrayList;

public class Division {
	
	ArrayList<Team> teams = new ArrayList<Team>();
	ArrayList<Team> originalTeams = new ArrayList<Team>();
	String divisionName;

	public Division(String divisionName) {
		this.divisionName = divisionName;
	}
	
	public void addTeam(Team newTeam) {
		teams.add(newTeam);
	}
	
	public Team getDivisionWinner() {
		Collections.sort(teams, new TeamComparator());
		return teams.get(0);
	}
	
	public ArrayList<Team> getWildCardContenders() {
		ArrayList<Team> toReturn = new ArrayList<Team>();
		Collections.sort(teams, new TeamComparator());
		for(int i=1; i<teams.size(); i++) {
			toReturn.add(teams.get(i));
		}
		return toReturn;
	}
	
	public ArrayList<Team> getStandings() {
		Collections.sort(teams, new TeamComparator());
		return teams;
	}

	public void resetDivision() {
		for(int i=0; i<teams.size(); i++) {
			teams.get(i).resetTeam();
		}
	}
	
	
	
	
}

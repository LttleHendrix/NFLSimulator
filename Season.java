import java.util.ArrayList;
import java.util.Collections;

public class Season {

	private ArrayList<Game> gamesRemaining = new ArrayList<Game>();
	private ArrayList<Game> gamesComplete = new ArrayList<Game>();
	private ArrayList<Conference> conferences = new ArrayList<Conference>();
	
	private ArrayList<Game> originalGamesComplete = new ArrayList<Game>();
	private ArrayList<Game> originalGamesRemaining = new ArrayList<Game>();
	private ArrayList<Conference> originalConferences = new ArrayList<Conference>();
	
	public Season(ArrayList<Conference> conferences, ArrayList<Game> gamesRemaining, ArrayList<Game> gamesComplete) {
		this.conferences = conferences;
		this.gamesRemaining = gamesRemaining;
		this.gamesComplete = gamesComplete;
		this.originalConferences = (ArrayList<Conference>)conferences.clone();
		this.originalGamesRemaining = (ArrayList<Game>)gamesRemaining.clone();
		this.originalGamesComplete = (ArrayList<Game>)gamesComplete.clone();
	}
	
	public void simulateSeason() {
		while(gamesRemaining.size() > 0) {
			gamesRemaining.get(0).simulateGame();
			gamesComplete.add(gamesRemaining.remove(0));
		}
	}
	
	public ArrayList<Team> getOverallStandings(Conference conference) {
		return conference.getOverallStandings();
	}
	
	public String getStandingsString(Conference conference) {
		ArrayList<Team> standings = getOverallStandings(conference);
		String toReturn = "";
		
		for(int i=0; i<standings.size(); i++) {
			toReturn = toReturn + standings.get(i) + "\n";
		}
		return toReturn;
	}
	
	public Team getDivisionWinner(Division division) {
		return division.getDivisionWinner();
	}
	
	public String getPlayoffSeeds(Conference conference) {
		
		String toReturn = "Division Winners\n";
		
		ArrayList<Team> divisionWinners = conference.getDivisionWinners();
		for(int i=0; i<divisionWinners.size(); i++) {
			toReturn = toReturn + divisionWinners.get(i) + "\n";
		}
		
		toReturn = toReturn + "Wild Card Teams \n";
		
		ArrayList<Team> wildCardWinners = conference.getWildCardWinners();
		for(int i=0; i<wildCardWinners.size(); i++) {
			toReturn = toReturn + wildCardWinners.get(i) + "\n";
		}
		
		return toReturn;
		
		
	}
	
	
	
	public void resetSeason() {
		gamesRemaining = (ArrayList<Game>)originalGamesRemaining.clone();
		System.out.println(""+gamesRemaining.size());
		gamesComplete = (ArrayList<Game>)originalGamesComplete.clone();
		conferences = (ArrayList<Conference>)originalConferences.clone();
		for(int i=0; i<conferences.size(); i++) {
			conferences.get(i).resetConference();
		}
	}
	
	
	
	
	
}


public class Team {

	private int wins;
	private int losses;
	private int originalWins;
	private int originalLosses;
	private String teamName;
	
	public Team() {
		wins = 0;
		losses = 0;
	}
	
	public Team(int wins, int losses, String teamName) {
		this.wins = wins;
		this.losses = losses;
		originalLosses = losses;
		originalWins = wins;
		this.teamName = teamName;
	}
	
	public void addWin() {
		wins = wins + 1;
	}
	
	public void addLoss() {
		losses = losses + 1;
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
	
	public String toString() {
		String toReturn = "";
		toReturn = toReturn + teamName+ ": ";
		toReturn = toReturn + wins+"-"+losses;
		return toReturn;
	}

	public void resetTeam() {
		wins = originalWins;
		losses = originalLosses;
	}
	
	
	
}

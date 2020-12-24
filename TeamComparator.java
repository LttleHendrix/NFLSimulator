import java.util.Comparator;

public class TeamComparator implements Comparator<Team> {

	public int compare(Team o1, Team o2) {
		int score = o1.getWins() - o1.getLosses();
		int otherScore = o2.getWins() - o2.getLosses();
		if(score < otherScore) {
			return 1;
		} else if(score > otherScore) {
			return -1;
		} else {
			return 0;
		}
	}

	
}

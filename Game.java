import java.util.Random;
public class Game {
	
	Team homeTeam;
	Team awayTeam;
	double homeWinProbability;
	Team teamWon;
	Team teamLost;
	Random random = new Random();
	
	
	public Game(Team homeTeam, Team awayTeam, double homeWinProbability) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeWinProbability = homeWinProbability;
	}
	
	
	public void simulateGame() {
		int winner = random.nextInt(100) + 1;
		if(winner <= homeWinProbability) {
			teamWon = homeTeam;
			teamLost = awayTeam;
			homeTeam.addWin();
			awayTeam.addLoss();
		} else {
			teamWon = awayTeam;
			teamLost = homeTeam;
			homeTeam.addLoss();
			awayTeam.addWin();
		}
	}
	
	
	
}

import java.util.Scanner;
import java.util.Stack;

public class Driver {
	 public static void printTable(Stack<Integer> teamObserverStack, Stack<Integer> gamePredictorStack) {
	        System.out.println("Quarter | Team Observer | Game Predictor");
	        System.out.println("--------------------------------------");

	        int quarters = Math.min(teamObserverStack.size(), gamePredictorStack.size());

	        for (int quarter = 1; quarter <= quarters; quarter++) {
	            int teamObserverResult = teamObserverStack.get(quarter - 1);
	            int gamePredictorResult = gamePredictorStack.get(quarter - 1);

	            System.out.printf("%-8d| %-14s| %-16s%n", quarter, getOutcome(teamObserverResult), getOutcome(gamePredictorResult));
	        }
	    }

	    private static String getOutcome(int result) {
	        switch (result) {
	            case 0:
	                return "Tie";
	            case 1:
	                return "Team A Won";
	            case 2:
	                return "Team B Won";
	            default:
	                return "Invalid Result";
	        }
	    }
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome Everyone! Tonights game is the ");
		String teamA =scanner.nextLine();
		System.out.println("against the ");
		String teamB =scanner.nextLine();
		System.out.println("Let's have a good game tonight! Playball!");
		BasketballGame game = new BasketballGame();
		
        // Create observers
	    CurrentGameObserver Game1 = new CurrentGameObserver(teamA, teamB);
	    GamePredictor Announcer = new GamePredictor(teamA, teamB);
	    FinalReporter NewspaperTitle = new FinalReporter(teamA, teamB);
        

        // Register observers
        game.registerObserver(Announcer);
        game.registerObserver(Game1);
        
        game.registerObserver(NewspaperTitle);

        // Set quarter end based on user input// simulates real time because user is passing time and program is not excuting until right input is entered
        
        System.out.println("Enter the end of each quarter: ");
        int quarterEnd = scanner.nextInt();
        game.setQuarterEnd(quarterEnd);

        // Simulate score updates
        game.updateScores();
        Stack<Integer> teamObserverStack = Game1.getEndScore();
        Stack<Integer> gamePredictorStack = Announcer.getPredictScores();
        printTable(teamObserverStack,gamePredictorStack);
        NewspaperTitle.printFinalResults();
        
    }

}

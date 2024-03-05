class FinalReporter implements Observer
// this will be the observer class that prints off who won the game after the 4 rounds are up. 
 {
    private String teamName;
    private String teamName2;
    private int finalResult;
    private int Apoints;  
    private int Bpoints;

    public FinalReporter(String teamName, String teamName2) {
        this.teamName = teamName;
        this.teamName2 = teamName2;
    }

    @Override
    public void update(int Apoints, int Bpoints) {
        //use this to print results in the end 
    	this.Apoints = Apoints;
        this.Bpoints = Bpoints;
    }

    public void printFinalResults() {
        //determine final winner based on the total points
        if (Apoints == Bpoints) {
            finalResult = 0;
        } else if (Apoints > Bpoints) {
            finalResult = 1;
        } else {
            finalResult = 2; 
        }
        
        System.out.println("Extra! Extra! Winner is " + getOutcome(finalResult) +"! What a wonderful Game!");
        System.out.println("Final Results:");
        System.out.println(teamName + ": " + Apoints);
        System.out.println(teamName2 + ": " + Bpoints);
        
    }

    private String getOutcome(int result) {
        switch (result) {
            case 0:
                return " a Tie";
            case 1:
                return teamName;
            case 2:
                return teamName2;
            default:
                return "Invalid Result";
        }
    }
}
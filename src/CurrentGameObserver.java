
//observer who will keep track of the team points for each quarter 


import java.util.Stack;

class CurrentGameObserver implements Observer{
	private String teamName;
	private String teamName2;
	private int currEnd; 
	private Stack<Integer> endScore = new Stack<>(); 
	public CurrentGameObserver(String teamName, String teamName2) {
		this.teamName = teamName;
		this.teamName2 = teamName2;
	
	}
	

	public Stack<Integer> getEndScore() {
        return endScore;
    }

	//
	  @Override
	    public void update(int Apoints, int Bpoints) {
	       
	      
		  System.out.println(teamName + " scored " + Apoints + "s!");
	      System.out.println(teamName2 + "scored " + Bpoints + "s!");
	        
	     // determine based on increments who won the game then update 
            if (Apoints == Bpoints) {
            	currEnd = 0;
            }
            else if (Apoints > Bpoints) {
            	currEnd = 1;
            }
            else {
            	currEnd = 2;
            }
            
            //add curr end to endScore which will keep track of the scores 
            endScore.push(currEnd);
            
            
            //add conditional statement of whoses in the lead with observer who keeps up score 
            //add a line about who is predicted to win
            System.out.println("Game updated: " + currEnd);
	        
	        System.out.println("Current Game so Far ( 0 = tie, 1 = team a won , 2 = team b won): ");
	        //print current scores so far
	        for (Integer item: endScore) {
	        	System.out.print(item + " ");
	        }
	        System.out.println();
	        
	    }

}

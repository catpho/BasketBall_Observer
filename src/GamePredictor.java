import java.util.Random;
import java.util.Stack;

class GamePredictor implements Observer
{
	private String teamName;
	private String teamName2;
	private int predictEnd; 
	private Stack<Integer> predictScores = new Stack<>(); 
	public GamePredictor(String teamName, String teamName2) {
			this.teamName = teamName;
			this.teamName2 = teamName2;

		
		}
	 public Stack<Integer> getPredictScores() {
	        return predictScores;
	    }
//
		  @Override
		    public void update(int Apoints, int Bpoints) {
		      
		      Random random = new Random();
		        
		     // determine based on increments who won the game then update 
	            if (Apoints == Bpoints) {
	            	predictEnd = random.nextInt(3);;
	            }
	            else if (Apoints > Bpoints) {
	            	predictEnd = random.nextInt(2);
	            }
	            else {
	            	predictEnd = random.nextInt(2) * 2;
	            }
	            
	            //add curr end to endScore which will keep track of the scores 
	            predictScores.push(predictEnd);
	            
	            
	            //add conditional statement of whoses in the lead with observer who keeps up score 
	            //add a line about who is predicted to win
	            System.out.println("New prediction: " + predictEnd);
		        
		        System.out.println("Predicted Games so Far ( 0 = tie, 1 = team a won , 2 = team b won): ");
		        //print current scores so far
		        for (Integer item: predictScores) {
		        	System.out.print(item + " ");
		        }
		        System.out.println();
		        
		    }

	}
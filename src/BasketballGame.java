import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random; 

public class BasketballGame implements Subject {
	private int quarterEnd;
	private int Apoints;
	private int Bpoints;



	ArrayList<Observer> observerList;
	
	 
	public void setQuarterEnd(int quarterend) {
		this.quarterEnd = quarterend;
	}
	
	public BasketballGame() {
			observerList = new ArrayList<Observer>();
	  }
		
	  @Override
	  public void registerObserver (Observer o) {
			observerList.add(o);
	   }
	  @Override
	    public void unregisterObserver(Observer o) {
	        observerList.remove(observerList.indexOf(o));
	    }
	 
	    @Override
	    public void notifyObservers()
	    {
	        for (Iterator<Observer> it =
	              observerList.iterator(); it.hasNext();)
	        {
	            Observer o = it.next();
	            o.update(Apoints, Bpoints);
	        }
	    }

	    
	    // Method to simulate updating scores every quarter
	    public void updateScores() {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        for (int quarter = 1; quarter <= 4; quarter++) {
	            //randomizes the scores increment by 0, 2, 4, 6 so it simulates real gameplay or LUCK 
	            int scoreIncrementA = 2 * random.nextInt(4);
	            int scoreIncrementB = 2 * random.nextInt(4);

	            
	         // Simulating a score increase
	            Apoints += scoreIncrementA; 
	            Bpoints += scoreIncrementB;
	        
	            
	            // Notify observers after each score update
	            notifyObservers();
	            
	           

	            if (quarter < 4) {
	                System.out.println("Enter the end of quarter " + quarter + ": ");
	                int userInput = scanner.nextInt();
	                while (userInput != quarterEnd) {
	                    System.out.println("Incorrect quarter end. Please enter the correct end of quarter " + quarter + ": ");
	                    userInput = scanner.nextInt();
	                }
	            }
	        }

	        scanner.close();
	    }
	}


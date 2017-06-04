/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 * --------------------------------
 * Solution by: Kevan M. Sizemore 2013-01-25
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {
    
	public void run() {
		gotoPaper();
		getPaper();
		returnHome();
	}	

	private void gotoPaper() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	private void getPaper() {
		pickBeeper();
	}
	
	private void returnHome() {
		turnAround();
		move();
		move();
		move();
		turnRight();
		move();
		turnRight();
	}
	
	private void turnRight() {
		for (int i=0; i<3; i++) {
			turnLeft();
		}
	}
	
	private void turnAround() {
		for (int i=0; i<2; i++) {
			turnLeft();
		}
	}
	
}

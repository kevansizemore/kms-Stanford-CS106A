/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 * Solution by: Kevan M. Sizemore 2013-01-26
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

    public void run() {
		if (frontIsBlocked() && leftIsBlocked()) {  //resolves scenarios where world is 1x1 grid
			putBeeper();
		}
		if (frontIsClear() && leftIsBlocked()) {  //resolves scenarios where world is 1 row in height
			completeRow();
		}
		if (frontIsBlocked() && leftIsClear()) {  //resolves scenarios where world is 1 column in width
			completeColumn();
		}
		if (frontIsClear() && leftIsClear()) {  //resolves scenarios where world may be a grid of various x,y dimensions
			completeGrid();  
		}
		else {
				//unfortunately, this Karel application cannot resolve 3D puzzles
		}
	}

		private  void completeRow() {
			while (frontIsClear()) {  	//determine if Karel is adjacent to wall prior to executing loop
				putBeeper();
				attemptSimpleMove();
				attemptSimpleMove();	
			}
		}
	
		private void completeColumn() {
			turnLeft();  				//points Karel to the "north" (top) of the column
			while (frontIsClear()) {  	//determine if Karel is adjacent to wall prior to executing loop
				completeRow();
			}
		}

		private void completeGrid() {
			while (frontIsClear() || leftIsClear()) {  	//resolves most of grid, except the top row
				putBeeper();
				attemptGridMove();
				attemptGridMove();
			}
			finishGridTop();
		}
		
		private void attemptSimpleMove() {
			if (frontIsClear()) {  			//prevent Karel from running into walls
				move();
			}
		}

		private void attemptGridMove() { 	//grid movement is based on Karel's state (orientation)
			if (facingNorth()) {
				if (rightIsBlocked()) {
					turnLeft();
				}
				if (leftIsBlocked()) {
					turnRight();
				}
			}
			if (frontIsBlocked() && facingEast()) {
				turnLeft();
			}
			if (frontIsBlocked() && facingWest()) {
				turnRight();
			}
			if (frontIsClear()) {
				move();
			}
		}
		
		private void finishGridTop() {
			if (frontIsBlocked() && leftIsBlocked() && rightIsClear()) {  //resolve top row from top left corner
				turnAround();
				move();
				if (noBeepersPresent()) {
					turnAround();
					move();
					turnRight();
					while (frontIsClear()) {  	//determine if Karel is adjacent to wall prior to executing loop
						if (noBeepersPresent()) {
							putBeeper();
						}
						attemptSimpleMove();
						attemptSimpleMove();
					}
				}
				else {
					turnAround();
					move();
					turnRight();
					move();
					while (frontIsClear()) {  	//determine if Karel is adjacent to wall prior to executing loop

						attemptSimpleMove();
						attemptSimpleMove();
					}
				}
			//glitch in Algorithm for odd numbers of columns...  (sigh)
			turnRight();
			move();
			if (noBeepersPresent()) {
				turnAround();
				move();
				turnRight();
				if (noBeepersPresent()) {
					putBeeper();
				}
			}
			else {
				turnAround();
				move();
				turnRight();
			}
			}
			if (frontIsBlocked() && rightIsBlocked() && leftIsClear()) {  //resolve top row from top right corner
				turnAround();
				move();
				if (noBeepersPresent()) {
					turnAround();
					move();
					turnLeft();
					while (frontIsClear()) {  	//determine if Karel is adjacent to wall prior to executing loop
						if (noBeepersPresent()) {
							putBeeper();
						}
						attemptSimpleMove();
						attemptSimpleMove();
					}
				}
				else {
					turnAround();
					move();
					turnLeft();
					move();
					while (frontIsClear()) {  	//determine if Karel is adjacent to wall prior to executing loop
						if (noBeepersPresent()) {
							putBeeper();
						}
						attemptSimpleMove();
						attemptSimpleMove();
					}
				}
			}
		}
		
}

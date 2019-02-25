/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 * Solution by: Kevan M. Sizemore 2013-01-25
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

    public void run() {
		while (frontIsClear()) {
			repairColumn();
			returnToBottom();
			gotoNextColumn();	
		}
		if (leftIsClear()) {
			repairColumn();
			returnToBottom();
		}
	}

	private void repairColumn() {
		turnLeft();
		while (frontIsClear()) {
			inspectStone();
			move();
		}
		inspectStone();
	}
	
	private void returnToBottom() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
	
	private void gotoNextColumn() {
		for (int i=0; i<4; i++) {
			move();
		}
	}
	
	private void inspectStone() {
		if (noBeepersPresent()) {
			putBeeper();
		}
	}
}

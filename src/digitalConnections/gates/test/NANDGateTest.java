package digitalConnections.gates.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import digitalConnections.ConnectionNode;
import digitalConnections.gates.NANDGate;

class NANDGateTest {

	NANDGate gate;
	ConnectionNode output;
	
	@BeforeEach
	void init(){
		gate = new NANDGate();
		output = new ConnectionNode();
		gate.setOutput(output);
	}
	
	@Test
	void testFalseInput() {
		gate.getInput(0).setState(false);
		gate.getInput(1).setState(false);
		assertTrue(output.getState());
	}
	
	@Test
	void testTrueInput() {
		gate.getInput(0).setState(true);
		gate.getInput(1).setState(true);
		assertFalse(output.getState());
	}
	
	@Test
	void testOneZeroInput() {
		gate.getInput(0).setState(true);
		gate.getInput(1).setState(false);
		assertTrue(output.getState());
	}
	
	@Test
	void testZeroOneInput() {
		gate.getInput(0).setState(false);
		gate.getInput(1).setState(true);
		assertTrue(output.getState());
	}
	
	@Test
	void testManyInputsAllTrue() {
		gate = new NANDGate(500);
		gate.setOutput(output);
		for (int i = 0; i < gate.getNumberOfInputs(); i++) {
			gate.getInput(i).setState(true);
		}
		assertFalse(output.getState());
	}
	
	@Test
	void testManyInputsAllFalse() {
		gate = new NANDGate(500);
		gate.setOutput(output);
		for (int i = 0; i < gate.getNumberOfInputs(); i++) {
			gate.getInput(i).setState(false);
		}
		assertTrue(output.getState());
	}
	
	@Test
	void testManyInputsOneFalse() {
		gate = new NANDGate(500);
		gate.setOutput(output);
		gate.getInput(0).setState(false);
		for (int i = 1; i < gate.getNumberOfInputs(); i++) {
			gate.getInput(i).setState(true);
		}
		assertTrue(output.getState());
	}
	
	@Test
	void testManyInputsOneTrue() {
		gate = new NANDGate(500);
		gate.setOutput(output);
		gate.getInput(0).setState(true);
		for (int i = 1; i < gate.getNumberOfInputs(); i++) {
			gate.getInput(i).setState(false);
		}
		assertTrue(output.getState());
	}

}

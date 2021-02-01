package digitalConnections.gates.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import digitalConnections.ConnectionNode;
import digitalConnections.gates.XORGate;

class XORGateTest {

	XORGate gate;
	ConnectionNode output;
	
	@BeforeEach
	void init(){
		gate = new XORGate();
		output = new ConnectionNode();
		gate.setOutput(output);
	}
	
	@Test
	void testFalseInput() {
		gate.getInput(0).setState(false);
		gate.getInput(1).setState(false);
		assertFalse(output.getState());
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

}

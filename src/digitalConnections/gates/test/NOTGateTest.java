package digitalConnections.gates.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import digitalConnections.ConnectionNode;
import digitalConnections.gates.NOTGate;

class NOTGateTest {

	NOTGate gate;
	ConnectionNode output;
	
	@BeforeEach
	void init() {
		gate = new NOTGate();
		output = new ConnectionNode();
		gate.setOutput(output);
	}
	
	@Test
	void InputOn() {
		gate.getInput().setState(true);
		assertFalse(output.getState());
	}
	
	@Test
	void InputOff() {
		gate.getInput().setState(false);
		assertTrue(output.getState());
	}

}

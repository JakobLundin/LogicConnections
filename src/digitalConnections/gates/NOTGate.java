package digitalConnections.gates;

import digitalConnections.Connection;

public class NOTGate extends Gate {

	public NOTGate() {
		this(1);
	}
	
	public NOTGate(int numberOfInputs) {
		super(1);
		if (numberOfInputs > 1)	System.err.println("Multiple inputs not allowed on NOT Gate. Continuing with 1");
	}
	
	@Override
	void update() {
		boolean state = !(getInput(0).getState());
		if (getOutput() != null) {
			getOutput().setState(state);
		}
	}
	
	public Connection getInput() {
		return getInput(0);
	}

	@Override
	boolean isInInputRange(int i) {
		return i >= 1;
	}

}

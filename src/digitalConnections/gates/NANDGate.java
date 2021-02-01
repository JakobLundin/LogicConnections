package digitalConnections.gates;

import digitalConnections.Connection;

public class NANDGate extends Gate {

	ANDGate andGate;
	NOTGate notGate;
	
	public NANDGate() {
		this(2);
	}
	
	public NANDGate(int numberOfInputs) {
		super(numberOfInputs);
		andGate = new ANDGate(numberOfInputs);
		notGate = new NOTGate();
		andGate.setOutput(notGate.getInput());
		
		for (int i = 0; i < numberOfInputs; i++) {
			getInput(i).addConnection(andGate.getInput(i));
		}
	}
	
	
	
	@Override
	public void update() {
	}
	
	@Override
	public void setOutput(Connection output) {
		super.setOutput(output);
		notGate.setOutput(output);
	}

	@Override
	boolean isInInputRange(int i) {
		return i >= 2;
	}

}

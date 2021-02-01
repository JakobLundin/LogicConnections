package digitalConnections.gates;

import digitalConnections.Connection;

public class NORGate extends Gate {

	ORGate orGate;
	NOTGate notGate;
	
	public NORGate() {
		this(2);
	}
	
	public NORGate(int numberOfInputs) {
		super(numberOfInputs);
		orGate = new ORGate(numberOfInputs);
		notGate = new NOTGate();
		orGate.setOutput(notGate.getInput());
		
		for (int i = 0; i < numberOfInputs; i++) {
			getInput(i).addConnection(orGate.getInput(i));
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

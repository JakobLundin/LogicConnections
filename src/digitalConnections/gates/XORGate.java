package digitalConnections.gates;

import digitalConnections.Connection;

public class XORGate extends Gate{

	ANDGate andGate;
	ORGate orGate;
	NANDGate nandGate;
	
	public XORGate() {
		this(2);
	}
	
	public XORGate(int numberOfInputs) {
	
		andGate = new ANDGate();
		orGate = new ORGate();
		nandGate = new NANDGate();
		
		getInput(0).addConnection(nandGate.getInput(0));
		getInput(0).addConnection(orGate.getInput(0));
		getInput(1).addConnection(nandGate.getInput(1));
		getInput(1).addConnection(orGate.getInput(1));
		nandGate.setOutput(andGate.getInput(0));
		orGate.setOutput(andGate.getInput(1));
		
		
	}
	
	
	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean isInInputRange(int i) {
		return i == 2;
	}
	
	@Override
	public void setOutput(Connection output) {
		super.setOutput(output);
		andGate.setOutput(output);
	}
	
}

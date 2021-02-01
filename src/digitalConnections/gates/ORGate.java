package digitalConnections.gates;

public class ORGate extends Gate{
	
	public ORGate() {
		this(2);
	}
	
	public ORGate(int numberOfInputs) {
		super(numberOfInputs);
	}

	@Override
	void update() {
		boolean state = false;
		for (int i = 0; i < getNumberOfInputs(); i++) {
			if (getInput(i).getState()) {
				state = true;
				break;
			}
		}
		if (getOutput() != null) {
			getOutput().setState(state);
		}
	}

	@Override
	boolean isInInputRange(int i) {
		return i >= 2;
	}
}

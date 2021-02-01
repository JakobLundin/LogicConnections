package digitalConnections.gates;

public class ANDGate extends Gate {

	public ANDGate() {
		this(2);
	}
	
	public ANDGate(int numberOfInputs) {
		super(numberOfInputs);
	}

	@Override
	void update() {
		boolean state = true;
		for (int i = 0; i < getNumberOfInputs(); i++) {
			if (!(getInput(i).getState())) {
				state = false;
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

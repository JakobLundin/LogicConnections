package digitalConnections.gates;

import java.util.ArrayList;
import java.util.List;

import digitalConnections.Connection;
import digitalConnections.ConnectionNode;

public abstract class Gate {
	
	private List<ConnectionNode> inputs;
	private Connection output;
	
	public Gate() {
		this(2);
	}
	
	
	public Gate(int numberOfInputs) {
		if (!isInInputRange(numberOfInputs)) throw new IllegalStateException( numberOfInputs + " is an invalid number of inputs for" + this.getClass());
		inputs = new ArrayList<ConnectionNode>();
		for (int i = 0; i < numberOfInputs; i++) {
			inputs.add(new GateInput());
		}
		update();
	}
	
	public int getNumberOfInputs() {
		return inputs.size();
	}
	
	public ConnectionNode getInput(int i) {
		return inputs.get(i);
	}
	
	public void setOutput(Connection output) {
		this.output = output;
		update();
	}
	
	public Connection getOutput() {
		return output;
	}
	
	abstract boolean isInInputRange(int i);
	
	abstract void update();
	
	private class GateInput extends ConnectionNode {
		
		@Override
		public void setState(boolean b) {
			if (b != getState()) {
				super.setState(b);
				update();
			}
		}		
	}
	
}

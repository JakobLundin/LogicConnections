package digitalConnections;

import java.util.ArrayList;
import java.util.List;

public class ConnectionNode implements Connection{
	private List<Connection> connections;
	private boolean state;
	
	
	public ConnectionNode() {
		connections = new ArrayList();
		state = false;
	}
	
	public void addConnection(Connection conn){
		connections.add(conn);
	}
	
	public void setState(boolean b) {
		if (b != state) {
			state = b;
			for (Connection conn : connections) {
				conn.setState(b);
			}
		}
	}

	@Override
	public boolean getState() {
		return state;
	}
}

package mdl;

import java.util.*;

public class RequestQueue {

	private int elevatorNumber;
	//HashMap floor -> (type -> request)
	public HashMap<Integer,HashMap<Integer, Request>> requestUpQ;
	public HashMap<Integer,HashMap<Integer, Request>> requestDownQ;

	
	public RequestQueue(int elevatorNumber){
		this.elevatorNumber = elevatorNumber;
		this.requestDownQ = new HashMap<Integer,HashMap<Integer, Request>>();
		this.requestUpQ = new HashMap<Integer,HashMap<Integer, Request>>();
	}
	
	public int getElevatorNumber(){
		return this.elevatorNumber;
	}
}

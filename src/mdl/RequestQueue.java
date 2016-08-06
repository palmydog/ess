package mdl;

import java.util.*;

public class RequestQueue {

	private int elevatorNumber;
	public List<Request> requestUpQ;
	public List<Request> requestDownQ;
	
	public RequestQueue(int elevatorNumber){
		this.elevatorNumber = elevatorNumber;
		this.requestUpQ = new ArrayList<Request>();
		this.requestDownQ = new ArrayList<Request>();
	}
	
	public int getElevatorNumber(){
		return this.elevatorNumber;
	}
}

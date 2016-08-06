package mdl;

public class InnerRequest extends Request{

	public InnerRequest(int elevatorNumber, int currentFloor, int targetFloor){
		this.elevatorNumber = elevatorNumber;
		this.floorOfRequest = currentFloor;
		this.floorOfDestination = targetFloor;
		this.requestType = State.REQINNER;
	}
}

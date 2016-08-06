package mdl;

public class OuterRequest extends Request{

	public OuterRequest(int currentFloor, int direction){
		this.floorOfRequest = currentFloor;
		this.floorOfDestination = currentFloor;
		this.requestType = State.REQOUTER;
		this.direction = direction;
	}
}

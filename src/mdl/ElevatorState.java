package mdl;

public class ElevatorState {
	//The number of the elevator, e.g. no.1 or no.2 or more
	private int number;
	//Which floor does this elevator in? positive int.
	private int floor;
	//0 means idle, 1 means running up, -1 means running down.
	private int movement;
	//normal or emergency?
	private int operating;

}

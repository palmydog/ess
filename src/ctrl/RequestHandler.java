package ctrl;

import java.util.*;
import mdl.*;

/**
 * When a request comes, 
 * it will decide how to handle this request, 
 * e.g. which elevator should response.
 * @author asun36
 *
 */
public class RequestHandler {
	//private List<List<Request>> requestQueue;
	private HashMap<Integer, RequestQueue> requestMap;
	private HashMap<Integer, ElevatorState> elestate;
	
	public RequestHandler(HashMap<Integer, RequestQueue> requestMap, HashMap<Integer, ElevatorState> elestate){
		this.requestMap = requestMap;
		this.elestate = elestate;
	}

	public int addRequest(Request request){
		if((Integer)request.elevatorNumber == null || request.elevatorNumber == 0){
			//It is an outer request, needs to find an elevator to accept this request
		}
		else{
			insertRequest(request);
		}
		return 0;
	}
	
	//Remove a request from the end of the queue.
	//e.g. when the elevator arrives, the request should be popped out.
	public int popRequest(){
		return 0;
	}
	
	
	private void findElevatorToResponse(Request request){
		int currentFloor;
	}
	

	private void insertRequest(Request request){
		//insert request will get the exact elevator to response.
		int eleNo = request.elevatorNumber;
		RequestQueue req = requestMap.get((Integer)eleNo);
		List<Request> reqq;
		if(request.direction == State.DIRECTIONDOWN){
			reqq = req.requestDownQ;
		}
		else if(request.direction == State.DIRECTIONUP){
			reqq = req.requestUpQ;
		}
		else{
			return;//Exception Happened.
		}
		//Insert the request inside.
		for(int i = 0; i <= reqq.size() ; i ++){
			//Already approaches the end of the queue, add the request directly.
			if(i == reqq.size()){
				reqq.add(request);
				return;
			}
			//Compare the destination
			if(request.floorOfDestination > reqq.get(i).floorOfDestination){
				continue;
			}
			else if(request.floorOfDestination == reqq.get(i).floorOfDestination){
				//Exactly the same request, ignore this request.
				if(request.requestType == reqq.get(i).requestType){
					return;
				}
				else{
					continue;
				}
			}
			else{
				reqq.add(i, request);
				return;
			}
		}
	}
	
}

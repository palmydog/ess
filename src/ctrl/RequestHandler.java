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
	//elenum -> requeue
	private HashMap<Integer, RequestQueue> requestMap;
	
	public RequestHandler(HashMap<Integer, RequestQueue> requestMap){
		this.requestMap = requestMap;
		//this.elestate = elestate;
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
		HashMap<Integer,HashMap<Integer,Request>> reqq;
		if(request.direction == State.DIRECTIONDOWN){
			reqq = req.requestDownQ;
		}
		else if(request.direction == State.DIRECTIONUP){
			reqq = req.requestUpQ;
		}
		else{
			return;//Exception Happened.
		}
		//Totally new request, add it.
		if(!reqq.containsKey(request.floorOfDestination)){
			HashMap<Integer,Request> typeq = new HashMap<Integer,Request>();
			typeq.put(request.requestType, request);
			reqq.put(request.floorOfDestination, typeq);
			return;
		}
		else{
			HashMap<Integer,Request> typeq = reqq.get(request.floorOfDestination);
			if(!typeq.containsKey(request.requestType)){
				typeq.put(request.requestType, request);
				return;
			}
			else{
				return;
			}
		}
		//Insert the request inside.
		
	}
	
}

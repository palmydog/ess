package tst;

import mdl.*;
import java.util.*;
import java.util.Map.Entry;

public class TstUtil {
	
	public static void printQueue(List<Request> reqq){
		String reqstr = "queue is: ";
		for(int i = 0 ; i < reqq.size() ; i ++){
			String re = "desc: " + reqq.get(i).floorOfDestination + "; dir: " 
						+ reqq.get(i).direction + "; type: " + reqq.get(i).requestType;
			reqstr += re + " |---| ";
		}
		System.out.println(reqstr);
	}
	
	public static void printHashMapQ(HashMap<Integer, HashMap<Integer,Request>> hmq){
		Iterator<Entry<Integer, HashMap<Integer, Request>>> itr = hmq.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Integer, HashMap<Integer,Request>> entry = (Map.Entry<Integer, HashMap<Integer,Request>>)itr.next();
			Integer flr = entry.getKey();
			HashMap<Integer,Request> tpr = entry.getValue();
			System.out.println("-----Desc Floor: "+flr+" -------------------");
			if(tpr.containsKey(State.REQINNER)){
				Request rq = tpr.get(State.REQINNER);
				String re = "T: "+rq.requestType+" ; Drct: "+rq.direction+" ; Desc: "+rq.floorOfDestination;
				System.out.println(re);
			}
			if(tpr.containsKey(State.REQOUTER)){
				Request rq = tpr.get(State.REQOUTER);
				String re = "T: "+rq.requestType+" ; Drct: "+rq.direction+" ; Desc: "+rq.floorOfDestination;
				System.out.println(re);
			}
		}
	}

}

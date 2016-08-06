package tst;

import mdl.*;
import java.util.*;

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

}

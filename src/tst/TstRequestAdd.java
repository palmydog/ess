package tst;

import mdl.*;
import ctrl.*;
import java.util.*;

public class TstRequestAdd {
	
	public static void main(String[] args){
		TstRequestAdd tst = new TstRequestAdd();
		tst.tstInsertReq();
	}
	
	public void tstInsertReq(){
		int eleNum = 1;
		
		RequestQueue rq = new RequestQueue(eleNum);
		HashMap<Integer, RequestQueue> hm = new HashMap<Integer, RequestQueue>();
		hm.put(eleNum, rq);
		RequestHandler reqh = new RequestHandler(hm);
		
		//TstUtil.printQueue(rq.requestDownQ);
		//TstUtil.printQueue(rq.requestUpQ);
		
		//In: Up: 10
		Request r = new InnerRequest(eleNum, 1, 10);
		r.direction = 1;
		reqh.addRequest(r);
		
		//In: Down: 9
		r = new InnerRequest(eleNum, 1, 9);
		r.direction = -1;
		reqh.addRequest(r);
		
		//In: Down: 9
		r = new InnerRequest(eleNum, 1, 9);
		r.direction = -1;
		reqh.addRequest(r);
		
		//In: Up: 9
		r = new InnerRequest(eleNum, 1, 9);
		r.direction = 1;
		reqh.addRequest(r);
		
		//In: Up: 18
		r = new InnerRequest(eleNum, 1, 18);
		r.direction = 1;
		reqh.addRequest(r);
		
		//O: Up: 9
		r = new OuterRequest(9, 1);
		r.elevatorNumber = eleNum;
		//r.direction = 1;
		reqh.addRequest(r);
		
		//O: Up: 15
		r = new OuterRequest(15,1);
		r.elevatorNumber = eleNum;
		//r.direction = 1;
		reqh.addRequest(r);
		
		//In: Up: 5
		r = new InnerRequest(eleNum, 1, 5);
		r.direction = 1;
		reqh.addRequest(r);
		
		//Summary:
		/*
		 * Inner: 
		 * 		Up: 10, 9, 18, 5
		 * 		Do: 9, 9
		 * Outer:
		 * 		Up: 9, 15
		 * 
		 * */
		System.out.println("||||||||||||Down Q||||||||||||");
		TstUtil.printHashMapQ(rq.requestDownQ);
		System.out.println("|||||||||||Up Q|||||||||||||||");
		TstUtil.printHashMapQ(rq.requestUpQ);
	}
}

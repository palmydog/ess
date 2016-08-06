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
		RequestHandler reqh = new RequestHandler(hm, null);
		
		//TstUtil.printQueue(rq.requestDownQ);
		//TstUtil.printQueue(rq.requestUpQ);
		
		Request r = new InnerRequest(eleNum, 1, 10);
		r.direction = 1;
		reqh.addRequest(r);
		
		r = new InnerRequest(eleNum, 1, 9);
		r.direction = -1;
		reqh.addRequest(r);
		
		r = new InnerRequest(eleNum, 1, 9);
		r.direction = -1;
		reqh.addRequest(r);
		
		r = new InnerRequest(eleNum, 1, 9);
		r.direction = 1;
		reqh.addRequest(r);
		
		r = new InnerRequest(eleNum, 1, 18);
		r.direction = 1;
		reqh.addRequest(r);
		
		r = new OuterRequest(9, 1);
		r.elevatorNumber = eleNum;
		//r.direction = 1;
		reqh.addRequest(r);
		
		r = new OuterRequest(15,1);
		r.elevatorNumber = eleNum;
		//r.direction = 1;
		reqh.addRequest(r);
		
		r = new InnerRequest(eleNum, 1, 5);
		r.direction = 1;
		reqh.addRequest(r);
		
		TstUtil.printQueue(rq.requestDownQ);
		TstUtil.printQueue(rq.requestUpQ);
	}
}

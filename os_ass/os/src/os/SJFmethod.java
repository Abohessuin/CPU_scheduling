package os;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SJFmethod {
      
	
	private ArrayList<process>processes;
    
	public SJFmethod(ArrayList<process> processes) {
		this.processes = processes;
	}


	public Map< Integer, Integer> FinishTime() {
		Map< Integer, Integer> finishtime=new HashMap<Integer, Integer>();
		   ArrayList<process>pp=new ArrayList<process>();
		   for(int i=0;i<processes.size();++i) {
			   pp.add(processes.get(i));
		   }
		    SJFsorting sf=new SJFsorting();
		    process currp=new process();
		    int n;
		    currp=pp.get(0);
		    finishtime.put(currp.getId(),currp.getBurstTime());
		    n=currp.getBurstTime();
		   pp.remove(0);
		    ArrayList<process>pro=sf.sortbs(pp);
		   for(int i=0;i<pro.size();++i) {
			currp=pro.get(i);
	    	finishtime.put(currp.getId(),currp.getBurstTime()+n);
	    	n=currp.getBurstTime()+n;
	    }
		return finishtime;
	}


	public ArrayList<Integer> turnRound(ArrayList<Integer> finish) {
		ArrayList<Integer>turnround=new ArrayList<Integer>();
		for(int i=0;i<this.processes.size();++i) {
			turnround.add(finish.get(i)-this.processes.get(i).getArrivalTime());
		}
		return turnround;
	}

	public ArrayList<Integer> waitingTime(ArrayList<Integer> turn) {
		ArrayList<Integer>waiting=new ArrayList<Integer>();
		for(int i=0;i<this.processes.size();++i) {
			waiting.add(turn.get(i)-this.processes.get(i).getBurstTime());
		}
	     
		return waiting; 
	}

	
	


	
	public ArrayList<Integer> AvarageTime (ArrayList<Integer> turn,ArrayList<Integer> wait) {
		ArrayList<Integer>arr=new ArrayList<Integer>();
		int av1,av2,sum=0,sum2=0;
		for(int i=0;i<turn.size();++i) {
			sum+=turn.get(i);
		}
		av1=sum/turn.size();
		for(int i=0;i<wait.size();++i) {
			sum2+=wait.get(i);
		}
		av2=sum2/wait.size();
		arr.add(av1);
		arr.add(av2);
		return arr;
		
		
	}


	

}

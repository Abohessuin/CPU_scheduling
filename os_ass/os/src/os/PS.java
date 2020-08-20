package os;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PS{
	 private ArrayList<process>processes;
     
	
	 public PS(ArrayList<process> processes) {
		this.processes = processes;
	}


	 public Map<Integer,Integer> FinishTime() {
			Prioritysorting p=new Prioritysorting();
			ArrayList<process>processess=new ArrayList<process>();
			for(int i=0;i<processes.size();++i) {
				processess.add(processes.get(i));
			}
			Map <Integer, Integer>f=new HashMap<Integer, Integer>();
			ArrayList<Integer>x=new ArrayList<Integer>();
			int time=5,finishTime,complete=0;
			for(int i=0;i<processess.size();++i) {
				if(processess.get(i).getArrivalTime()==0) {
					f.put(processess.get(i).getId(),processess.get(i).getArrivalTime()+processess.get(i).getBurstTime());
					x.add(processess.get(i).getBurstTime());
					processess.remove(i);
					break;
				
				}
			}
			
		/*	while(time<=x.get(0)) {
				for(int i=0;i<processess.size();++i) {
					if(processess.get(i).getArrivalTime()<time) {
						processess.get(i).setPriority(processess.get(i).getPriority()-1);
					}
					time+=5;
				}
			}
	
			*/
			int j=1;
			int u;
			while(processess.size()!=0) {
				processess=p.sort(processess);
				processess.get(0);
				u=x.get(j-1)+processess.get(0).getBurstTime();
				x.add(x.get(j-1)+processess.get(0).getBurstTime());
				f.put(processess.get(0).getId(),x.get(j-1)+processess.get(0).getBurstTime());
				processess.remove(0);
				j++;
			}
			/*	while(time<=x.get(j)) {
					for(int i=0;i<processess.size();++i) {
						if(processess.get(i).getArrivalTime()<=time) {
							processess.get(i).setPriority(processess.get(i).getPriority()-1);
						}
						time+=5;
					}
				}
				j++;
			}
			*/
		
			return f;
			
			
			
		}
		 
		 
		
		

	public ArrayList<Integer> turnRound(ArrayList<Integer> finish) {
		SJFsorting s=new SJFsorting();
		this.processes=s.sort(processes);
		ArrayList<Integer>turnround=new ArrayList<Integer>();
		for(int i=0;i<this.processes.size();++i) {
			turnround.add(finish.get(i)-this.processes.get(i).getArrivalTime());
		}
		return turnround;
	}


	public ArrayList<Integer> waitingTime(ArrayList<Integer> turn) {
		SJFsorting s=new SJFsorting();
		this.processes=s.sort(processes);
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

package os;

import java.util.ArrayList;

public class SRTFmethod {

	private ArrayList<process>processes;

	public SRTFmethod(ArrayList<process> processes) {
		super();
		this.processes = processes;
	}


	public ArrayList<Integer> FinishTime() {

		int n=processes.size();	
		int rt[] = new int[n]; 
		int complete=0,t=0,minm=Integer.MAX_VALUE,shortest=0,finish_time;
		boolean check=false;
		int []finishesTimeProcess=new int [n];
		ArrayList<Integer>finishtimes=new ArrayList<Integer>();
		for(int i=0;i<n;++i) {
			rt[i] = processes.get(i).getBurstTime(); 
		}
		int u=0,r=0;
		while (complete != n) { 

			r=0;
			for (int j = 0; j < n; j++)  
			{ 
				if ((processes.get(j).getArrivalTime()<= t) && 
						(rt[j] < minm) && rt[j] > 0) {
			
					if(u!=0&&r==0) {
					t++;
					r++;
					
					}
					minm = rt[j]; 
					shortest = j; 
					check = true; 
					u++;
				} 
			}
			

			if (check == false) { 
				t++; 
				continue; 
			} 
			rt[shortest]--; 
			minm = rt[shortest]; 
			if (minm == 0) 
				minm = Integer.MAX_VALUE; 

			if (rt[shortest] == 0) { 

				complete++; 
				check = false;
				finish_time = t + 2;
				finishesTimeProcess[shortest]=finish_time;
				


			}
			t++;
		}
		for(int i=0;i<n;++i) {
			finishtimes.add(finishesTimeProcess[i]);
			
		}
		return finishtimes;
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

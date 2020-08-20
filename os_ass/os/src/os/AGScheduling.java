package os;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AGScheduling {


	private ArrayList<process>processes;

	public AGScheduling(ArrayList<process> processes) {
		this.processes = processes;
	}


	public ArrayList<Integer> FinishTime() {
		int [] AG=new int[processes.size()];
		int []BS=new int[processes.size()];
		int []HQP=new int[processes.size()];
		int []finishesTimeProcess=new int [processes.size()];
		ArrayList<process> waitingProcesse = new ArrayList<process>(); 
		int complete=0,time=0,shortest=0,finish_time,diff = 0,pBeginTime,restq,oldshortest=0;
		process p=new process();
		boolean check=false,check2=false,check3=false,check4=false;;
		for(int i=0;i<processes.size();++i) {
			BS[i] = processes.get(i).getBurstTime(); 
		}

		for(int i=0;i<processes.size();++i) {
			AG[i] = processes.get(i).getBurstTime()+processes.get(i).getArrivalTime()+processes.get(i).getPriority(); 
		}
		for(int i=0;i<processes.size();++i) {
			HQP[i] =(int) Math.ceil (processes.get(i).getQuantum()*0.5); 
		}
		int minn=AG[0];
		int oldprocessf=0; 
		shortest=0;
		int k,summ;
		while(complete!=processes.size()) {

			check=false;
			check2=false;
			check3=false;
			for (int j = 0; j < processes.size(); j++)  { 
				if (processes.get(j).getArrivalTime()<= time&&shortest!=j){
					for(int k1=0;k1<waitingProcesse.size();++k1) {
						if(waitingProcesse.get(k1).getArrivalTime()==processes.get(j).getArrivalTime()) {
							check4=true;
						}
					}
					if(check4==false&&BS[j]!=0) {
						waitingProcesse.add(processes.get(j));
					}
				}
				check4=false;
			}

			diff=time-oldprocessf;
			if(diff>=HQP[shortest]) { //check about half quantuam intruppt;
				check=true;
				oldshortest=shortest;
				for (int j = 0; j < processes.size(); j++)  { 
					if ((processes.get(j).getArrivalTime()<= time) && 
							(AG[j] < minn) && BS[j] >0 ) {
						check2=true;
						shortest = j;
						minn=AG[j];
						oldprocessf=time;

					} 
				}
				int sum;
				for(int j=0;j<waitingProcesse.size();++j) {
					sum=waitingProcesse.get(j).getArrivalTime()+waitingProcesse.get(j).getBurstTime()+waitingProcesse.get(j).getPriority();
					if(sum==AG[shortest])
					{
						waitingProcesse.remove(j);
					}
				
				}
				if(check2) {
					restq=processes.get(oldshortest).getQuantum()-diff;
					processes.get(oldshortest).setQuantum( processes.get(oldshortest).getQuantum()+restq);
					if(BS[oldshortest]!=0) {
						waitingProcesse.add(processes.get(oldshortest));
					}
					for(int i=0;i<processes.size();++i) {
						HQP[i] =(int) Math.ceil (processes.get(i).getQuantum()*0.5); 
					}
				}
			} 
			if(diff==processes.get(shortest).getQuantum()&&check) {  //check it take all quant
				oldshortest=shortest;
				for (int j = 0; j < processes.size()&&waitingProcesse.size()!=0; j++)  { 
					if(processes.get(j).getArrivalTime()== waitingProcesse.get(0).getArrivalTime()){
						waitingProcesse.remove(0);
						shortest = j; 
						minn=AG[j];
						oldprocessf=time;
						check2=true;
						break;


					} 
				}
				if(check2) {

					processes.get(oldshortest).setQuantum( processes.get(oldshortest).getQuantum()+1);
					waitingProcesse.add(processes.get(oldshortest));
					for(int i=0;i<processes.size();++i) {
						HQP[i] =(int) Math.ceil (processes.get(i).getQuantum()*0.5); 
					}
				}
			}

			BS[shortest]--;
			time++;
			if(BS[shortest]==0) {
				complete++;
				minn=Integer.MAX_VALUE;
				finishesTimeProcess[shortest]=time;
				oldshortest=shortest;
				for (int j = 0; j < processes.size()&&waitingProcesse.size()!=0; j++)  { 
					if(processes.get(j).getArrivalTime()== waitingProcesse.get(0).getArrivalTime()){
						waitingProcesse.remove(0);
						shortest = j; 
						minn=AG[j];
						oldprocessf=time;
						check2=true;
						break;


					} 
				}
				if(check2) {

					processes.get(oldshortest).setQuantum(0);
					for(int i=0;i<processes.size();++i) {
						HQP[i] =(int) Math.ceil (processes.get(i).getQuantum()*0.5); 
					}
				}
			} 
		}


		ArrayList<Integer>x=new ArrayList<Integer>();
		for(int i=0;i<processes.size();++i) {
			x.add(finishesTimeProcess[i]);
		}
		return x;
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

package os;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner x;
		ArrayList<process> v = new ArrayList<process>();
		process p;
		Map<Integer, Integer> fn;
		ArrayList<Integer> fnn;
		ArrayList<Integer> ftn = new ArrayList<Integer>();
		ArrayList<Integer> id = new ArrayList<Integer>();
		ArrayList<Integer> wt;
		ArrayList<Integer> tr;
		ArrayList<Integer> av;
		int a, b, c, d, e,f;
		System.out.println("SJF press 1");
		System.out.println("SRTF press 2");
		System.out.println("piorty press 3");
		System.out.println("AGsheduling press 4");
		x = new Scanner(System.in);
		a = x.nextInt();
		switch (a) {
		case 1: {
			System.out.println("enter number of process");
			x = new Scanner(System.in);
			a = x.nextInt();
			for (int i = 0; i < a; ++i) {
				System.out.println("enter process id");
				x = new Scanner(System.in);
				b = x.nextInt();
				System.out.println("enter process arrive time");
				x = new Scanner(System.in);
				c = x.nextInt();
				System.out.println("enter process burst time");
				x = new Scanner(System.in);
				d = x.nextInt();
				p = new process(b, c, d);
				v.add(p);

			}

			SJFsorting alg = new SJFsorting();
			ArrayList<process> pro = alg.sort(v);
			SJFmethod sjf = new SJFmethod(pro);
			fn = sjf.FinishTime();
			System.out.println("process finish time");
			for (Entry<Integer, Integer> entry : fn.entrySet()) {
				System.out.println("process " + entry.getKey() + ":" + entry.getValue());
			}

			for (Entry<Integer, Integer> entry : fn.entrySet()) {
				ftn.add(entry.getValue());
				id.add(entry.getKey());
			}

			System.out.println("process turn round time");
			tr = sjf.turnRound(ftn);
			for (int i = 0; i < tr.size(); ++i) {
				System.out.println("process " + id.get(i) + ":" + tr.get(i));
			}

			System.out.println("process waiting time");
			wt = sjf.waitingTime(tr);
			for (int i = 0; i < wt.size(); ++i) {
				System.out.println("process " + id.get(i) + ":" + wt.get(i));
			}

			System.out.println("process avarage time");
			av = sjf.AvarageTime(tr, wt);
			for (int i = 0; i < av.size(); ++i) {
				System.out.println(av.get(i));
			}

		}
			break;
		case 2: {
			
			SRTFmethod srtf = new SRTFmethod(v);
			fnn = srtf.FinishTime();
			System.out.println("process finish time");
			for (int i = 0; i < fnn.size(); ++i) {
				System.out.println("process " + v.get(i).getId() + ":" + fnn.get(i));
			}

			System.out.println("process turn round time");
			tr = srtf.turnRound(fnn);
			for (int i = 0; i < tr.size(); ++i) {
				System.out.println("process " + v.get(i).getId()+ ":" + tr.get(i));
			}

			System.out.println("process waiting time");
			wt = srtf.waitingTime(tr);
			for (int i = 0; i < wt.size(); ++i) {
				System.out.println("process " + v.get(i).getId() + ":" + wt.get(i));
			}

			System.out.println("process avarage time");
			av = srtf.AvarageTime(tr, wt);
			for (int i = 0; i < av.size(); ++i) {
				System.out.println(av.get(i));
			}

		}
			break;
		case 3: {
			System.out.println("enter number of process");
			x = new Scanner(System.in);
			a = x.nextInt();
			for (int i = 0; i < a; ++i) {
				System.out.println("enter process id");
				x = new Scanner(System.in);
				b = x.nextInt();
				System.out.println("enter process arrive time");
				x = new Scanner(System.in);
				c = x.nextInt();
				System.out.println("enter process burst time");
				x = new Scanner(System.in);
				d = x.nextInt();
				System.out.println("enter process paiorty time");
				x = new Scanner(System.in);
				e = x.nextInt();
				p = new process(b, c, d, e);
		    		v.add(p);
        
			}
			Prioritysorting alg = new Prioritysorting();
			ArrayList<process> pro = alg.sort(v);
			PS ps = new PS(pro);
			fn = ps.FinishTime();
			System.out.println("process finish time");
			for (Entry<Integer, Integer> entry : fn.entrySet()) {
				System.out.println("process " + entry.getKey() + ":" + entry.getValue());
			}

			for (Entry<Integer, Integer> entry : fn.entrySet()) {
				ftn.add(entry.getValue());
				id.add(entry.getKey());
			}

			System.out.println("process turn round time");
			tr = ps.turnRound(ftn);
			for (int i = 0; i < tr.size(); ++i) {
				System.out.println("process " + id.get(i) + ":" + tr.get(i));
			}

			System.out.println("process waiting time");
			wt = ps.waitingTime(tr);
			for (int i = 0; i < wt.size(); ++i) {
				System.out.println("process " + id.get(i) + ":" + wt.get(i));
			}

			System.out.println("process avarage time");
			av = ps.AvarageTime(tr, wt);
			for (int i = 0; i < av.size(); ++i) {
				System.out.println(av.get(i));
			}

		}
		
		break;
		case 4:{
			System.out.println("enter number of process");
			x = new Scanner(System.in);
			a = x.nextInt();
			for (int i = 0; i < a; ++i) {
				System.out.println("enter process id");
				x = new Scanner(System.in);
				b = x.nextInt();
				System.out.println("enter process arrive time");
				x = new Scanner(System.in);
				c = x.nextInt();
				System.out.println("enter process burst time");
				x = new Scanner(System.in);
				d = x.nextInt();
				System.out.println("enter process paiorty time");
				x = new Scanner(System.in);
				e = x.nextInt();
				System.out.println("enter process quantum time");
				x = new Scanner(System.in);
				f = x.nextInt();
				p = new process(b, c, d,e,f);
				v.add(p);

			}
			AGScheduling ags = new AGScheduling(v);
			fnn = ags.FinishTime();
			System.out.println("process finish time");
			for (int i = 0; i < fnn.size(); ++i) {
				System.out.println("process " + v.get(i).getId() + ":" + fnn.get(i));
			}

			System.out.println("process turn round time");
			tr = ags.turnRound(fnn);
			for (int i = 0; i < tr.size(); ++i) {
				System.out.println("process " + v.get(i).getId()+ ":" + tr.get(i));
			}

			System.out.println("process waiting time");
			wt = ags.waitingTime(tr);
			for (int i = 0; i < wt.size(); ++i) {
				System.out.println("process " + v.get(i).getId() + ":" + wt.get(i));
			}

			System.out.println("process avarage time");
			av = ags.AvarageTime(tr, wt);
			for (int i = 0; i < av.size(); ++i) {
				System.out.println(av.get(i));
			}
			
		}
		}

	}
}

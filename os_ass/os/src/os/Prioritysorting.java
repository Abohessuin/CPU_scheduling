package os;

import java.util.ArrayList;
import java.util.Collections;

public class Prioritysorting{

	
	public ArrayList<process> sort(ArrayList<process> x) {
		
		  int i,j,min_ind;
	        for(i=0;i<x.size()-1;++i) {
	        	min_ind=i;
	        	for( j=i+1;j<x.size();++j) {
	        		if(x.get(j).getPriority()<x.get(min_ind).getPriority()) {
	        			min_ind=j;
	        			
	        		}
	        	}
	        		
	        		Collections.swap(x, min_ind, i);
	        	
	        }
			return x;

	}

}

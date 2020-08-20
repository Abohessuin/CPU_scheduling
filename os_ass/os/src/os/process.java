package os;

public class process {
      int Id;
      int arrivalTime;
      int burstTime;
      int Priority; 
      int Quantum;
 
      public process(int id, int arrivalTime, int burstTime, int priority, int quantum) { 
		Id = id;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		Priority = priority;
		Quantum = quantum;
	}

	public int getQuantum() {
		return Quantum;
	}

	public void setQuantum(int quantum) {
		Quantum = quantum;
	}

	public process(int id, int arrivalTime, int burstTime) {
		Id = id;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
	}
      
      public process(int id, int arrivalTime, int burstTime,int Priority ) {
  		Id = id;
  		this.arrivalTime = arrivalTime;
  		this.burstTime = burstTime;
  		this.Priority=Priority;
  	}
      
	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public process() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}
      
      
      
      
      
}

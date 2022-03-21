import java.util.concurrent.TimeUnit;


public class Main {

	
	private static ElevatorCollection elevators = new ElevatorCollection();
	private static RequestCollection requests = new RequestCollection();

	
	 public static void main(String[] args) throws InterruptedException {
		 
		 Request r1 = new Request(1, 0, 52);
		 Request r2 = new Request(2, 0, 12);
		 Request r3 = new Request(3, 0, 42);
		 Request r4 = new Request(4, 0, 45);
		 Request r5 = new Request(5, 24, 0);
		 Request r6 = new Request(6, 0, 45);
		 Request r7 = new Request(7, 7, 25);
		 Request r8 = new Request(8, 17, 34);
		 Request r9 = new Request(9, 0, 1);
		 
		 
		 requests.addRequest(r1);
		 requests.addRequest(r2);
		 requests.addRequest(r3);
		 requests.addRequest(r4);
		 ElevatorCollection.checkAvailableElevators();
		 requests.addRequest(r5);
		 requests.addRequest(r6);
		 requests.addRequest(r7);
		 requests.addRequest(r8);
		 requests.addRequest(r9);
		 
		 
		 		 
		 
	 }
}

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Creates a List containing all requests
public class RequestCollection {

	private final List<Request> requests = new ArrayList<>();
	
	
	public RequestCollection() {
		
	}
	
	//adds a request to the nearest Elevator
	public void addRequest(Request request) throws InterruptedException {
		
		if(request != null ) {
			
			Elevator e = ElevatorCollection.getFreeElevator(request);
			
			System.out.println(request.toString());
			
			System.out.println("Elevator " + e.getElevatorNr() + " current floor: " + e.getCurrFloor() + ", destination: " + e.getDestination() + ", direction: " + e.getDirection(request));
			
			int waittime = Math.abs(request.floorFrom - request.floorTo);
			TimeUnit.SECONDS.sleep(waittime/4);
			
			e.setCurrFloor(e.getDestination());
			e.setOccupied(false);
			System.out.println("Elevator " + e.getElevatorNr() + " done with Request " + request.getRequestNr());
			System.out.println(e.getCurrFloor());
		}
	}
	
	//gets the next Request
	public synchronized Request getNextRequest() {
		if(requests.isEmpty()) { 
			return null;
		} else {
			Request request = requests.get(0);
			requests.remove(request);
			return request;
		}
		
	}
	
	//checks if there are any requests left
	public boolean hasRequest() {
		return !requests.isEmpty();
	}
}

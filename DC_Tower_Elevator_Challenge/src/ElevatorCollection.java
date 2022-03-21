import java.util.ArrayList;
import java.util.List;

//creates a list with all 7 elevators
public class ElevatorCollection {

private final static List<Elevator> elevators = new ArrayList<>();
	
	
	public ElevatorCollection() {
		Elevator e1 = new Elevator(1);
		Elevator e2 = new Elevator(2);
		Elevator e3 = new Elevator(3);
		Elevator e4 = new Elevator(4);
		Elevator e5 = new Elevator(5);
		Elevator e6 = new Elevator(6);
		Elevator e7 = new Elevator(7);
		
		elevators.add(e1);
		elevators.add(e2);
		elevators.add(e3);
		elevators.add(e4);
		elevators.add(e5);
		elevators.add(e6);
		elevators.add(e7);
		
	}
		
	//return if there are elevators in the list
	public synchronized boolean hasElevators() {
		return !elevators.isEmpty();
	}
	
	//returns the closest elevator to the floor where the request has the starting point
	public static Elevator nearestElevator(int floorto) {
		Elevator nearestElevator = null;
		int bestdistance = 55;
		
		List<Elevator> freeElevators =	getAllFreeElevators();
		
		for(Elevator e : freeElevators) {
			int distance = 0;
			int epos = e.getCurrFloor();
			
			distance = Math.abs(floorto - epos);
			
			if(distance < bestdistance) {
				nearestElevator = e;
				bestdistance = distance;
			}
			
		}
		
		return nearestElevator;
	}
	
	//returns the best free elevator for a request
	public static Elevator getFreeElevator(Request request) {
		
		Elevator e = nearestElevator(request.floorTo);
			
		
				e.setOccupied(true);
				e.setOngoingRequest(request);
				//Ausgabe
				return e;
			
		
	}
	
	//returns all free elevators
	public static  List<Elevator> getAllFreeElevators() {
		List<Elevator> freeElevators = new ArrayList<>();
		
		for (Elevator e : elevators) {
			if (!e.isOccupied()) {
				freeElevators.add(e);
			}
		}
		
		return freeElevators;
	}
	
	//returns if any elevators are free
	public synchronized boolean hasFreeElevators() {
		for (Elevator e : elevators) {
			if (!e.isOccupied()) {
				return true;
			}
		}
		
		return false;
	}
	
	//sets the elevator on free
	public synchronized void setElevatorFree(Elevator elevator) {
		elevator.setOccupied(false);
	}
	
	//returns all free Elevators and prints them
	public static void checkAvailableElevators () {
		System.out.println("These Elevators are available: ");
		for (Elevator e : elevators) {
			if(!e.isOccupied()) {
				System.out.println("Elevator" + e.getElevatorNr());
			}
		}
	}
}

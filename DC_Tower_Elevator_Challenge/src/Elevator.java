import java.util.UUID;

//creates an elevator, has all Getters and Setters and toString

public class Elevator {

	private final String elevatorID;
	private int elvatorNr;
	private int currFloor;
	private int destination;
	private boolean occupied;
	private Request ongoingRequest;
	
	
	public Elevator(int elevatorNr) {
		this.elvatorNr = elevatorNr;
		this.elevatorID = UUID.randomUUID().toString();
		this.currFloor = 0;
		this.occupied = false;
	}


	public String getElevatorID() {
		return elevatorID;
	}


	public int getElevatorNr() {
		return elvatorNr;
	}


	public int getCurrFloor() {
		return currFloor;
	}


	public void setCurrFloor(int currFloor) {
		this.currFloor = currFloor;
	}


	public int getDestination() {
		return destination;
	}


	public void setDestination(int destination) {
		this.destination = destination;
	}


	public boolean isOccupied() {
		return occupied;
	}


	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}


	public Request getOngoingRequest() {
		return ongoingRequest;
	}


	public void setOngoingRequest(Request ongoingRequest) {
		if(ongoingRequest !=  null) {
			this.ongoingRequest = ongoingRequest;
			destination = ongoingRequest.getFloorTo();
			currFloor = ongoingRequest.getFloorFrom();
		}
	}

	//returns the direction the Elevator is going for a request
	public String getDirection(Request request) {
		if(request.getFloorFrom() == request.getFloorTo()) {
			return "ALREADY THERE";
		} else {
		if(request.getFloorFrom() > request.getFloorTo()) {
			return "DOWN";
		} else {
			return "UP";
	}
		}
	}


	@Override
	public String toString() {
		return "Elevator [elevatorID=" + elevatorID + ", elvatorNr=" + elvatorNr + ", currFloor=" + currFloor
				+ ", destination=" + destination + ", occupied=" + occupied + ", ongoingRequest=" + ongoingRequest
				+ "]";
	}






	
	
}

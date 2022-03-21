import java.util.UUID;

//creates a Request, has all getters and setters and toString 
public class Request {

	private String RequestID;
	private int RequestNr;
	int floorFrom;
	int floorTo;
	
	
	public Request(int RequestNr, int floorFrom, int floorTo) {
		this.RequestID = UUID.randomUUID().toString();
		this.RequestNr = RequestNr;
		setFloorFrom(floorFrom);
		setFloorTo(floorTo);
	
		
	}

	public int getRequestNr() {
		return RequestNr;
	}


	public void setRequestNr(int requestNr) {
		RequestNr = requestNr;
	}


	public String getRequestID() {
		return RequestID;
	}


	public void setRequestID(String requestID) {
		RequestID = requestID;
	}


	public int getFloorFrom() {
		return floorFrom;
	}


	public void setFloorFrom(int floorFrom) {
		if(0 <= floorFrom && floorFrom <= 55) {
			this.floorFrom = floorFrom;
		} else {
			//error
		}
	}


	public int getFloorTo() {
		return floorTo;
	}


	public void setFloorTo(int floorTo) {
		
		if(0 <= floorFrom && floorFrom <= 55) {
			this.floorTo = floorTo;
		} else {
			//error
		}
	}

	@Override
	public String toString() {
		return "Request [RequestID=" + RequestID + ", RequestNr=" + RequestNr + ", floorFrom=" + floorFrom
				+ ", floorTo=" + floorTo + "]";
	}
	
	

	
}

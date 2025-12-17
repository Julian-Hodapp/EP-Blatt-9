package h2;

public class Bus {
	public Passenger[] passengers;
	
	public Bus() {
		this.passengers = new Passenger[0];
	}
	
	public void enterBus(Passenger p) {
		Passenger[] newPassengerList = passengers.length == 0 ? new Passenger[1] : new Passenger[passengers.length + 1];
		
		if (passengers.length == 0) {
			newPassengerList[0] = p;
		} else {
			for (int i = 0; i < passengers.length; i++) {
				newPassengerList[i] = passengers[i];
			}
			
			newPassengerList[passengers.length] = p;
		}
		
		this.passengers = newPassengerList;
	}
	
	public void exitBus() {
		int exitPassengers = 0;
		//count exit Passengers
		for (int i = 0; i < passengers.length; i++) {
			if(passengers[i].planned == passengers[i].visited) exitPassengers++;
		}
		
		if (exitPassengers > 0) {
			Passenger[] newPassengerList = new Passenger[passengers.length - exitPassengers];
			int currentIndex = 0;
			
			for (int i = 0; i < passengers.length; i++) {
				if (passengers[i].planned != passengers[i].visited) {
					newPassengerList[currentIndex] = passengers[i];
					currentIndex++;
				}
			}
			
			this.passengers = newPassengerList;
		}
	}
	
	public void nextStop(Passenger[] boarding) {
		for (int i = 0; i < passengers.length; i++) {
			passengers[i].visited++;
		}
		
		exitBus();
		
		for (int i = 0; i < boarding.length; i++) {
			enterBus(boarding[i]);
		}
	}
	
	public void nextStop() {
		nextStop(new Passenger[] {});
	}
	
	public Passenger[] findPassengersWithoutTickets() {
		int passengersWithoutTicketNumber = 0;
		//count exit Passengers
		for (int i = 0; i < passengers.length; i++) {
			if(passengers[i].ticket == false) passengersWithoutTicketNumber++;
		}
		
		if (passengersWithoutTicketNumber > 0) {
			Passenger[] newPassengerList = new Passenger[passengers.length - passengersWithoutTicketNumber];
			Passenger[] passengersWithoutTicketList = new Passenger[passengersWithoutTicketNumber];
			int currentIndex = 0;
			int currentPassengerWithoutTicketIndex = 0;
			
			for (int i = 0; i < passengers.length; i++) {
				if (passengers[i].ticket) {
					newPassengerList[currentIndex] = passengers[i];
					currentIndex++;
				} else {
					passengersWithoutTicketList[currentPassengerWithoutTicketIndex] = passengers[i];
					currentPassengerWithoutTicketIndex++;
				}
			}
			
			this.passengers = newPassengerList;
			
			return passengersWithoutTicketList;
		} else {
			return new Passenger[] {};
		}
	}
	
	public void transferPassengers(Bus otherBus, String[] passengerNames) {
		Passenger[] newPassengerList = passengers;
		for (Passenger p: passengers) {
			boolean hasToBeTransfered = false;
			
			for (String pName : passengerNames) {
				if (p.name == pName) hasToBeTransfered = true;
			}
			
			if (hasToBeTransfered) {
				otherBus.enterBus(p);
				
				boolean pfound = false;
				Passenger[] newPassengerListWithoutP = new Passenger[newPassengerList.length - 1];
				
				for (int i = 0; i < newPassengerList.length; i++) {
					if(pfound) {
						newPassengerListWithoutP[i - 1] = newPassengerList[i];
					} else {
						if(newPassengerList[i].name == p.name) {
							pfound = true;
						} else {
							newPassengerListWithoutP[i] = newPassengerList[i];
						}
					}
				}
				
				this.passengers = newPassengerListWithoutP;
			}
		}
	}
	
	public void printAllPassengers() {
		if (passengers == null) {
			System.out.println("null");
		} else {
			System.out.println("Passengers:");
			for (Passenger p : passengers) {
				if (p == null) {
					System.out.println("Error");
				} else {
					System.out.println("name: " + p.name + "; planned: " + p.planned + "; visited: " + p.visited + "; ticket: " + p.ticket);
				}
			}
		}
	}
	
	public void printPassengersListFunction(Passenger[] optional) {
		if (passengers == null) {
			System.out.println("null");
		} else {
			System.out.println("Passengers (without ticket):");
			for (Passenger p : optional) {
				if (p == null) {
					System.out.println("Error");
				} else {
					System.out.println("name: " + p.name + "; planned: " + p.planned + "; visited: " + p.visited + "; ticket: " + p.ticket);
				}
			}
		}
	}
}

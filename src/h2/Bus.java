package h2;

import java.util.ArrayList;

public class Bus {
	public ArrayList<Passenger> passengers;
	
	public Bus() {
		passengers = new ArrayList<>();
	}
	
	public void enterBus(Passenger p) {
		passengers.add(p);
	}
	
	private void exitBus() {
		for(int i = 0; i < passengers.size(); i++) {
			if(passengers.get(i).planned == passengers.get(i).visited) {
				passengers.remove(i);
				i -= 1;
			}	
		}
	}
	
	public void nextStop(Passenger[] boarding) {
		for(int i = 0; i < passengers.size(); i++) {
			passengers.get(i).visited += 1;
		}
		exitBus();
		for(int i = 0; i < boarding.length; i++) {
			passengers.add(boarding[i]);
		}
	}
	
	public void nextStop() {
		for(int i = 0; i < passengers.size(); i++) {
			passengers.get(i).visited += 1;
		}
		exitBus();
	}
	
	public ArrayList<Passenger> findPassengersWithoutTickets() {
		ArrayList<Passenger> rabauken = new ArrayList<>();
		for(int i = 0; i < passengers.size(); i++) {
			if(!passengers.get(i).ticket) {
				rabauken.add(passengers.get(i));
				passengers.remove(i);
				i -= 1;
			}
		}
		return rabauken;
	}
	
	public void transferPassengers(Bus otherBus, String[] passengerNames) {
		for(int i = 0; i < passengers.size(); i++) {
			for(int j = 0; j < passengerNames.length; j++) {
				if(passengers.get(i).name == passengerNames[j]) {
					otherBus.enterBus(passengers.get(i));
					passengers.remove(i);
					i =- 1;
					break;
				}
			}
		}
	}
	
	//@Override
	//public String toString() {
	//    return "Bus passengers: " + passengers;
	//}
}
package h1;

import java.util.ArrayList;

public class PrioListe {
	public ArrayList<Patient> myList = new ArrayList<Patient>();
	
	public void addPatient(Patient p) {
		for(int i = 0; i < myList.size(); i++) {
			if(myList.get(i).prio > p.prio) {
				myList.add(i, p);
				return;
			}
		}
		myList.add(p);
	}
	
	public Patient getNextPatient() {
		Patient nextPatient = myList.getFirst();
		myList.removeFirst();
		return nextPatient;
	}
	
	public int getPosition(Patient p) {
		for(int i = 0; i < myList.size(); i++) {
			if(myList.get(i).prio == p.prio && myList.get(i).name == p.name) {
				return i;
			}
		}
		return -1;
	}
	
	//public void printListe() {
    //    System.out.println(myList);
    //}
}

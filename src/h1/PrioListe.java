package h1;

//patient prio is always diffrent
public class PrioListe {
	public Patient[] myList = {};
	
	public void addPatient(Patient p) {
		Patient[] newList = new Patient[myList.length + 1];
		
		if (myList.length == 0) {
			newList[0] = p;
		} else {
			boolean sorted = false;
			
			for (int i = 0; i < myList.length; i++) {
				if(p.prio > myList[i].prio) {
					newList[i] = myList[i];
				} else if(sorted == false) {
					newList[i] = p;
					
					sorted = true;
				} else {
					newList[i] = myList[i-1];
				}
			}
			
			if (sorted == false) {
				newList[myList.length] = p;
			} else {
				newList[myList.length] = myList[myList.length - 1];
			}
		}
		
		myList = newList;
	}
	
	public Patient getNextPatient() {
		Patient firstPatient = myList.length == 0 ? null : myList[0];
		Patient[] newList = myList.length > 1 ? new Patient[myList.length - 1] : new Patient[0];
		
		if(myList.length >= 2) {
			for (int i = 1; i < myList.length; i++) {
				newList[i-1] = myList[i];
			}
		}
		
		
		myList = newList;
		
		
		
		return firstPatient;
	}
	
	public int getPosition(Patient p) {
		for (int i = 0; i < myList.length; i++) {
			if(myList[i].name == p.name && myList[i].prio == p.prio) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void printProListeToString() {
		for (Patient p : myList) {
			System.out.println("name" + p.name);
			System.out.println("prio" + p.prio);
		}
	}
}

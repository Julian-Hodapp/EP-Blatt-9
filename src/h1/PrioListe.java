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
				if(myList[i].prio > p.prio && sorted == false) {
					newList[i] = p;
					sorted = true;
				} else {
					if (sorted == false) {
						newList[i] = myList[i];
					} else {
						newList[i] = myList[i-1];
					}
				}
			}
			
			if (sorted == false) {
				newList[myList.length] = p;
			}
		}
		
		myList = newList;
	}
	
	public Patient getNextPatient() {
		Patient firstPatient = myList.length > 0 ? myList[0] : null;
		Patient[] newList = myList.length > 1 ? new Patient[myList.length - 1] : new Patient[]{};
		
		if(myList.length < 2) {
			for (int i = 1; i < myList.length; i++) {
				newList[i] = myList[i-1];
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
	
	public String printProListeToString() {
		String string = "[";
		
		for (int i = 0; i < myList.length; i++) {
			string = string + myList[i].name + "," + myList[i].prio + ";";
		}
		
		string = string + "]";
		
		return string;
	}
}

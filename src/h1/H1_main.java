package h1;

public class H1_main {
	public static void main(String[] args) {
		PrioListe list = new PrioListe();
		
		list.addPatient(new Patient("Peter Hurensohn", 2));
		list.addPatient(new Patient("Peter Hurensohn", 3));
		list.addPatient(new Patient("Peter Hurensohn", 5));
		list.addPatient(new Patient("Peter Hurensohn", 4));
//		list.getNextPatient();
		
		System.out.println(list.printProListeToString());
	}
}

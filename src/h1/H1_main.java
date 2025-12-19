package h1;

public class H1_main {
	public static void main(String[] args) {
		Patient a = new Patient("Daniel", 2);
		Patient b = new Patient("Sebastian", 5);
		Patient c = new Patient("Linda", 10);
		Patient d = new Patient("Arschlochkind", 3);
		
		PrioListe eins = new PrioListe();
		eins.addPatient(a);
		//eins.printListe();
		eins.addPatient(b);
		//eins.printListe();
		eins.addPatient(c);
		//eins.printListe();
		eins.addPatient(d);
		//eins.printListe();
		
		System.out.println(eins.getNextPatient());
		//eins.printListe();
		System.out.println(eins.getPosition(c));
	}
}

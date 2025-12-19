package h2;

public class H2_main {
	public static void main(String[] args) {
		Bus linie710 = new Bus();
		Bus linie910 = new Bus();
		
		linie710.enterBus(new Passenger("Warren Buffet", 3, true));
		linie710.enterBus(new Passenger("Elon Musk", 5, false));

		linie710.nextStop(new Passenger[] {new Passenger("Bill Gates", 10, true)});
		linie710.nextStop();
		
		linie710.findPassengersWithoutTickets();
		
		linie710.transferPassengers(linie910, new String[] {"Bill Gates"});
//		linie710.nextStop();
		
		
	}
}

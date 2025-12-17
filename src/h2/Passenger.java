package h2;

public class Passenger {
	public String name;
	//counts the stations that have to be driven (min. 1)
	public int planned;
	//counts the stations that have been driven (init = 0)
	public int visited;
	//true if Passenger has a ticket
	public boolean ticket;
	
	public Passenger(String name, int planned, boolean ticket) {
		this.name = name;
		this.planned = planned;
		this.visited = 0;
		this.ticket = ticket;
	}
}

package imb.SS14.tpegr01.cinema;

public class Hall {
	private String name;
	private int seats;

	public Hall(String name, int seats) {
		this.setName(name);
		this.setSeats(seats);
	}

	public int getSeats() {
		return seats;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	private void setSeats(int seats) {
		this.seats = seats;
	}

}

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

	@Override
	public boolean equals(Object o) {
		if (o instanceof Hall) {
			Hall hallToCompare = (Hall) o;
			if (hallToCompare.name.equals(this.name)) {
				if (hallToCompare.seats == this.seats) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return ("Saal '" + getName() + "' (" + getSeats() + " Plaetze)");
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setSeats(int seats) {
		this.seats = seats;
	}

}

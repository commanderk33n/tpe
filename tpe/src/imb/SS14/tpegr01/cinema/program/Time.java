package imb.SS14.tpegr01.cinema.program;

public class Time {

	private int minutes;

	public Time(String time) {
		int minutesTest = parse(time);
		if (minutesTest >= 0) {
			this.minutes = minutesTest;
		}
	}

	public Time(int timeAsMinutes) {
		try {
			if (timeAsMinutes >= 0) {
				this.minutes = timeAsMinutes;
			} else {
				throw new IllegalTimeException(
						"Unzulässige Uhrzeit wurde eingegeben!");
			}
		} catch (IllegalTimeException e) {
			System.out.println("Fehler: " + e.getMessage());
		}
	}

	private int parse(String time) {
		int index = time.indexOf(":");
		int hour = Integer.valueOf(time.substring(0, index));
		int minute = Integer.valueOf(time.substring(index + 1));
		try {
			if (hour > 23 || hour < 0) {
				throw new IllegalTimeException(
						"Unzulässige Stunde wurde eingegeben!");

			}
			if (minute > 59 || minute < 0) {
				throw new IllegalTimeException(
						"Unzulässige Stunde wurde eingegeben!");
			}
			return hour * 60 + minute;
		} catch (IllegalTimeException e) {
			System.out.println("Fehler: " + e.getMessage());
		}
		return -1;
	}

	public void setTime(String time) {
		this.minutes = parse(time);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Time) {
			Time t = (Time) o;
			if (t.minutes == this.minutes) {
				return true;
			}
		}
		return false;
	}

	public int getTimeAsMinutes() {
		return this.minutes;
	}

	public int getHoursOnly() {
		return (int) (this.minutes / 60);
	}

	public int getMinutesOnly() {
		return (this.minutes % 60);
	}

	public String toString() {
		String result = "" + (int) (this.minutes / 60) + ":";
		if ((this.minutes % 60) < 10) {
			result += "0";
		}
		result += this.minutes % 60;
		return result;
	}

	public class IllegalTimeException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public IllegalTimeException(String message) {
			super(message);
		}
	}

}

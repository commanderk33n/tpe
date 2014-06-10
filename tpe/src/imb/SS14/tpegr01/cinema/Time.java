package imb.SS14.tpegr01.cinema;

public class Time {
	private int minutes;

	public Time(String time) {
		this.minutes = parse(time);
	}

	private int parse(String time) {
		int index = time.indexOf(":");
		int hour = Integer.valueOf(time.substring(0, index));
		int minute = Integer.valueOf(time.substring(index + 1));
		try {
			if (hour > 23 || hour < 0) {
				throw new MyTimeException(
						"Unzulässige Stunde wurde eingegeben!");

			}
			if (minute > 59 || minute < 0) {
				throw new MyTimeException(
						"Unzulässige Stunde wurde eingegeben!");
			}
			return hour * 60 + minute;
		} catch (MyTimeException e) {
			System.out.println("Fehler: " + e.getMessage());
		}

		return -1;
	}

	public void setTime(String time) {
		this.minutes = parse(time);
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
		String result = "" + (int) (this.minutes / 60) + ":" + this.minutes
				% 60;
		return result;
	}

	public class MyTimeException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTimeException(String message) {
			super(message);
		}
	}

}

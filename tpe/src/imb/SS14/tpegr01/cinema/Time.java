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
		if (hour > 23 && hour < 0) {
			// todo exeption

		}
		if (minute > 59 && minute < 0) {
			// todo exeption
		}

		return hour * 60 + minute;
	}
	public int getTimeAsMinutes(){
		return this.minutes;
	}

	public String toString() {
		String result = "" + (int) (this.minutes / 60) + ":" + this.minutes
				% 60;
		return "";
	}

}

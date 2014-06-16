package imb.SS14.tpegr01.cinema.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import imb.SS14.tpegr01.cinema.Cinema;
import imb.SS14.tpegr01.cinema.Hall;
import imb.SS14.tpegr01.cinema.film.Film;
import imb.SS14.tpegr01.cinema.film.USK;
import imb.SS14.tpegr01.cinema.program.ProgramPart;
import imb.SS14.tpegr01.cinema.program.Time;

public class Junit {

	@Test
	public void testTime() {
		Time time = new Time("22:15");
		int test = time.getTimeAsMinutes();
		assertTrue(test == 1335);
	}

	@Test
	public void testTimetoString() {
		String time = "22:17";
		Time date = new Time(time);
		assertEquals(date.toString(), time);
	}

	public Cinema createExampleCinema() {
		Film batmanBegins = new Film("Batman Begins", 134, USK.ABZWOELF);
		Film barbie = new Film("Barbie - Die Prinzessinnen-Akademie", 81,
				USK.OHNEALT);
		Film iceAge3 = new Film("Ice Age 3", 90, USK.OHNEALT);
		Film machete = new Film("Machete", 100, USK.OHNEJUGEND);
		Film trainspotting = new Film("Trainspotting", 89, USK.OHNEJUGEND);
		Film pulpFiction = new Film("Pulp Fiction", 148, USK.ABSECHZEHN);
		Film fromDusktillDawn = new Film("From Dusk till Dawn", 87,
				USK.ABSECHZEHN);
		Film chocolat = new Film("Chocolat", 121, USK.ABSECHS);
		Hall blauerSaal = new Hall("Blauer Saal", 250);
		Hall gruenerSaal = new Hall("Grüner Saal", 200);
		Hall studio = new Hall("Studio", 150);
		Hall kellerloch = new Hall("Kellerloch", 30);
		Hall[] halls = { blauerSaal, gruenerSaal, studio, kellerloch };
		Cinema monnem = new Cinema("Cinemaxx", "Mannheim", halls);
		monnem.addProgramPart(blauerSaal, new ProgramPart(batmanBegins,
				new Time("14:00")));
		monnem.addProgramPart(blauerSaal, new ProgramPart(batmanBegins,
				new Time("17:00")));
		monnem.addProgramPart(blauerSaal, new ProgramPart(batmanBegins,
				new Time("20:00")));
		monnem.addProgramPart(blauerSaal, new ProgramPart(batmanBegins,
				new Time("23:00")));
		monnem.addProgramPart(gruenerSaal, new ProgramPart(barbie, new Time(
				"15:00")));
		monnem.addProgramPart(gruenerSaal, new ProgramPart(iceAge3, new Time(
				"17:00")));
		monnem.addProgramPart(gruenerSaal, new ProgramPart(iceAge3, new Time(
				"19:00")));
		monnem.addProgramPart(gruenerSaal, new ProgramPart(machete, new Time(
				"21:00")));
		monnem.addProgramPart(studio, new ProgramPart(iceAge3,
				new Time("15:00")));
		monnem.addProgramPart(studio, new ProgramPart(trainspotting, new Time(
				"17:00")));
		monnem.addProgramPart(studio, new ProgramPart(pulpFiction, new Time(
				"20:00")));
		monnem.addProgramPart(studio, new ProgramPart(fromDusktillDawn,
				new Time("23:00")));
		monnem.addProgramPart(kellerloch, new ProgramPart(chocolat, new Time(
				"20:00")));
		monnem.addProgramPart(kellerloch, new ProgramPart(trainspotting,
				new Time("23:00")));
		return monnem;
	}

	// Cinemaxx in Mannheim
	// Saal 'Blauer Saal' (250 Plaetze)
	// 14:00 -- Batman Begins [ab 12 Jahre] 134 min
	// 17:00 -- Batman Begins [ab 12 Jahre] 134 min
	// 20:00 -- Batman Begins [ab 12 Jahre] 134 min
	// 23:00 -- Batman Begins [ab 12 Jahre] 134 min
	// Saal 'Grüner Saal' (200 Plaetze)
	// 15:00 -- Barbie - Die Prinzessinnen-Akademie [ohne Altersbeschränkung] 81
	// min
	// 17:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min
	// 19:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min
	// 21:00 -- Machete [keine Jugendfreigabe] 100 min
	// Saal 'Studio' (150 Plaetze)
	// 15:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min
	// 17:00 -- Trainspotting [keine Jugendfreigabe] 89 min
	// 20:00 -- Pulp Fiction [ab 16 Jahre] 148 min
	// 23:00 -- From Dusk till Dawn [ab 16 Jahre] 87 min
	// Saal 'Kellerloch' (30 Plaetze)
	// 20:00 -- Chocolat [ab 6 Jahre] 121 min
	// 23:00 -- Trainspotting [keine Jugendfreigabe] 89 min

	@Test
	public void testCinemaToString() {
		String example = "Cinemaxx in Mannheim\n"
				+ "Saal 'Blauer Saal' (250 Plaetze)\n"
				+ "14:00 -- Batman Begins [ab 12 Jahre] 134 min\n"
				+ "17:00 -- Batman Begins [ab 12 Jahre] 134 min\n"
				+ "20:00 -- Batman Begins [ab 12 Jahre] 134 min\n"
				+ "23:00 -- Batman Begins [ab 12 Jahre] 134 min\n"
				+ "Saal 'Grüner Saal' (200 Plaetze)\n"
				+ "15:00 -- Barbie - Die Prinzessinnen-Akademie [ohne Altersbeschränkung] 81 min\n"
				+ "17:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min\n"
				+ "19:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min\n"
				+ "21:00 -- Machete [keine Jugendfreigabe] 100 min\n"
				+ "Saal 'Studio' (150 Plaetze)\n"
				+ "15:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min\n"
				+ "17:00 -- Trainspotting [keine Jugendfreigabe] 89 min\n"
				+ "20:00 -- Pulp Fiction [ab 16 Jahre] 148 min\n"
				+ "23:00 -- From Dusk till Dawn [ab 16 Jahre] 87 min\n"
				+ "Saal 'Kellerloch' (30 Plaetze)\n"
				+ "20:00 -- Chocolat [ab 6 Jahre] 121 min\n"
				+ "23:00 -- Trainspotting [keine Jugendfreigabe] 89 min\n";
		Cinema monnem = createExampleCinema();
		while (!monnem.toString().equals(example)) {
			monnem = createExampleCinema();
		}
		assertEquals(example, monnem.toString());
	}

	@Test
	public void CinemaIterable() {

		Film batmanBegins = new Film("Batman Begins", 134, USK.ABZWOELF);
		Film barbie = new Film("Barbie - Die Prinzessinnen-Akademie", 81,
				USK.OHNEALT);
		Film iceAge3 = new Film("Ice Age 3", 90, USK.OHNEALT);
		Film machete = new Film("Machete", 100, USK.OHNEJUGEND);
		Film trainspotting = new Film("Trainspotting", 89, USK.OHNEJUGEND);
		Film pulpFiction = new Film("Pulp Fiction", 148, USK.ABSECHZEHN);
		Film fromDusktillDawn = new Film("From Dusk till Dawn", 87,
				USK.ABSECHZEHN);
		Film chocolat = new Film("Chocolat", 121, USK.ABSECHS);

		Cinema cinemaxx = createExampleCinema();

		ProgramPart[] vergleich = { new ProgramPart(barbie, new Time("15:00")),
				new ProgramPart(iceAge3, new Time("17:00")),
				new ProgramPart(iceAge3, new Time("19:00")),
				new ProgramPart(machete, new Time("21:00")),
				new ProgramPart(iceAge3, new Time("15:00")),
				new ProgramPart(trainspotting, new Time("17:00")),
				new ProgramPart(pulpFiction, new Time("20:00")),
				new ProgramPart(fromDusktillDawn, new Time("23:00")),
				new ProgramPart(batmanBegins, new Time("14:00")),
				new ProgramPart(batmanBegins, new Time("17:00")),
				new ProgramPart(batmanBegins, new Time("20:00")),
				new ProgramPart(batmanBegins, new Time("23:00")),
				new ProgramPart(chocolat, new Time("20:00")),
				new ProgramPart(trainspotting, new Time("23:00")) };

		ProgramPart[] cinemaIterable = new ProgramPart[vergleich.length];
		int index = 0;
		for (ProgramPart p : cinemaxx) {
			cinemaIterable[index] = p;
			index++;
		}
		Arrays.sort(cinemaIterable);
		Arrays.sort(vergleich);
		assertTrue(Arrays.equals(vergleich, cinemaIterable));

	}
}

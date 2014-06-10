package imb.SS14.tpegr01.cinema;

import java.util.ArrayList;
import java.util.Map;

public class Cinema {

	private String name;
	private String city;
	private Map<Hall, ArrayList<ProgramPart>> program;
	// TODO program als neue
	// klasse (mit extends
	// Map<Hall,
	// ArrayList<ProgramPart>>
	// ??

	public Cinema(String name, String city, Hall... halls) {
		this.setName(name);
		this.setCity(city);
		for (Hall hall : halls) {
			this.program.put(hall, new ArrayList<ProgramPart>());
		}
	}

	public boolean addProgramPart(Hall hall, ProgramPart newProgramPart) {
		if (program.containsKey(hall)) {
			ArrayList<ProgramPart> currentProgram = program.get(hall);
			if (permitted(currentProgram, newProgramPart)) {
				// TODO Exception werfen falls nicht permitted?
				currentProgram.add(newProgramPart);
				this.program.put(hall, currentProgram);
				return true;
			}
		}

		return false;
	}

	/**
	 * @param currentProgram
	 * @param newProgramPart
	 * @return
	 */
	private boolean permitted(ArrayList<ProgramPart> currentProgram,
			ProgramPart newProgramPart) {
		int startingTimeNewFilm = newProgramPart.getTime().getTimeAsMinutes();
		int endingTimeNewFilm = (newProgramPart.getTime().getTimeAsMinutes() + newProgramPart
				.getFilm().getDuration());
		for (ProgramPart currentProgramPart : currentProgram) {
			int startingTimeCurrentFilm = currentProgramPart.getTime()
					.getTimeAsMinutes();
			int endingTimeCurrentFilm = (currentProgramPart.getTime()
					.getTimeAsMinutes() + currentProgramPart.getFilm()
					.getDuration());
			if (startingTimeNewFilm < startingTimeCurrentFilm
					&& endingTimeNewFilm > startingTimeCurrentFilm) {
				return false;
			}
			if (startingTimeNewFilm < endingTimeCurrentFilm
					&& endingTimeNewFilm > endingTimeCurrentFilm) {
				return false;
			}
		}
		return true;
	}

	// TODO
	// Implementieren Sie die Klasse Kino so, dass Objekte von ihr in einer
	// foreach-Schleife verwendet werden
	// können, um über das gesamte Programm zu iterieren (Film und
	// Anfangszeit). Bei jedem Schleifendurchlauf
	// soll ein Objekt zurückgegeben werden, dass die Startzeit und den Film
	// enthält. Filme können
	// doppelt vorkommen, wenn sie unterschiedliche Anfangszeiten haben.

	public String getCity() {
		return city;
	}

	public String getName() {
		return name;
	}

	public Map<Hall, ArrayList<ProgramPart>> getProgram() {
		return this.program;
	}

	public String toString() {
		String plan = "";
		// TODO Zusätzlich soll das Kino noch die Möglichkeit bieten, über
		// die toString-Methode den gesamten Spielplan
		// auszugeben. Beispielsweise sieht die Ausgabe dann so aus:
		// Cinemaxx in Mannheim
		// Saal 'Blauer Saal' (250 Plaetze)
		// 14:00 -- Batman Begins [ab 12 Jahre] 134 min
		// 17:00 -- Batman Begins [ab 12 Jahre] 134 min
		// 20:00 -- Batman Begins [ab 12 Jahre] 134 min
		// 23:00 -- Batman Begins [ab 12 Jahre] 134 min
		// Saal 'Grüner Saal' (200 Plaetze)
		// 15:00 -- Barbie - Die Prinzessinnen-Akademie [ohne
		// Altersbeschränkung] 81 min
		// 17:00 -- Ice Age 3 [ohne Altersbeschrankung] 90 min
		// 19:00 -- Ice Age 3 [ohne Altersbeschrankung] 90 min
		// 21:00 -- Machete [keine Jugendfreigabe] 100 min
		// Saal 'Studio' (150 Plaetze)
		// 15:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min
		// 17:00 -- Trainspotting [keine Jugendfreigabe] 89 min
		// 20:00 -- Pulp Fiction [ab 16 Jahre] 148 min
		// 23:00 -- From Dusk till Dawn [ab 16 Jahre] 87 min
		// Saal 'Kellerloch' (30 Plaetze)
		// 20:00 -- Chocolat [ab 6 Jahre] 121 min
		// 23:00 -- Trainspotting [keine Jugendfreigabe] 89 min
		return plan;
	}

	private void setName(String name) {
		this.name = name;
	}

	// sinnvolle Methode?!
	public void setWholeProgramm(Map<Hall, ArrayList<ProgramPart>> newProgram) {
		this.program = newProgram;
	}

	private void setCity(String city) {
		this.city = city;
	}
}

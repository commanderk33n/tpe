package imb.SS14.tpegr01.racewars.junit;

import static org.junit.Assert.*;
import imb.SS14.tpegr01.racewars.*;
import imb.SS14.tpegr01.racewars.interfaces.*;
import imb.SS14.tpegr01.racewars.wesen.*;

import org.junit.Test;

public class JUnit {

	
	@Test
	public void maxInvest() {
		Spieler spieler = new Spieler("The walking Dead", "untote", 2000000);
		Squad squad = new Squad(spieler);
		assertTrue(27 == squad.getLebendige());
	}

	@Test
	public void maxHeldenEinerRasse() {
		Spieler spieler = new Spieler("Hipster-Horde", "menschen", 800,
				"menschen", 800);
		Squad squad = new Squad(spieler);
		int count = 0;
		for (int i = 0; i < squad.getLebendige(); i++) {
			if (squad.getWesen(i) instanceof Erzmagier) {
				count++;
			}
		}
		assertTrue(1 == count);
	}
	
	@Test
	public void wesenStirbt() {
		Spieler spieler = new Spieler("The walking Dead", "untote", 2000);
		Squad squad = new Squad(spieler);
		squad.getWesen(2).bekommtSchaden(squad.getWesen(2).getLebenspunkte());
		squad.kampffaehig(2);
		assertTrue(26 == squad.getLebendige());
	}


	@Test
	public void elementbonus() {
		Wesen held1 = new Lich();
		Wesen held2 = new Erzmagier();
		assertTrue(141.0 == held1.attacke(held2));
	}
	
	
	// Alle Wesen greifen sich gegenseitig an!!!
	
	// Mensch greift jedes mögliche Ziel an
	@Test
	public void testSchadenMenschAttakiertMensch() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Mensch();
		assertTrue(48 == mensch.attacke(ziel));
	}

	@Test
	public void testSchadenMenschAttakiertErzmagier() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Erzmagier();
		assertTrue(48 == mensch.attacke(ziel));
	}

	@Test
	public void testSchadenMenschAttakiertOrk() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Ork();
		assertTrue(56 == mensch.attacke(ziel));
	}

	@Test
	public void testSchadenMenschAttakiertFarseer() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Farseer();
		assertTrue(56 == mensch.attacke(ziel));
	}

	@Test
	public void testSchadenMenschAttakiertUntote() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Untoter();
		assertTrue(56 == mensch.attacke(ziel));
	}

	@Test
	public void testSchadenMenschAttakiertLich() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Lich();
		assertTrue(56 == mensch.attacke(ziel));
	}

	@Test
	public void testSchadenMenschAttakiertNachtelf() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Nachtelf();
		assertTrue(64 == mensch.attacke(ziel));
	}

	@Test
	public void testSchadenMenschAttakiertDaemonenjaeger() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(64 == mensch.attacke(ziel));
	}

	// Ork greift jedes mögliche Ziel an
	@Test
	public void testSchadenOrkAttakiertMensch() {
		Wesen ork = new Ork();
		Wesen ziel = new Mensch();
		assertTrue(79 == ork.attacke(ziel));
	}

	@Test
	public void testSchadenOrkAttakiertErzmagier() {
		Wesen ork = new Ork();
		Wesen ziel = new Erzmagier();
		assertTrue(79 == ork.attacke(ziel));
	}

	@Test
	public void testSchadenOrkAttakiertOrk() {
		Wesen ork = new Ork();
		Wesen ziel = new Ork();
		assertTrue(92 == ork.attacke(ziel));
	}

	@Test
	public void testSchadenOrkAttakiertFarseer() {
		Wesen ork = new Ork();
		Wesen ziel = new Farseer();
		assertTrue(92 == ork.attacke(ziel));
	}

	@Test
	public void testSchadenOrkAttakiertUntote() {
		Wesen ork = new Ork();
		Wesen ziel = new Untoter();
		assertTrue(92 == ork.attacke(ziel));
	}

	@Test
	public void testSchadenOrkAttakiertLich() {
		Wesen ork = new Ork();
		Wesen ziel = new Lich();
		assertTrue(92 == ork.attacke(ziel));
	}

	@Test
	public void testSchadenOrkAttakiertNachtelf() {
		Wesen ork = new Ork();
		Wesen ziel = new Nachtelf();
		assertTrue(106 == ork.attacke(ziel));
	}

	@Test
	public void testSchadenOrkAttakiertDaemonenjaeger() {
		Wesen ork = new Ork();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(106 == ork.attacke(ziel));
	}

	// Untote greift jedes mögliche Ziel an
	@Test
	public void testSchadenUntoteAttakiertMensch() {
		Wesen untote = new Untoter();
		Wesen ziel = new Mensch();
		assertTrue(31 == untote.attacke(ziel));
	}

	@Test
	public void testSchadenUntoteAttakiertErzmagier() {
		Wesen untote = new Untoter();
		Wesen ziel = new Erzmagier();
		assertTrue(31 == untote.attacke(ziel));
	}

	@Test
	public void testSchadenUntoteAttakiertOrk() {
		Wesen untote = new Untoter();
		Wesen ziel = new Ork();
		assertTrue(36 == untote.attacke(ziel));
	}

	@Test
	public void testSchadenUntoteAttakiertFarseer() {
		Wesen untote = new Untoter();
		Wesen ziel = new Farseer();
		assertTrue(36 == untote.attacke(ziel));
	}

	@Test
	public void testSchadenUntoteAttakiertUntote() {
		Wesen untote = new Untoter();
		Wesen ziel = new Untoter();
		assertTrue(36 == untote.attacke(ziel));
	}

	@Test
	public void testSchadenUntoteAttakiertLich() {
		Wesen untote = new Untoter();
		Wesen ziel = new Lich();
		assertTrue(36 == untote.attacke(ziel));
	}

	@Test
	public void testSchadenUntoteAttakiertNachtelf() {
		Wesen untote = new Untoter();
		Wesen ziel = new Nachtelf();
		assertTrue(41 == untote.attacke(ziel));
	}

	@Test
	public void testSchadenUntoteAttakiertDaemonenjaeger() {
		Wesen untote = new Untoter();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(41 == untote.attacke(ziel));
	}

	// Nachtelf greift jedes mögliche Ziel an
	@Test
	public void testSchadenNachtelfAttakiertMensch() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Mensch();
		assertTrue(78 == nachtefl.attacke(ziel));
	}

	@Test
	public void testSchadenNachtelfAttakiertErzmagier() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Erzmagier();
		assertTrue(78 == nachtefl.attacke(ziel));
	}

	@Test
	public void testSchadenNachtelfAttakiertOrk() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Ork();
		assertTrue(91 == nachtefl.attacke(ziel));
	}

	@Test
	public void testSchadenNachtelfAttakiertFarseer() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Farseer();
		assertTrue(91 == nachtefl.attacke(ziel));
	}

	@Test
	public void testSchadenNachtelfAttakiertUntote() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Untoter();
		assertTrue(91 == nachtefl.attacke(ziel));
	}

	@Test
	public void testSchadenNachtelfAttakiertLich() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Lich();
		assertTrue(91 == nachtefl.attacke(ziel));
	}

	@Test
	public void testSchadenNachtelfAttakiertNachtelf() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Nachtelf();
		assertTrue(104 == nachtefl.attacke(ziel));
	}

	@Test
	public void testSchadenNachtelfAttakiertDaemonenjaeger() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(104 == nachtefl.attacke(ziel));
	}

	// Erzmagier greift jedes mögliche Ziel an
	@Test
	public void testSchadenErzmagierAttakiertMensch() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Mensch();
		assertTrue(240 == erzmagier.attacke(ziel));
	}

	@Test
	public void testSchadenErzmagierAttakiertErzmagier() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Erzmagier();
		assertTrue(240== erzmagier.attacke(ziel));
	}

	@Test
	public void testSchadenErzmagierAttakiertOrk() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Ork();
		assertTrue(280 == erzmagier.attacke(ziel));
	}

	@Test
	public void testSchadenErzmagierAttakiertFarseer() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Farseer();
		assertTrue(280 == erzmagier.attacke(ziel));
	}

	@Test
	public void testSchadenErzmagierAttakiertUntote() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Untoter();
		assertTrue(280 == erzmagier.attacke(ziel));
	}

	@Test
	public void testSchadenErzmagierAttakiertLich() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Lich();
		assertTrue(280 == erzmagier.attacke(ziel));
	}

	@Test
	public void testSchadenErzmagierAttakiertNachtelf() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Nachtelf();
		assertTrue(320 == erzmagier.attacke(ziel));
	}

	@Test
	public void testSchadenErzmagierAttakiertDaemonenjaeger() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(640 == erzmagier.attacke(ziel));
	}

	// Farseer greift jedes mögliche Ziel an
	@Test
	public void testSchadenFarseerAttakiertMensch() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Mensch();
		assertTrue(95 == farseer.attacke(ziel));
	}

	@Test
	public void testSchadenFarseerAttakiertErzmagier() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Erzmagier();
		assertTrue(95 == farseer.attacke(ziel));
	}

	@Test
	public void testSchadenFarseerAttakiertOrk() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Ork();
		assertTrue(111 == farseer.attacke(ziel));
	}

	@Test
	public void testSchadenFarseerAttakiertFarseer() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Farseer();
		assertTrue(111 == farseer.attacke(ziel));
	}

	@Test
	public void testSchadenFarseerAttakiertUntote() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Untoter();
		assertTrue(111 == farseer.attacke(ziel));
	}

	@Test
	public void testSchadenFarseerAttakiertLich() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Lich();
		assertTrue(222 == farseer.attacke(ziel));
	}

	@Test
	public void testSchadenFarseerAttakiertNachtelf() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Nachtelf();
		assertTrue(127 == farseer.attacke(ziel));
	}

	@Test
	public void testSchadenFarseerAttakiertDaemonenjaeger() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(127 == farseer.attacke(ziel));
	}

	// Lich greift jedes mögliche Ziel an
	@Test
	public void testSchadenLichAttakiertMensch() {
		Wesen lich = new Lich();
		Wesen ziel = new Mensch();
		assertTrue(71 == lich.attacke(ziel));
	}

	@Test
	public void testSchadenLichAttakiertErzmagier() {
		Wesen lich = new Lich();
		Wesen ziel = new Erzmagier();
		assertTrue(141 == lich.attacke(ziel));
	}

	@Test
	public void testSchadenLichAttakiertOrk() {
		Wesen lich = new Lich();
		Wesen ziel = new Ork();
		assertTrue(82 == lich.attacke(ziel));
	}

	@Test
	public void testSchadenLichAttakiertFarseer() {
		Wesen lich = new Lich();
		Wesen ziel = new Farseer();
		assertTrue(82 == lich.attacke(ziel));
	}

	@Test
	public void testSchadenLichAttakiertUntote() {
		Wesen lich = new Lich();
		Wesen ziel = new Untoter();
		assertTrue(82 == lich.attacke(ziel));
	}

	@Test
	public void testSchadenLichAttakiertLich() {
		Wesen lich = new Lich();
		Wesen ziel = new Lich();
		assertTrue(82 == lich.attacke(ziel));
	}

	@Test
	public void testSchadenLichAttakiertNachtelf() {
		Wesen lich = new Lich();
		Wesen ziel = new Nachtelf();
		assertTrue(94 == lich.attacke(ziel));
	}

	@Test
	public void testSchadenLichAttakiertDaemonenjaeger() {
		Wesen lich = new Lich();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(94 == lich.attacke(ziel));
	}

	// Daemonenjaeger greift jedes mögliche Ziel an
	@Test
	public void testSchadenDaemonenjaegerAttakiertMensch() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Mensch();
		assertTrue(235 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void testSchadenDaemonenjaegerAttakiertErzmagier() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Erzmagier();
		assertTrue(235 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void testSchadenDaemonenjaegerAttakiertOrk() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Ork();
		assertTrue(274 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void testSchadenDaemonenjaegerAttakiertFarseer() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Farseer();
		assertTrue(548 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void testSchadenDaemonenjaegerAttakiertUntote() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Untoter();
		assertTrue(274 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void testSchadenDaemonenjaegerAttakiertLich() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Lich();
		assertTrue(274 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void testSchadenDaemonenjaegerAttakiertNachtelf() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Nachtelf();
		assertTrue(313 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void testSchadenDaemonenjaegerAttakiertDaemonenjaeger() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(313 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void testLebendig() {
		Wesen ork = new Ork();
		assertEquals(true, ork.isLebendig());
	}

}

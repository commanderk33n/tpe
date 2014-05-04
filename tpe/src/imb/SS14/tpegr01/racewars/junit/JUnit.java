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
	
	// Menschen
	@Test
	public void MenschGegenMensch() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Mensch();
		assertTrue(48 == mensch.attacke(ziel));
	}

	@Test
	public void MenschGegenErzmagier() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Erzmagier();
		assertTrue(48 == mensch.attacke(ziel));
	}

	@Test
	public void MenschGegenOrk() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Ork();
		assertTrue(56 == mensch.attacke(ziel));
	}

	@Test
	public void MenschGegenFarseer() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Farseer();
		assertTrue(56 == mensch.attacke(ziel));
	}

	@Test
	public void MenschGegenUntote() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Untoter();
		assertTrue(56 == mensch.attacke(ziel));
	}

	@Test
	public void MenschGegenLich() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Lich();
		assertTrue(56 == mensch.attacke(ziel));
	}

	@Test
	public void MenschGegenNachtelf() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Nachtelf();
		assertTrue(64 == mensch.attacke(ziel));
	}

	@Test
	public void MenschGegenDaemonenjaeger() {
		Wesen mensch = new Mensch();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(64 == mensch.attacke(ziel));
	}

	// Orks
	@Test
	public void OrkGegenMensch() {
		Wesen ork = new Ork();
		Wesen ziel = new Mensch();
		assertTrue(79 == ork.attacke(ziel));
	}

	@Test
	public void OrkGegenErzmagier() {
		Wesen ork = new Ork();
		Wesen ziel = new Erzmagier();
		assertTrue(79 == ork.attacke(ziel));
	}

	@Test
	public void OrkGegenOrk() {
		Wesen ork = new Ork();
		Wesen ziel = new Ork();
		assertTrue(92 == ork.attacke(ziel));
	}

	@Test
	public void OrkGegenFarseer() {
		Wesen ork = new Ork();
		Wesen ziel = new Farseer();
		assertTrue(92 == ork.attacke(ziel));
	}

	@Test
	public void OrkGegenUntote() {
		Wesen ork = new Ork();
		Wesen ziel = new Untoter();
		assertTrue(92 == ork.attacke(ziel));
	}

	@Test
	public void OrkGegenLich() {
		Wesen ork = new Ork();
		Wesen ziel = new Lich();
		assertTrue(92 == ork.attacke(ziel));
	}

	@Test
	public void OrkGegenNachtelf() {
		Wesen ork = new Ork();
		Wesen ziel = new Nachtelf();
		assertTrue(106 == ork.attacke(ziel));
	}

	@Test
	public void OrkGegenDaemonenjaeger() {
		Wesen ork = new Ork();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(106 == ork.attacke(ziel));
	}

	// Untote
	@Test
	public void UntoteGegenMensch() {
		Wesen untote = new Untoter();
		Wesen ziel = new Mensch();
		assertTrue(31 == untote.attacke(ziel));
	}

	@Test
	public void UntoteGegenErzmagier() {
		Wesen untote = new Untoter();
		Wesen ziel = new Erzmagier();
		assertTrue(31 == untote.attacke(ziel));
	}

	@Test
	public void UntoteGegenOrk() {
		Wesen untote = new Untoter();
		Wesen ziel = new Ork();
		assertTrue(36 == untote.attacke(ziel));
	}

	@Test
	public void UntoteGegenFarseer() {
		Wesen untote = new Untoter();
		Wesen ziel = new Farseer();
		assertTrue(36 == untote.attacke(ziel));
	}

	@Test
	public void UntoteGegenUntote() {
		Wesen untote = new Untoter();
		Wesen ziel = new Untoter();
		assertTrue(36 == untote.attacke(ziel));
	}

	@Test
	public void UntoteGegenLich() {
		Wesen untote = new Untoter();
		Wesen ziel = new Lich();
		assertTrue(36 == untote.attacke(ziel));
	}

	@Test
	public void UntoteGegenNachtelf() {
		Wesen untote = new Untoter();
		Wesen ziel = new Nachtelf();
		assertTrue(41 == untote.attacke(ziel));
	}

	@Test
	public void UntoteGegenDaemonenjaeger() {
		Wesen untote = new Untoter();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(41 == untote.attacke(ziel));
	}

	// Nachtelf
	@Test
	public void NachtelfGegenMensch() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Mensch();
		assertTrue(78 == nachtefl.attacke(ziel));
	}

	@Test
	public void NachtelfGegenErzmagier() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Erzmagier();
		assertTrue(78 == nachtefl.attacke(ziel));
	}

	@Test
	public void NachtelfGegenOrk() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Ork();
		assertTrue(91 == nachtefl.attacke(ziel));
	}

	@Test
	public void NachtelfGegenFarseer() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Farseer();
		assertTrue(91 == nachtefl.attacke(ziel));
	}

	@Test
	public void NachtelfGegenUntote() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Untoter();
		assertTrue(91 == nachtefl.attacke(ziel));
	}

	@Test
	public void NachtelfGegenLich() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Lich();
		assertTrue(91 == nachtefl.attacke(ziel));
	}

	@Test
	public void NachtelfGegenNachtelf() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Nachtelf();
		assertTrue(104 == nachtefl.attacke(ziel));
	}

	@Test
	public void NachtelfGegenDaemonenjaeger() {
		Wesen nachtefl = new Nachtelf();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(104 == nachtefl.attacke(ziel));
	}

	// Erzmagier
	@Test
	public void ErzmagierGegenMensch() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Mensch();
		assertTrue(240 == erzmagier.attacke(ziel));
	}

	@Test
	public void ErzmagierGegenErzmagier() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Erzmagier();
		assertTrue(240== erzmagier.attacke(ziel));
	}

	@Test
	public void ErzmagierGegenOrk() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Ork();
		assertTrue(280 == erzmagier.attacke(ziel));
	}

	@Test
	public void ErzmagierGegenFarseer() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Farseer();
		assertTrue(280 == erzmagier.attacke(ziel));
	}

	@Test
	public void ErzmagierGegenUntote() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Untoter();
		assertTrue(280 == erzmagier.attacke(ziel));
	}

	@Test
	public void ErzmagierGegenLich() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Lich();
		assertTrue(280 == erzmagier.attacke(ziel));
	}

	@Test
	public void ErzmagierGegenNachtelf() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Nachtelf();
		assertTrue(320 == erzmagier.attacke(ziel));
	}

	@Test
	public void ErzmagierGegenDaemonenjaeger() {
		Wesen erzmagier = new Erzmagier();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(640 == erzmagier.attacke(ziel));
	}

	// Farseer 
	@Test
	public void FarseerGegenMensch() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Mensch();
		assertTrue(95 == farseer.attacke(ziel));
	}

	@Test
	public void FarseerGegenErzmagier() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Erzmagier();
		assertTrue(95 == farseer.attacke(ziel));
	}

	@Test
	public void FarseerGegenOrk() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Ork();
		assertTrue(111 == farseer.attacke(ziel));
	}

	@Test
	public void FarseerGegenFarseer() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Farseer();
		assertTrue(111 == farseer.attacke(ziel));
	}

	@Test
	public void FarseerGegenUntote() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Untoter();
		assertTrue(111 == farseer.attacke(ziel));
	}

	@Test
	public void FarseerGegenLich() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Lich();
		assertTrue(222 == farseer.attacke(ziel));
	}

	@Test
	public void FarseerGegenNachtelf() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Nachtelf();
		assertTrue(127 == farseer.attacke(ziel));
	}

	@Test
	public void FarseerGegenDaemonenjaeger() {
		Wesen farseer = new Farseer();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(127 == farseer.attacke(ziel));
	}

	// Lich
	@Test
	public void LichGegenMensch() {
		Wesen lich = new Lich();
		Wesen ziel = new Mensch();
		assertTrue(71 == lich.attacke(ziel));
	}

	@Test
	public void LichGegenErzmagier() {
		Wesen lich = new Lich();
		Wesen ziel = new Erzmagier();
		assertTrue(141 == lich.attacke(ziel));
	}

	@Test
	public void LichGegenOrk() {
		Wesen lich = new Lich();
		Wesen ziel = new Ork();
		assertTrue(82 == lich.attacke(ziel));
	}

	@Test
	public void LichGegenFarseer() {
		Wesen lich = new Lich();
		Wesen ziel = new Farseer();
		assertTrue(82 == lich.attacke(ziel));
	}

	@Test
	public void LichGegenUntote() {
		Wesen lich = new Lich();
		Wesen ziel = new Untoter();
		assertTrue(82 == lich.attacke(ziel));
	}

	@Test
	public void LichGegenLich() {
		Wesen lich = new Lich();
		Wesen ziel = new Lich();
		assertTrue(82 == lich.attacke(ziel));
	}

	@Test
	public void LichGegenNachtelf() {
		Wesen lich = new Lich();
		Wesen ziel = new Nachtelf();
		assertTrue(94 == lich.attacke(ziel));
	}

	@Test
	public void LichGegenDaemonenjaeger() {
		Wesen lich = new Lich();
		Wesen ziel = new Daemonenjaeger();
		assertTrue(94 == lich.attacke(ziel));
	}

	// Daemonenjaeger 
	@Test
	public void DaemonenjaegerGegenMensch() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Mensch();
		assertTrue(235 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void DaemonenjaegerGegenErzmagier() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Erzmagier();
		assertTrue(235 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void DaemonenjaegerGegenOrk() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Ork();
		assertTrue(274 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void DaemonenjaegerGegenFarseer() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Farseer();
		assertTrue(548 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void DaemonenjaegerGegenUntote() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Untoter();
		assertTrue(274 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void DaemonenjaegerGegenLich() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Lich();
		assertTrue(274 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void DaemonenjaegerGegenNachtelf() {
		Wesen daemonenjaeger = new Daemonenjaeger();
		Wesen ziel = new Nachtelf();
		assertTrue(313 == daemonenjaeger.attacke(ziel));
	}

	@Test
	public void DaemonenjaegerGegenDaemonenjaeger() {
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

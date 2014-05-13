package imb.SS14.tpegr01.racewars.junit;

import static org.junit.Assert.*;
import imb.SS14.tpegr01.racewars.*;
import imb.SS14.tpegr01.racewars.wesen.*;

import org.junit.Test;

public class JunitTest {

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

}

package imb.SS14.tpegr01.graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTests {

	@Test
	public void graphElements() {
		Node<String> a = new Node<String>("A", "A");
		Node<String> b = new Node<String>("B", "B");
		Node<String> c = new Node<String>("C", "C");
		Node<String> d = new Node<String>("D", "D");
		a.addChild(b);
		a.addChild(c);
		b.addChild(d);
		Graph<String> g = new Graph<String>(a);
		NodeList<String> list1 = new NodeListImpl<String>();
		g.copyInto(list1);
		NodeList<String> list2 = new NodeListImpl<String>();
		list2.add(a);
		list2.add(b);
		list2.add(d);
		list2.add(c);
		assertTrue(list2.equals(list1));
	}

	// Tiefensuche: [A, B, E, H, I, F, J, K, G, C, L, M, N, D, O, P]

	@Test
	public void Tiefensuche() {
		Node<String> a = new Node<String>("A", "A");
		Node<String> b = new Node<String>("B", "B");
		Node<String> c = new Node<String>("C", "C");
		Node<String> d = new Node<String>("D", "D");
		Node<String> e = new Node<String>("E", "E");
		Node<String> f = new Node<String>("F", "F");
		Node<String> g = new Node<String>("G", "G");
		Node<String> h = new Node<String>("H", "H");
		Node<String> i = new Node<String>("I", "I");
		Node<String> j = new Node<String>("J", "J");
		Node<String> k = new Node<String>("K", "K");
		Node<String> l = new Node<String>("L", "L");
		Node<String> m = new Node<String>("M", "M");
		Node<String> n = new Node<String>("N", "N");
		Node<String> o = new Node<String>("O", "O");
		Node<String> p = new Node<String>("P", "P");
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);
		e.addChild(h);
		e.addChild(i);
		f.addChild(j);
		f.addChild(k);
		c.addChild(l);
		c.addChild(m);
		m.addChild(n);
		d.addChild(o);
		d.addChild(p);
		Graph<String> g1 = new Graph<String>(a);
		SearchStrategy<String> s = new DeepSearch<String>();
		g1.search(s, "P");
		NodeList<String> tiefensuche = s.getPath();
		assertTrue(tiefensuche.toString().equals(
				"[A, B, E, H, I, F, J, K, G, C, L, M, N, D, O, P]"));
	}

	// Breitensuche: [A, B, C, D, E, F, G, L, M, O, P, H, I, J, K, N]
	@Test
	public void Breitensuche() {
		Node<String> a = new Node<String>("A", "A");
		Node<String> b = new Node<String>("B", "B");
		Node<String> c = new Node<String>("C", "C");
		Node<String> d = new Node<String>("D", "D");
		Node<String> e = new Node<String>("E", "E");
		Node<String> f = new Node<String>("F", "F");
		Node<String> g = new Node<String>("G", "G");
		Node<String> h = new Node<String>("H", "H");
		Node<String> i = new Node<String>("I", "I");
		Node<String> j = new Node<String>("J", "J");
		Node<String> k = new Node<String>("K", "K");
		Node<String> l = new Node<String>("L", "L");
		Node<String> m = new Node<String>("M", "M");
		Node<String> n = new Node<String>("N", "N");
		Node<String> o = new Node<String>("O", "O");
		Node<String> p = new Node<String>("P", "P");
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);
		e.addChild(h);
		e.addChild(i);
		f.addChild(j);
		f.addChild(k);
		c.addChild(l);
		c.addChild(m);
		m.addChild(n);
		d.addChild(o);
		d.addChild(p);
		Graph<String> g1 = new Graph<String>(a);
		SearchStrategy<String> s = new BreadthFirstSearch<String>();
		g1.search(s, "N");
		NodeList<String> breitensuche = s.getPath();
		assertTrue(breitensuche.toString().equals(
				"[A, B, C, D, E, F, G, L, M, O, P, H, I, J, K, N]"));
	}
	@Test
	public void simulationTiefensuche() {
		Node<String> a = new Node<String>("A", "A");
		Node<String> b = new Node<String>("B", "B");
		Node<String> c = new Node<String>("C", "C");
		Node<String> d = new Node<String>("D", "D");
		Node<String> e = new Node<String>("E", "E");
		Node<String> f = new Node<String>("F", "F");
		Node<String> g = new Node<String>("G", "G");
		Node<String> h = new Node<String>("H", "H");
		Node<String> i = new Node<String>("I", "I");
		Node<String> j = new Node<String>("J", "J");
		Node<String> k = new Node<String>("K", "K");
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(a);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);
		e.addChild(h);
		e.addChild(i);
		f.addChild(j);
		f.addChild(k);
		g.addChild(d);
		h.addChild(b);
		j.addChild(i);
		k.addChild(d);
		SearchStrategy<String> tiefensuche = new DeepSearch<String>();
		Graph<String> g1 = new Graph<String>(a);
		g1.search(tiefensuche, "K");
		assertTrue(tiefensuche.getPath().toString().equals("[A, B, E, H, I, F, J, K, D, G, C]"));;
	}
	@Test
	public void simulationBreitensuche(){
		Node<String> a = new Node<String>("A", "A");
		Node<String> b = new Node<String>("B", "B");
		Node<String> c = new Node<String>("C", "C");
		Node<String> d = new Node<String>("D", "D");
		Node<String> e = new Node<String>("E", "E");
		Node<String> f = new Node<String>("F", "F");
		Node<String> g = new Node<String>("G", "G");
		Node<String> h = new Node<String>("H", "H");
		Node<String> i = new Node<String>("I", "I");
		Node<String> j = new Node<String>("J", "J");
		Node<String> k = new Node<String>("K", "K");
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(a);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);
		e.addChild(h);
		e.addChild(i);
		f.addChild(j);
		f.addChild(k);
		g.addChild(d);
		h.addChild(b);
		j.addChild(i);
		k.addChild(d);
		SearchStrategy<String> breitensuche = new BreadthFirstSearch<String>();
		Graph<String> g1 = new Graph<String>(a);
		g1.search(breitensuche, "K");
		assertTrue(breitensuche.getPath().toString().equals("[A, B, C, D, E, F, G, H, I, J, K]"));
	}
}

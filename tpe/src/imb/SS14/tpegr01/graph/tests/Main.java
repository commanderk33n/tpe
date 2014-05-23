package imb.SS14.tpegr01.graph.tests;

import imb.SS14.tpegr01.graph.Graph;
import imb.SS14.tpegr01.graph.Node;
import imb.SS14.tpegr01.graph.search.BreadthFirstSearch;
import imb.SS14.tpegr01.graph.search.DeepSearch;
import imb.SS14.tpegr01.graph.search.SearchStrategy;

public class Main {

	public static void main(String[] args) {
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
		SearchStrategy<String> tiefensuche = new DeepSearch<String>();
		Graph<String> g1 = new Graph<String>(a);
		g1.search(tiefensuche, "K");
		g1.search(breitensuche, "K");
		System.out.println(tiefensuche.getPath());
		System.out.println(breitensuche.getPath());

		// Test
		Node<Integer> zahl1 = new Node<Integer>("1", 1);
		Node<Integer> zahl2 = new Node<Integer>("2", 2);
		zahl1.addChild(zahl2);
	}
}

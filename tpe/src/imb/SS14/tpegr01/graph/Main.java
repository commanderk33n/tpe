package imb.SS14.tpegr01.graph;

public class Main {

	public static void main(String[] args) {
		Node<String> first = new Node<String>("firstNode", "Hallo?");
		first.addChild(new Node<String>("second", "Stirb!"));
		first.addChild(new Node<String>("third", "Neeeiiiiinnn!"));
		first.addChild(new Node<String>("fourth", "Doch!"));
		Graph<String> graph1 = new Graph<String>(first);
		System.out.println(graph1.getFirst().getChildren().get(1));
		Node<Integer> newNode = new Node<Integer>("zahl1", 7);
		graph1.getFirst().getChildren().get(0).addChild(first);
		graph1.getFirst().getChildren().get(1).addChild(newNode);
		System.out
				.println(graph1.getFirst().getChildren().get(0).getChildren());
		System.out.println(graph1.getFirst().getValue());
		NodeList liste1 = new NodeListImpl();
		graph1.copyInto(liste1);
		System.out.println(graph1);
		System.out.println(liste1);
		System.out.println(graph1.getFirst());
		BreadthFirstSearch<String> breadthFirstSearch = new BreadthFirstSearch<String>();
		System.out
				.println(breadthFirstSearch.search("Doch!", graph1.getFirst()));
		System.out.println("Weg Breitensuche:" + breadthFirstSearch.getPath());
		DeepSearch<String> deepSearch = new DeepSearch<String>();
		System.out
				.println(deepSearch.search("Neeeiiiiinnn!", graph1.getFirst()));
		System.out.println("Weg Tiefensuche:" + deepSearch.getPath());
		System.out.println(deepSearch.search("Stirb!", graph1.getFirst()));
		System.out.println(breadthFirstSearch.search("Hallo?",
				graph1.getFirst()));
		System.out.println(deepSearch.search("Hallo?", graph1.getFirst()));  // BUGGGGYYYYY
		System.out.println("Weg Tiefensuche:" + deepSearch.getPath());
		
	}

}

package imb.SS14.tpegr01.graph;

public class Main {

	public static void main(String[] args) {
		Node<String> firstNode = new Node<String>("firstNode", "Hallo?");
		firstNode.addChild(new Node<String>("secondNode", "Stirb!"));
		firstNode.addChild(new Node<String>("thirdNode", "Neeeiiiiinnn!"));
		firstNode.addChild(new Node<String>("fourthNode", "Doch!"));
		System.out.println(firstNode.getChildren().toString());
		Graph<String> graph1 = new Graph<String>(firstNode);
		System.out.println(firstNode.getValue());
		System.out.println(graph1.getFirst().getValue());

	}

}

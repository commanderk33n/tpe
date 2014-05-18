package imb.SS14.tpegr01.graph;

public abstract class SearchStrategyNode implements SearchStrategy{

	protected VisitedList visited = new VisitedList();
	
	@Override
	public NodeList search(Object value, Graph g) {
		visited.clear();
		NodeList result = new NodeListImpl();
		result = searchNode(g.getFirst(), value);
		return result;
	}

	@Override
	public VisitedList getPath() {
		return visited;
	}

	
	protected abstract NodeList searchNode(Node<?> n, Object value);

}

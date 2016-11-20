package Graph;

public class XGraph
{

	public static void main(String[] args)
	{
		Graph g = new Graph();

		g.addVertex("Днепр");
		g.addVertex("Киев");
		g.addVertex("Полтава");
		g.addVertex("Бабалаевка");

		g.addEdge("Днепр", "Бабалаевка", 1);

	}

}

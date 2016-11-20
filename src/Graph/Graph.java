package Graph;

import java.util.LinkedList;

public class Graph 
{

	
	
	
	class Vertex
	{
		String v;
         
		
		LinkedList<Edge> e = new LinkedList<>();
		
		public Vertex(String v)
		{
			this.v = v;
		}

		@Override
		public String toString()
		{
			return v;
		}

	}

	class Edge
	{
		private String a;
		private String b;
		int distance;

		public Edge(String a, String b)
		{
			this.a = a;
			this.b = b;

		}
	}

	private LinkedList<Vertex> n = new LinkedList<>();
	

	public void addVertex(String val)
	{
		n.add(new Vertex(val));
	}

	public void addEdge(String a, String b, int dist)
	{
		int i = 0;
		for (Vertex vertex : n)
		{
			if (a.equals(vertex.toString()))
			{
				if (!b.equals(vertex.toString()))
				{
					i++;
				}
				else
				{
					System.out.println(i);
				}
			}
		}
	}

	public void print()
	{

	}
}

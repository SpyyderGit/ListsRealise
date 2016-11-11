package nTree;

import java.util.Arrays;

public class NTree
{
	class Node
	{
		private Integer val;
		private int cnt;
		Node n;

		public Node(Integer val)
		{
			this.val = val;
		}
	}

	private Node root = null;
	private int cnt = 0;

	public NTree(int cnt)
	{
		this.cnt = cnt;

		
	}

	class Count
	{
		private int i = 0;
		private int cntNode = 0;
	}

	
	Integer[] arr = new Integer[cnt];
	Node[] pArr = new Node[cnt + 1];
	
	private Count c = new Count();

	private void addNode(Node p, int val)
	{
		if (p == null)
		{
			return;
		}

		System.out.println(pArr[0]);
		c.i++;

	}

	public void add(int val)
	{
		if (root == null)
		{
			root = new Node(val);
		}
		addNode(root, val);
	}

	public void init(int[] ini)
	{
		Arrays.sort(ini);
		for (int i : ini)
		{
			add(i);
		}

	}
}
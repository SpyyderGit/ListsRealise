package nTree;

import java.util.Arrays;

public class NTree
{

	private int size = 0;

	public NTree(int size)
	{
		this.size = size;

	}

	class Node
	{
		Integer[] arr = new Integer[size];
		Node[] pArr = new Node[size + 1];

		public Node(int val)
		{
			arr[0] = val;
		}
	}

	private Node root = null;

	class Count
	{
		private int i = 0;
		private int cntNode = 0;
	}

	private Count c = new Count();

	private void addNode(Node p, int val)
	{
		if (p.arr[size - 1] == null)
		{
			for (int i = 1; i < size; i++)
			{
				if (p.arr[i] == null)
				{
					p.arr[i] = val;
					return;
				}
			}
		}
		else
		{
			if (val > p.arr[size - 1])
			{
				if (p.pArr[size] == null)
				{
					p.pArr[size] = new Node(val);
				}
				else
				{
					addNode(p.pArr[size], val);
				}
			}
			else
			{
				for (int i = 0; i < size; i++)
				{
					if (val < p.arr[i])
					{
						if (p.pArr[i] == null)
						{
							p.pArr[i] = new Node(val);
							System.out.println(p.arr[i]);
						}
						else
						{
							addNode(p.pArr[i], val);
							System.out.println(p.arr[i]);
						}
						return;
					}

				}
			}
		}
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
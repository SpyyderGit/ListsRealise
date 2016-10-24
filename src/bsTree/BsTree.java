package bsTree;

import java.awt.FontFormatException;

public class BsTree
{
	class Node
	{
		int val;
		Node left;
		Node right;

		public Node(int val)
		{
			this.val = val;
		}
	}

	private Node root = null;

	public void clear()
	{
		root = null;
	}

	private void addNode(Node p, int val)
	{
		if (val < p.val)
		{
			if (p.left == null)
			{
				p.left = new Node(val);
			}
			else
			{
				addNode(p.left, val);
			}
		}
		else
		{
			if (p.right == null)
			{
				p.right = new Node(val);
			}
			else
			{
				addNode(p.right, val);
			}
		}
	}

	public void add(int val)
	{
		if (root == null)
		{
			root = new Node(val);
		}
		else
		{
			addNode(root, val);
		}
	}

	public void init(int[] ini)
	{
		for (int i : ini)
		{
			add(i);
		}
	}

	private int c = 0;

	public int sizeNode(Node p)
	{
		if (p == null)
		{
			return 0;
		}
		else
		{
			sizeNode(p.left);
			sizeNode(p.right);
			c++;
		}
		return c;
	}

	public int size()
	{
		return sizeNode(root);
	}

	public int[] toArray()
	{
		int[] ar = new int[size()];

		for (int i = 0; i < ar.length; i++)
		{

		}

		return ar;
	}

}
package bsTree;

import java.util.ArrayList;

public class BsTree implements IBsTree
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

	Node root = null;

	@Override
	public void clear()
	{
		root = null;
	}

	private void add(Node p, int val)
	{
		if (val < p.val)
		{
			if (p.left == null)
			{
				p.left = new Node(val);

			}
			else
			{
				add(p.left, val);
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
				add(p.right, val);
			}
		}
	}

	@Override
	public void add(int val)
	{
		if (root == null)
		{
			root = new Node(val);
			return;
		}
		add(root, val);
	}

	@Override
	public void init(int[] ini)
	{
		for (int i : ini)
		{
			add(i);
		}
	}

	private int size(Node p)
	{
		int a = 0;
		if (p == null)
		{
			return 0;
		}
		else
		{
			a += size(p.left);
			a++;
			a += size(p.right);
		}
		return a;
	}

	@Override
	public int size()
	{
		return size(root);
	}

	private int i = 0;

	private int[] toArray(int[] ar, Node p)
	{
		if (p == null)
		{
			return null;
		}
		toArray(ar, p.left);
		ar[i++] = p.val;
		toArray(ar, p.right);

		return ar;
	}

	@Override
	public int[] toArray()
	{
		int[] ar = new int[size()];
		return toArray(ar, root);
	}

	@Override
	public String toString()
	{
		int[] ar = toArray();
		String str = "";
		for (int i : ar)
		{
			str += i + ", ";
		}

		return "BsTree: [" + str + "]";
	}

	private int nodes(Node p)
	{
		int count = 0;
		if (p == null)
		{
			return 0;
		}

		if (p.left != null && p.right != null)
		{
			count++;
		}
		count += nodes(p.left);
		count += nodes(p.right);

		return count;
	}

	@Override
	public int nodes()
	{

		return nodes(root);
	}

	private int leaves(Node p)
	{
		int count = 0;
		if (p == null)
		{
			return 0;
		}

		if (p.left == null && p.right == null)
		{

			count++;
		}
		else
		{
			count += leaves(p.left);
			count += leaves(p.right);
		}
		return count;
	}

	@Override
	public int leaves()
	{
		return leaves(root);
	}

	private int height(Node p)
	{
		if (p == null)
		{
			return 0;
		}

		int countRight = 0;
		int res = 0;
		int countLeft = 0;

		if (p.right != null)
		{
			countRight++;
		}
		countRight += height(p.right);
		if (p.left != null)
		{
			countLeft++;
		}
		countLeft += height(p.left);

		if (countLeft > countRight)
		{
			res = countLeft;
		}
		else
		{
			res = countRight;
		}
		return res;
	}

	private int res = 0;

	@Override
	public int height()
	{
		return height(root);
	}

	int c = 0;
	int n = 0;

	private int width(Node p)
	{

		int count = 0;
		int size = size();
		String str;

		if (p == null)
		{
			return 0;
		}

		count += width(p.left);
		count++;
		count += width(p.right);

		if (p.right != null)
		{
			System.out.print("c " + count + ", ");
		}

		return count;
	}

	@Override
	public int width()
	{
		return width(root);
	}

	@Override
	public void reverse()
	{
	}

	@Override
	public void delete(int p)
	{
	}
}
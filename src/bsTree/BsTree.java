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

		return str;
	}

	private int nodes(Node p)
	{
		int count = 0;
		if (p == null)
		{
			return 0;
		}

		if (p.left != null || p.right != null)
		{
			count++;
			System.out.print(p.val + ", ");
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
		int countLeft = 0;

		countLeft += height(p.left);
		countLeft++;
		countRight++;
		countRight += height(p.right);

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

	int count = 0;

	@Override
	public int width()
	{
		if (root == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			int i = 0;
			int[] ar = new int[height()];
			widthCounter(root, ar, i);
			return widthMax(ar);
		}
	}

	private void widthCounter(Node p, int[] ar, int i)
	{
		if (p == null)
		{
			return;
		}
		else
		{
			widthCounter(p.left, ar, i + 1);
			ar[i]++;
			widthCounter(p.right, ar, i + 1);
		}
	}

	private int widthMax(int[] ar)
	{
		int max = ar[0];
		for (int i = 0; i < ar.length; i++)
		{
			if (ar[i] > max)
			{
				max = ar[i];
			}
		}
		return max;
	}

	private void reverse(Node p)
	{
		if (p.left != null)
		{
			reverse(p.right);
		}
		if (p.right != null)
		{
			reverse(p.left);
		}
		System.out.print(p.val + ", ");
	}

	@Override
	public void reverse()
	{
		if (root == null)
		{
			return;
		}

		reverse(root);
	}

	private void delete(Node p, int val)
	{

		if (p == null)
		{
			return;
		}
		if (val < p.val)
		{
			if (p.left != null)
			{
				delete(p.left, val);
			}
		}
		else
		{
			if (p.right != null)
			{
				delete(p.right, val);
			}
		}

		if (p.left == root || p.right == root)
		{
			root = null;
		}
		else if (p.left != null && p.left.val == val)
		{
			if (p.left == null)
			{
				p = null;
			}
			else
			{
				p.left = p.left.left;
			}
		}
		else if (p.right != null && p.right.val == val)
		{
			if (p.right == null)
			{
				p = null;
			}
			else
			{
				p.right = p.right.right;
			}
		}
	}

	void deleteTwo(Node p, Node c, int val)
	{
		if (p == null)
		{
			return;
		}
		if (val < p.val)
		{

			if (p.left != null)
			{
				deleteTwo(p.left, c, val);
				if (p.left.val == val)
				{
					System.out.println(p.val);

					// p.left = p.left.right;
					// System.out.println(p.left.left.val);

				}
			}
		}
		else
		{
			if (p.right != null)
			{
				deleteTwo(p.right, c, val);

				if (p.right.val == val && p.right.left != null || p.right.right != null)
				{
					System.out.println(p.right.val);
				}

			}
		}
	}

	@Override
	public void delete(int p)
	{
		if (root == null)
		{
			return;
		}
		deleteTwo(root, root, p);
	}

	private void show(Node p)
	{
		if (p == null)
		{
			return;
		}

		show(p.left);
		if (p.left != null)
		{
			System.out.print(p.val + ": left, ");
		}
		show(p.right);
	}

	public void show()
	{
		show(root);
	}

}
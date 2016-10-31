package bsTree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

public class BsTree implements IBsTree
{

	protected class Node
	{
		int val;
		Node left;
		Node right;

		public Node(int val)
		{
			this.val = val;
		}

	}

	protected Node root = null;

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

	private int res = 0;

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

	@Override
	public int height()
	{
		return height(root);
	}

	// int count = 0;

	@Override
	public int width()
	{
		if (root == null)
		{
			throw new IllegalArgumentException();
		}

		int i = 0;
		int[] ar = new int[height()];
		widthCounter(root, ar, 0);
		return widthMax(ar);

	}

	private void widthCounter(Node p, int[] ar, int i)
	{
		if (p == null)
		{
			return;
		}

		widthCounter(p.left, ar, i + 1);
		ar[i]++;
		widthCounter(p.right, ar, i + 1);

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
		if (root == null)
		{
			return;
		}

		if (p.left != null)
		{
			reverse(p.left);
		}

		if (p.right != null)
		{
			reverse(p.right);
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

	private Node n = null;

	Node findDel(Node p, int val)
	{

		if (p == null)
		{
			return null;
		}
		findDel(p.left, val);

		if (p.right != null)
		{
			if (p.val < val)
			{
				if (p.right.right == null)
				{
					// System.out.print(p.right.val + ", ");
					n = p.right;
				}
			}
		}
		else if (p.left != null)
		{
			if (p.val > val)
			{
				if (p.left.left == null)
				{
					System.out.print(p.left.val + ", ");
				}
			}
		}

		findDel(p.right, val);
		return n;
	}

	void test(int val)
	{
		System.out.println(findDel(root, val));
		// return findDel(root, val);
	}

	void deleteTwo(Node p, Node c, int val)
	{

		if (p == null)
		{
			return;
		}
		c = p.left;

		if (p.left != null)
		{
			if (val == c.val)
			{
				System.out
						.println("Find: " + c.val + " : " + findDel(c, c.val).val + ": " + c.left.val + " : " + p.val);

				Node f = findDel(c, c.val);

				p.right = f;
				f.right = c.right;
				f.left = c.left;
				 c = f;
				System.out.println(f.right.val);

				// c = findDel(c, c.val);
//				System.out.println(p.val);
			}
		}

		deleteTwo(p.left, c, val);
		// System.out.print(p.val + " ");
		deleteTwo(p.right, c, val);

		// System.out.println(p.val + " : " + k);

	}

	@Override
	public void delete(int p)
	{
		if (root == null)
		{
			return;
		}
		// deleteTwo(root, root, p);
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
}
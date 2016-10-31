package Iterators;

import java.util.Iterator;

import interfaces.EList;

public class LList1 implements EList, Iterable<Integer>
{
	class Node
	{
		int val;
		Node next = null;

		public Node(int val)
		{
			this.val = val;
		}

		public int getNode()
		{
			return val;
		}
	}

	Node root = null;

	public void displayList()
	{
		Node l = root;
		while (l != null)
		{
			System.out.print(l.getNode() + " ");
			l = l.next;
		}
	}

	public boolean isEmpty()
	{
		return root == null;
	}

	@Override
	public void init(int[] ini)
	{
		clear();
		if (ini == null || ini.length == 0)
			return;

		for (int i = ini.length - 1; i >= 0; i--)
		{
			addStart(ini[i]);
		}
	}

	@Override
	public int size()
	{
		int ret = 0;
		Node p = root;
		while (p != null)
		{
			ret++;
			p = p.next;
		}
		return ret;
	}

	@Override
	public void clear()
	{
		root = null;
	}

	@Override
	public int[] toArray()
	{
		int[] tmp = new int[size()];
		Node p = root;
		int i = 0;
		while (p != null)
		{
			tmp[i++] = p.val;
			p = p.next;
		}
		return tmp;
	}

	@Override
	public void addStart(int val)
	{
		Node p = new Node(val);
		p.next = root;
		root = p;
	}

	@Override
	public void addEnd(int val)
	{
		Node p = root;

		if (isEmpty())
		{
			addStart(val);
		}
		else
		{
			while (p.next != null)
			{
				p = p.next;
			}
			p.next = new Node(val);
		}
	}

	@Override
	public void addPos(int pos, int val)
	{
		Node p = root;
		Node tmp = new Node(val);
		if (pos == 0)
		{
			addStart(val);
		}
		else
		{
			for (int i = 1; i < pos; i++)
			{
				p = p.next;
			}
			tmp.next = p.next;
			p.next = tmp;
		}
	}

	@Override
	public int delStart()
	{
		if (isEmpty())
			throw new IllegalArgumentException();
		int del = root.val;
		root = root.next;
		return del;
	}

	@Override
	public int delEnd()
	{
		if (isEmpty())
			throw new IllegalArgumentException();

		Node p = root;
		int del = 0;

		if (p.next == null)
		{
			del = p.val;
			p.next = null;
		}
		else
		{

			while (p.next.next != null)
			{
				p = p.next;
			}

			del = p.next.val;
			p.next = null;
		}

		return del;
	}

	@Override
	public int delPos(int pos)
	{
		if (root == null || pos < 0 || pos > size())
		{
			throw new IllegalArgumentException();
		}

		Node p = root;
		int ret = 0;

		if (root.next == null)
		{
			delStart();
			ret = p.val;
		}
		else
		{
			Node tmp = null;
			for (int i = 0; i < pos; i++)
			{
				tmp = p;
				p = p.next;
			}
			ret = p.val;
			tmp.next = p.next;
		}

		return ret;
	}

	@Override
	public int min()
	{
		int ret = 0;
		Node p = root;
		if (p == null)
			throw new IllegalArgumentException();

		for (int i = 1; i <= minInd(); i++)
		{
			p = p.next;
		}
		ret = p.val;
		return ret;
	}

	@Override
	public int max()
	{
		int ret = 0;
		Node p = root;
		if (p == null)
			throw new IllegalArgumentException();

		for (int i = 1; i <= maxInd(); i++)
		{
			p = p.next;
		}
		ret = p.val;
		return ret;
	}

	@Override
	public int minInd()
	{
		Node p = root;
		if (p == null)
			throw new IllegalArgumentException();

		int min = root.val;
		int count = 0;
		int ret = 0;

		while (p != null)
		{
			if (p.val < min)
			{
				ret = count;
				min = p.val;
			}
			count++;
			p = p.next;
		}

		return ret;
	}

	@Override
	public int maxInd()
	{

		Node p = root;
		if (p == null)
			throw new IllegalArgumentException();

		int max = root.val;
		int count = 0;
		int ret = 0;

		while (p.next != null)
		{
			count++;
			if (p.next.val > max)
			{
				ret = count;
				max = p.next.val;
			}

			p = p.next;

		}
		return ret;
	}

	@Override
	public void set(int pos, int val)
	{
		Node p = root;
		if (p == null)
			return;

		for (int i = 0; i < pos; i++)
		{
			p = p.next;
		}
		p.val = val;

	}

	@Override
	public int get(int pos)
	{
		Node p = root;
		if (p == null)
			new Exception();

		int ret = 0;

		for (int i = 0; i < pos; i++)
		{
			p = p.next;
		}
		ret = p.val;
		return ret;
	}

	@Override
	public void reverse()
	{
		Node p = root;
		root = null;

		while (p != null)
		{
			addStart(p.val);
			p = p.next;
		}
	}

	@Override
	public void halfRevers()
	{
		if (size() <= 1)
			return;
		int h = size() / 2;
		int k = size() - h;
		int delta = size() % 2;
		int count = k;

		for (int i = 0; i < k; i++)
		{
			if (count == delta)
			{
				break;
			}
			else
			{
				int tmp = get(i);
				set(i, get(i + k));
				set(i + k, tmp);
			}
			count--;
		}
	}

	@Override
	public void sort()
	{
		for (int i = size() - 1; i >= 1; i--)
		{
			for (int j = 0; j < i; j++)
			{
				if (get(j) > get(j + 1))
				{
					int tmp = get(j);
					set(j, get(j + 1));
					set(j + 1, tmp);
				}
			}
		}
	}

	@Override
	public void addStart(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			addStart(arr[i]);
		}
	}

	@Override
	public void addEnd(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			addEnd(arr[i]);
		}
	}

	@Override
	public void addPos(int pos, int[] arr)
	{
		for (int i = arr.length - 1; i >= 0; i--)
		{
			addPos(pos, arr[i]);
		}
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new LIter(root);
	}

	class LIter implements Iterator<Integer>
	{

		Node p;

		public LIter(Node p)
		{
			this.p = root;
		}

		@Override
		public boolean hasNext()
		{
			return p != null;
		}

		@Override
		public Integer next()
		{
			int val = p.val;
			p = p.next;
			return val;
		}
	}
}
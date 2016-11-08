package bsTree;

import java.util.Iterator;

public class BsTree implements IBsTree, Iterable<Integer>
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

	private void deleteEnd(Node p, int val)
	{

		if (p == null)
		{
			return;
		}
		if (val < p.val)
		{
			if (p.left != null)
			{
				deleteEnd(p.left, val);
			}
		}
		else
		{
			if (p.right != null)
			{
				deleteEnd(p.right, val);
			}
		}

		if (p.left == root || p.right == root)
		{
			root = null;
		}
		else if (p.left != null && p.left.val == val)
		{
			// Лист
			if (p.left == null && p.right == null)
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
			// Лист
			if (p.left == null && p.right == null)
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

	int count = 0;

	// Поиск эелемента, которым будем заменять удаляемый
	Node findDel(Node p, int val)
	{
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
						n = p;
					}
				}
			}
			else if (p.right != null)
			{
				if (p.val > val)
				{
					if (p.left.left == null)
					{
						n = p;
					}
				}
			}

			findDel(p.right, val);
			return n;
		}
	}

	Node test(int val)
	{
		// System.out.println(findDel(root, val));
		return findDel(root, val);
	}

	// Поиск самого большого значения в левой подветке
	Node m = null;

	private Node searchMaxInLeft(Node p, int val)
	{
		if (p == null)
		{
			return null;
		}

		if (p.right != null)
		{
			if (p.val < root.val && p.right.right == null && val < p.right.val)
			{
				m = p;
			}
		}
		searchMaxInLeft(p.right, val);
		searchMaxInLeft(p.left, val);
		return m;
	}

	void deleteTwo(Node p, Node c, int val)
	{

		if (p == null)
		{
			return;
		}

		// deleteEnd(c, val);
		// Удаляем листы и узлы с одним потомком
		// ==============================================================

		// ==============================================================

		// Обработка ситуации с одной вершиной без потомков
		// Вершина левый 1-н потомок
		// Вершина один правый потомок
		// Вершина и только левый и правый потомок
		// ===================================================================

		c = p.left;

		if (val == root.val)
		{
			if (root != null && root.left == null && root.right == null)
			{
				root = null;
			}
			else if (root.left != null && root.right != null)
			{
				Node tmp = root.right;
				root.right = null;
				root = p.left;
				root.right = tmp;
			}

			if (root.left == null && root.right != null)
			{
				root = p.right;
			}
			if (root.left != null && root.right == null)
			{
				root = p.left;
			}
		}

		// Удаление листов и узлов с одним потомком

		// ====================================================================

		// Обработка ситуации с вершиной, потомками и поддеревьями
		// Нужно найти самый большой узел в левой ветке

		// ====================================================================

		deleteTwo(p.left, c, val);

		// Листья

		if (p.left != null && p.left.val == val)
		{
			// Лист
			if (p.left == null && p.right == null)
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
			// Лист
			if (p.left == null && p.right == null)
			{
				p = null;
			}
			else
			{
				p.right = p.right.right;
			}
		}

		Node parent = null;
		Node find = null;
		// Узлы
		if (p.left != null)
		{
			if (val == c.val)
			{
				parent = findDel(c, c.val);
				find = findDel(c, c.val).right;
				find.right = c.right;
				find.left = c.left;
				p.left = find;
				parent.right = null;
				System.out.println(find.val);
			}

		}

		deleteTwo(p.right, c, val);
	}

	@Override
	public void delete(int val)
	{
		if (root == null)
		{
			return;
		}
		deleteTwo(root, root, val);
		// deleteEnd(root, val);
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

	private boolean equalsNode(Node p, Node p1)
	{
		if (p == null || p1 == null)
		{
			return false;
		}

		if (p.val == p1.val)
		{
			return (equalsNode(p.left, p1.left) == equalsNode(p.right, p1.right));
		}
		return false;
	}

	@Override
	public boolean equals(Object obj)
	{
		BsTree t = (BsTree) obj;
		return equalsNode(root, t.root);
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new BSTreeIterator(toArray());
	}

	class BSTreeIterator implements Iterator<Integer>
	{
		int[] arr = null;
		int index = 0;

		public BSTreeIterator(int[] array)
		{
			this.arr = array;
		}

		@Override
		public boolean hasNext()
		{
			return index < arr.length;
		}

		@Override
		public Integer next()
		{
			return arr[index++];
		}
	}
}
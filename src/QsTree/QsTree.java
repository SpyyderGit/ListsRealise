package QsTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class QsTree
{
	class Node
	{
		Node left;
		Node midLeft;
		Node midRight;
		Node right;
		Integer val1;
		Integer val2;
		Integer val3;

		public Node(Integer val1)
		{
			this.val1 = val1;
		}

	}

	private Node root = null;

	private ArrayList<Integer> ar = new ArrayList<>();

	private void nodeProcessing(Node p, Integer val)
	{

		if (p.val2 == null)
		{
			if (val < p.val1)
			{
				p.val2 = p.val1;
				p.val1 = val;
			}
			else if (val > p.val1)
			{
				p.val2 = val;
			}
		}
		else if (p.val3 == null)
		{
			if (val < p.val2 && val > p.val1)
			{
				p.val3 = p.val2;
				p.val2 = val;
			}
			else if (val < p.val2 && val < p.val1)
			{
				p.val3 = p.val2;
				p.val2 = p.val1;
				p.val1 = val;
			}
			else
			{
				p.val3 = val;
			}
		}
	}

	private void addNode(Node p, Integer val)
	{
		// Задаем значения корня

		if (p.left != null)
		{
			addNode(p.left, val);
		}
		if (p.midLeft != null)
		{
			addNode(p.midLeft, val);
		}
		if (p.midRight != null)
		{
			addNode(p.midRight, val);
		}
		if (p.right != null)
		{
			addNode(p.right, val);
		}

		nodeProcessing(p, val);

		// =================================================================

		// System.out.println(p.val1 + " " + p.val2 + " " + p.val3);

		if (val < p.val1)
		{
			p.left = new Node(val);
			if (p.left.val1 != null)
			{
                System.out.println("ddd");
			}

			// nodeProcessing(p.left, val);
		}

	}

	public void add(Integer val)
	{
		// Если пусто в val1 вставляем значение
		if (root == null)
		{
			root = new Node(val);
		}

		addNode(root, val);
	}

	public void init(int[] ini)
	{
		for (int i : ini)
		{
			add(i);

		}
	}

	private String toStringNode(Node p)
	{
		String str = "";
		if (p == null)
		{
			return "";
		}

		toStringNode(p.left);
		str += p.val1 + ", ";

		toStringNode(p.midLeft);

		str += p.val2 + ", ";

		toStringNode(p.midRight);
		str += p.val3 + ", ";

		toStringNode(p.right);

		if (p.left != null)
		{
			if (p.val1 == null || p.val2 == null || p.val3 == null)
			{
				str += "";
			}
			else
			{
				str += p.left.val1 + ", ";
				str += p.left.val2 + ", ";
				str += p.left.val3 + ", ";
			}
		}

		return str;
	}

	@Override
	public String toString()
	{
		if (root == null)
		{
			return "";
		}
		return toStringNode(root);
	}
}

package QsTree;

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

	private void addNode(Node p, Integer val)
	{
		// Задаем значения корня

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

		if (val < p.val1)
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
		if (val > p.val1 && val < p.val2)
		{
			if (p.midLeft == null)
			{
				p.midLeft = new Node(val);
			}
			else
			{
				addNode(p.midLeft, val);
			}
		}

		if (p.val3 != null)
		{
			if (val > p.val2 && val < p.val3)
			{
				if (p.midRight == null)
				{
					p.midRight = new Node(val);
				}
				else
				{
					addNode(p.midRight, val);
				}
			}
			else if (val > p.val3)
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

	}

	public void add(Integer val)
	{
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

	private int sizeNode(Node p)
	{

		int i = 0;

		if (p == null)
		{
			return 0;
		}

		i += sizeNode(p.left);
		if (p.val1 != null)
		{
			i++;
		}
		i += sizeNode(p.midLeft);
		if (p.val2 != null)
		{
			i++;
		}

		i += sizeNode(p.midRight);
		if (p.val3 != null)
		{
			i++;
		}
		i += sizeNode(p.right);

		return i;
	}

	public int size()
	{
		if (root == null)
		{
			return 0;
		}

		return sizeNode(root);
	}

	private String toStringNode(Node p)
	{
		String str = "";
		if (p == null)
		{
			return "";
		}

		if (p.left != null)
		{
			str += toStringNode(p.left);
		}
		// ====================================================
		if (p.val1 == null)
		{
			str += "";
		}
		else
		{
			str += p.val1 + ", ";
		}
		// ======================================================

		if (p.midLeft != null)
		{
			str += toStringNode(p.midLeft);
		}

		// ========================================================

		if (p.val2 == null)
		{
			str += "";
		}
		else
		{
			str += p.val2 + ", ";
		}

		// ===============================================

		if (p.midRight != null)
		{
			str += toStringNode(p.midRight);
		}

		if (p.val3 == null)
		{
			str += "";
		}
		else
		{
			str += p.val3 + ", ";
		}

		if (p.right != null)
		{
			str += toStringNode(p.right);
		}

		// ===============================================

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
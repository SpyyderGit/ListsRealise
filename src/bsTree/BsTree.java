package bsTree;

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

	public void init(int[] ar)
	{
		for (int i : ar)
		{
			add(i);
		}
	}

	private void printNode(Node p)
	{
		if (p == null)
		{
			return;
		}
		else
		{
			printNode(p.left);
			printNode(p.right);
			System.out.print(p.val + ", ");
		}
	}

	public void print()
	{
		printNode(root);
	}

	int c = 0;

	private int sizeNode(Node p)
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

	private int leafsNode(Node p)
	{
		int c = 0;
		if (p == null)
		{
			return 0;
		}

		if (p.left == null && p.right == null)
		{
			c++;
		}
		c += leafsNode(p.left);
		c += leafsNode(p.right);

		return c;
	}

	public int leafs()
	{
		return leafsNode(root);
	}

	private int nodesNode(Node p)
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
		count += nodesNode(p.left);
		count += nodesNode(p.right);

		return count;
	}

	public int nodes()
	{
		return nodesNode(root);
	}
}
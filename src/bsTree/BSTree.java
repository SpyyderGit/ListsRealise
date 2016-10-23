package bsTree;

public class BSTree
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

	void clear()
	{
		root = null;
	}

	void add(int val)
	{
		if (root == null)
		{
			root = new Node(val);
			return;
		}
		addNode(root, val);
	}

	void addNode(Node node, int val)
	{
		if (val < node.val)
		{
			if (node.left == null)
			{
				node.left = new Node(val);
			}
			else
			{
				addNode(node.left, val);
			}
		}
		else
		{
			if (node.right == null)
			{
				node.right = new Node(val);
			}
			else
			{
				addNode(node.right, val);
			}
		}
	}

	void init(int[] ar)
	{
		for (int i : ar)
		{
			add(i);
		}
	}

	void printNode(Node p)
	{
		if (p == null)
		{
			return;
		}
		else
		{
			printNode(p.left);
			System.out.print(p.val + ", ");
			printNode(p.right);
		}
	}

	int size()
	{
		return sizeNode(root);
	}
	
	int a = 0;

	int sizeNode(Node p)
	{
		if (p == null)
		{
			return 0;
		}
		else
		{
			sizeNode(p.left);
			a++;
			sizeNode(p.right);
		}
		return a;
	}

	public void print()
	{
		printNode(root);
	}
}

package TsList;

public class TrTree
{
	protected class Node
	{
		Integer valLeft;
		Integer valRight;
		
		Node left;
		Node middle;
		Node right;

		public Node(int val)
		{
			this.valLeft = val;
		}
	}
	protected Node root = null;

	public void init(int[] ar)
	{
		for (int i: ar)
		{
			add(i);
		}
	}

	public void add(int val) 
	{
		if (root == null) 
		{
			root = new Node(val);
			return;
		}
		addNode(root, val);
	}
	private void addNode(Node p, int val) 
	{
		if(p.valRight == null)
		{
			if(val < p.valLeft)
			{
				p.valRight = p.valLeft;
				p.valLeft = val;
			}
			else
			{
				p.valRight = val;
			}	
		}

		if(val < p.valLeft)
		{
			if(p.left == null)
			{
				p.left = new Node(val);
			}
			else
			{
				addNode(p.left, val);
			}
		}

		if(val > p.valLeft && val < p.valRight)
		{
			if(p.middle == null)
			{
				p.middle = new Node(val);
			}
			else
			{
				addNode(p.middle, val);
			}
		}

		if(val > p.valRight)
		{
			if(p.right == null)
			{
				p.right = new Node(val);
			}
			else
			{
				addNode(p.right, val);
			}
		}
	}

	public int size()
	{
		return sizeNode(root);
	}
	private int sizeNode(Node p)
	{
		int ret = 0;
		
		if(p == null)
		{
			return 0;
		}
		else 
		{
			if(p.valRight != null)
			{
				ret += 2;
			}
			else
			{
				ret += 1;
			}
			ret += sizeNode(p.left);
			ret += sizeNode(p.middle);
			ret += sizeNode(p.right);
		}
		return ret;
	}

	public String toString()
	{
		return nodeToString(root);
	}
	private String nodeToString(Node p)
	{
		String str = "";
		
		if (p == null)
		{
			return "";
		}

		str += nodeToString(p.left);
		
		if(p.valLeft != null)
		{
			str += p.valLeft + ", ";
		}

		str += nodeToString(p.middle);
		
		if(p.valRight != null)
		{
			str += p.valRight + ", ";	
		}
		
		str += nodeToString(p.right);

		return str;
	}
}

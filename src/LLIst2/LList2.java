package LLIst2;


import interfaces.EList;

public class LList2 implements EList
{

	class Node
	{
		int val;
		Node next = null;
		Node prev = null;

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
	Node end = null;

	public void displayList()
	{
		Node l = root;
		while (l != null)
		{
			System.out.print(l.getNode() + " ");
			l = l.next;
		}
		end = l.next;
	}

	@Override
	public void clear()
	{
		root = null;
		end = null;
	}

	@Override
	public void init(int[] ini)
	{
		if (ini == null || ini.length == 0)
			return;

		for (int i = 0; i <= ini.length - 1; i++)
		{
			addStart(ini[i]);
		}
	}

	@Override
	public int size()
	{
		if (root == null)
			throw new IllegalArgumentException();

		int count = 0;
		Node p = end;

		while (p != null)
		{
			p = p.prev;
			count++;
		}
		return count;
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
		if (root == null)
		{
			root = p;
			end = p;
		}
		else
		{
			root.prev = root;
			p.next = root;
			root = p;
		}
	}

	@Override
	public void addEnd(int val)
	{
		Node tmp = new Node(val);
		if (root == null)
		{
			root = tmp;
			end = tmp;
		}
		else
		{
			tmp.prev = end;
			end.next = tmp;
		}
	}

	@Override
	public void addPos(int pos, int val)
	{
		Node tmp = new Node(val);
		Node p = root;

		if (root == null)
		{
			addStart(val);
		}
		else
		{
			for (int i = 1; i < pos; i++)
			{
				p = p.next;
			}
			tmp.prev = p;
			tmp.next = p.next;
			p.next = tmp;
		}
	}

	@Override
	public void addStart(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			addEnd(arr[i]);
		}
	}

	@Override
	public void addEnd(int[] arr)
	{
		Node p = root;

		while (p.next != null)
		{
			p = p.next;
		}
		addEnd(arr);
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
	public int delStart()
	{
		if (root == null)
			throw new IllegalArgumentException();

		int ret = root.val;
		if (root.next == null)
		{
			root = null;
		}
		else
		{
			root.next.prev = null;
			root = root.next;
		}
		return ret;
	}

	@Override
	public int delEnd()
	{
		if (root == null)
			throw new IllegalArgumentException();

		int ret = end.val;

		if (root == null)
		{
			root = null;
		}
		else
		{
			end = end.prev;
			end.next = null;
		}
		return ret;
	}

	@Override
	public int delPos(int pos)
	{

		Node p = root;
		int ret = 0;

		if (root == null || pos < 0 || pos > size())
		{
			throw new IllegalArgumentException();
		}
		else if (root.next == null)
		{
			ret = root.val;
			delStart();
		}
		else
		{
			for (int i = 1; i < pos; i++)
			{
				p = p.next;
			}

			p.next.next.prev = p;
			p.next.next = p;
			ret = p.next.val;
		}
		return ret;
	}

	@Override
	public int min()
	{
		int ret = 0;
		Node p = root;
		int min = minInd();
		if (p == null)
			throw new IllegalArgumentException();

		for (int i = 1; i <= min; i++)
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
	public int get(int val)
	{
		Node p = root;
		if (p == null)
			new Exception();

		int ret = 0;

		for (int i = 0; i < val; i++)
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

}
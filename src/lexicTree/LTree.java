package lexicTree;

import java.util.ArrayList;

public class LTree
{

	class Data
	{
	}

	class Node
	{
		Node[] ar = new Node[26];
		Data info = null;
	}

	private Node root = new Node();
	private ArrayList<String> al = new ArrayList<>();

	public void clear()
	{
		root = new Node();
	}

	public void add(String str)
	{
		str = str.toLowerCase();
		addNode(root, str, 0);
	}

	class Count
	{
		int i = 0;
	}

	Count c = new Count();

	private void addNode(Node p, String str, int i)
	{
		if (i == str.length())
		{
			p.info = new Data();
			c.i++;
			return;
		}

		int ii = str.charAt(i) - 'a';
		if (p.ar[ii] == null)
			p.ar[ii] = new Node();

		addNode(p.ar[ii], str, ++i);
	}

	public ArrayList<String> toList()
	{
		return toListNode(root, "");
	}

	private ArrayList<String> toListNode(Node p, String str)
	{
		if (p.info != null)
		{
			al.add(str);
		}

		for (char i = 0; i < 26; i++)
		{
			if (p.ar[i] != null)
			{
				char ch = (char) (i + 'a');
				toListNode(p.ar[i], str + ch);
			}
		}
		return al;
	}

	public void toList(String mask)
	{
		for (String i : al)
		{
			if (i.substring(0, mask.length()).equals(mask))
			{
				System.out.println(i);
			}
		}
	}

	public void del(String str)
	{
		for (String i : al)
		{
			if (str.equals(i))
			{
				al.remove(i);
				break;
			}
		}
	}

	public int size()
	{
		return c.i;
	}

}
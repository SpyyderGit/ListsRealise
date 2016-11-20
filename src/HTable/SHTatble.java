package HTable;

import java.util.ArrayList;
import java.util.LinkedList;

public class SHTatble
{
	final int SIZE = 190;
	private ArrayList<Person>[] pp = new ArrayList[SIZE];

	public void add(Person p)
	{
		int i = p.hashCode() % SIZE;

		while (i < SIZE && pp[i] != null)
		{
			i++;
		}
		if (pp[i] == null)
		{
			pp[i] = new ArrayList<Person>();
			pp[i].add(p);
		}
		else
		{
			pp[i].add(p);
		}
	}

	public int size()
	{
		int ret = 0;

		for (Person p : pp[SIZE])
		{
			ret++;
		}

		return ret;
	}

	public Person get(int code)
	{
		Person p = null;

		int i = code % SIZE;
		for (Person rp : pp[i])
		{
			if (rp.hashCode() == code)
			{
				p = rp;
			}
		}

		return p;
	}

}

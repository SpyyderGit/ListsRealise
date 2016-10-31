package Iterators;

import java.util.Arrays;
import java.util.Iterator;

import interfaces.EList;

public class AList0 implements EList, Iterable<Integer>
{
	private int arr[] = {};

	public void clear()
	{
		arr = new int[0];
	}

	public void init(int[] ini)
	{
		clear();
		if (ini == null || ini.length == 0)
			return;

		arr = new int[ini.length];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = ini[i];
		}
	}

	public int size()
	{
		return arr.length;
	}

	public int[] toArray()
	{
		int[] tmp = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			tmp[i] = arr[i];
		}
		return tmp;
	}

	@Override
	public void addStart(int val)
	{
		int[] tmp = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++)
		{
			tmp[i + 1] = arr[i];

		}
		tmp[tmp.length - tmp.length] = val;
		arr = tmp;
	}

	@Override
	public void addEnd(int val)
	{

		int[] tmp = new int[arr.length + 1];

		for (int i = 0; i < arr.length; i++)
		{
			tmp[i] = arr[i];
		}
		tmp[tmp.length - 1] = val;
		arr = tmp;
	}

	@Override
	public void addPos(int pos, int val)
	{
		int[] tmp = new int[arr.length + 1];
		for (int i = 0; i < pos; i++)
		{
			tmp[i] = arr[i];
		}
		tmp[pos] = val;
		for (int i = pos + 1; i < tmp.length; i++)
		{
			tmp[i] = arr[i - 1];
		}
		arr = tmp;
	}

	@Override
	public void addStart(int[] ini)
	{
		for (int i = 0; i < ini.length; i++)
		{
			addStart(ini[i]);
		}
	}

	@Override
	public void addEnd(int[] ini)
	{
		for (int i = 0; i < ini.length; i++)
		{
			addEnd(ini[i]);
		}

	}

	public void addPos(int pos, int[] ini)
	{
		for (int i = 0; i < ini.length; i++)
		{
			addPos(pos + i, ini[i]);
		}
	}

	public int delStart()
	{
		if (arr.length == 0)
			throw new IllegalArgumentException();

		int[] tmp = new int[arr.length - 1];
		int ret = arr[0];

		for (int i = 1; i < tmp.length; i++)
		{
			tmp[i - 1] = arr[i];
		}
		arr = tmp;

		return ret;
	}

	public int delEnd()
	{
		if (arr.length == 0)
			throw new IllegalArgumentException();

		int[] tmp = new int[arr.length - 1];
		int ret = arr[arr.length - 1];

		for (int i = 0; i < arr.length - 1; i++)
		{
			tmp[i] = arr[i];
		}
		arr = tmp;
		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		if (arr.length == 0)
			throw new IllegalArgumentException();

		int[] tmp = new int[arr.length - 1];
		int ret = arr[pos];

		for (int i = 0; i < pos; i++)
		{
			tmp[i] = arr[i];

		}

		for (int i = pos + 1; i < arr.length; i++)
		{
			tmp[i - 1] = arr[i];
		}
		arr = tmp;
		return ret;
	}

	@Override
	public int min()
	{
		if (arr.length == 0)
			throw new IllegalArgumentException();
		return arr[minInd()];
	}

	@Override
	public int max()
	{
		if (arr.length == 0)
			throw new IllegalArgumentException();

		return arr[maxInd()];
	}

	@Override
	public int minInd()
	{
		if (arr.length == 0)
			throw new IllegalArgumentException();

		int ind = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[ind] > arr[i])
			{
				ind = i;
			}
		}
		return ind;
	}

	@Override
	public int maxInd()
	{
		if (arr.length == 0)
			throw new IllegalArgumentException();

		int ind = 0;
		for (int i = 0; i < arr.length; i++)
		{

			if (arr[ind] < arr[i])
			{
				ind = i;
			}
		}
		return ind;
	}

	@Override
	public void set(int pos, int val)
	{
		if (arr.length == 0)
			return;

		arr[pos] = val;
	}

	@Override
	public int get(int getElem)
	{
		if (arr.length == 0)
			throw new IllegalArgumentException();

		int res = arr[getElem];
		return res;
	}

	@Override
	public void reverse()
	{
		if (arr.length == 0)
			return;

		int len = arr.length - 1;
		int tmp = 0;

		for (int j = 0; j < arr.length; j++)
		{
			for (int i = 0; i < len - j; i++)
			{
				tmp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = tmp;
			}
		}
	}

	@Override
	public void halfRevers()
	{
		if (arr.length == 0)
			return;

		int tmp = 0;
		int divArr = arr.length / 2;

		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr.length - 1; j++)
			{
				if (i <= divArr && divArr < arr.length)
				{
					tmp = arr[j];
					arr[j] = arr[divArr];
					arr[divArr] = tmp;
					divArr++;
				}
			}
		}
	}

	@Override
	public void sort()
	{
		if (arr.length == 0)
			return;

		int tmp = 0;

		for (int j = 0; j < arr.length; j++)
		{
			for (int i = 0; i < arr.length - 1; i++)
			{
				if (arr[i] > arr[i + 1])
				{
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}
	}

	@Override
	public String toString()
	{
		return "AList0 " + Arrays.toString(arr);
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new AIter();
	}

	class AIter implements Iterator<Integer>
	{
		int i = 0;

		@Override
		public boolean hasNext()
		{
			return i < arr.length;
		}

		@Override
		public Integer next()
		{
			return arr[i++];
		}

	}

}

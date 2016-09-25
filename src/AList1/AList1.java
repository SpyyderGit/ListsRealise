package AList1;

import java.util.Arrays;

import interfaces.EList;

public class AList1 implements EList
{
	private int arr[] = new int[10];
	private int index = 0;

	public void clear()
	{
		index = 0;
	}

	@Override
	public void init(int[] ini)
	{
		clear();
		if (ini.length == 0 || ini.length == 0)
			return;

		
			if (ini.length >= arr.length)
			{
				arr = new int[arr.length + (ini.length + ini.length) / 3];
			}
		
		
		for (int i = 0; i < ini.length; i++)
		{

			arr[i] = ini[i];

		}
		index = ini.length;
	}

	public int size()
	{
		return index;
	}

	@Override
	public int[] toArray()
	{
		int[] tmp = new int[index];
		for (int i = 0; i < index; i++)
		{
			tmp[i] = arr[i];
		}
		return tmp;
	}

	private void resize()
	{
		if (index < arr.length)
			return;

		int[] tmp = new int[arr.length + arr.length / 3];

		for (int i = 0; i < arr.length; i++)
		{
			tmp[i] = arr[i];
		}
		arr = tmp;

	}

	@Override
	public void addStart(int val)
	{
		index++;
		for (int i = index; i > 0; i--)
		{
			resize();
			arr[i] = arr[i - 1];
		}
		arr[0] = val;
	}

	@Override
	public void addEnd(int val)
	{
		resize();
		arr[index++] = val;
	}

	@Override
	public void addPos(int pos, int val)
	{

		for (int i = index; i >= pos; i--)
		{
			resize();
			if (i == pos)
			{
				arr[i] = val;
			}
			else
			{
				arr[i] = arr[i - 1];
			}
		}
		index++;
	}

	
	@Override
	public void addStart(int[] ini)
	{
		for (int i = 0; i < ini.length; i++)
		{
			resize();
			addStart(ini[i]);
		}
	}

	@Override
	public void addEnd(int[] ini)
	{
		for (int i = 0; i < ini.length; i++)
		{
			resize();
			addEnd(ini[i]);
		}
	}

	@Override
	public void addPos(int pos, int[] ini)
	{
		for (int i = 0; i < ini.length; i++)
		{
			resize();
			addPos(i + pos, ini[i]);
		}
	}
	
	
	
	@Override
	public int delStart()
	{
		if (index == 0)
			throw new IllegalArgumentException();

		int ret = arr[0];
		for (int i = 1; i < index; i++)
		{
			arr[i - 1] = arr[i];
		}
		return ret;
	}

	@Override
	public int delEnd()
	{
		if (index == 0)
			throw new IllegalArgumentException();

		int ret = arr[index - 1];
		arr[--index] = 0;

		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		if (pos > index || index == 0)
			throw new IllegalArgumentException();

		int ret = arr[pos];
		for (int i = pos; i < index; i++)
		{
			arr[i] = arr[i + 1];
		}
		return ret;
	}

	@Override
	public int min()
	{
		if (index == 0)
			throw new IllegalArgumentException();

		return arr[minInd()];
	}

	@Override
	public int max()
	{
		if (index == 0)
			throw new IllegalArgumentException();

		return arr[maxInd()];
	}

	@Override
	public int minInd()
	{
		if (index == 0)
			throw new IllegalArgumentException();

		int ind = 0;
		for (int i = 0; i < index; i++)
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
		if (index == 0)
			throw new IllegalArgumentException();
		int ind = 0;
		for (int i = 1; i < index; i++)
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
		if (index == 0 || arr.length < index)
			return;
		arr[pos] = val;
	}

	@Override
	public int get(int val)
	{
		if (index == 0)
			throw new IllegalArgumentException();
		return arr[val];
	}

	@Override
	public void reverse()
	{
		if (index == 0)
			return;

		for (int i = 0; i < index; i++)
		{
			for (int j = 0; j < index - 1 - i; j++)
			{
				int tmp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = tmp;
			}
		}
	}

	@Override
	public void halfRevers()
	{
		if (index == 0)
			return;

		int divArr = index / 2;

		for (int i = 0; i < index; i++)
		{
			for (int j = 0; j < index - 1; j++)
			{
				if (i <= divArr && divArr < index)
				{
					int tmp = arr[j];
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
		if (index == 0)
			return;

		for (int j = 0; j < index; j++)
		{
			for (int i = 0; i < index - 1; i++)
			{
				if (arr[i] > arr[i + 1])
				{
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}
	}

	@Override
	public String toString()
	{
		return "AList1 " + Arrays.toString(arr);
	}

	
}

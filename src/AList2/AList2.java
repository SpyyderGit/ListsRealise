package AList2;

import interfaces.EList;

import java.util.Arrays;

public class AList2 implements EList
{
	private int[] arr = new int[30];
	private int start = arr.length / 2;
	private int end = start;

	@Override
	public void clear()
	{
		start = end = arr.length / 2;
	}

	@Override
	public void init(int[] ini)
	{
		clear();

		if (ini == null || ini.length == 0)
			return;

		resize(ini);

		for (int i = 0; i < ini.length; i++)
		{
			balance();
			arr[i + start] = ini[i];
			end++;
		}
	}

	@Override
	public int size()
	{
		return end - start;
	}

	// Балансируем массив
	private void balance()
	{
		if (end > arr.length - 3)
		{
			for (int i = start; i < arr.length; i++)
			{
				arr[i - start / 2 - 1] = arr[i];
				arr[i] = 0;
			}
			int size = size();

			start /= 2;
			end = start + size;
		}
		else if (start <= 1)
		{
			int count = 0;

			for (int i = end; i > 0; i--)
			{
				arr[(end - count) + ((arr.length - end) / 2)] = arr[i];
				count++;
				arr[i] = 0;
			}

			int size = size();
			end += (arr.length - end) / 2;
			start = end - size;
		}
	}

	// При достижении границ либо баллансируем на середину, либо расширяем
	// массив
	private void resize()
	{
		if (size() >= arr.length - 3)
		{
			balance();
			int[] tmp = new int[arr.length + arr.length / 3];
			for (int i = 0; i < arr.length; i++)
			{
				tmp[i] = arr[i];
			}
			arr = tmp;
		}
	}

	private void resize(int[] tmp)
	{
		if (tmp.length >= arr.length - 3)
		{
			balance();
			arr = new int[arr.length + (tmp.length + tmp.length / 3)];
		}
	}

	@Override
	public int[] toArray()
	{
		int[] tmp = new int[size()];
		for (int i = 0; i < size(); i++)
		{
			tmp[i] = arr[i + start];
		}

		return tmp;
	}

	@Override
	public void addStart(int val)
	{
		for (int i = 0; i < arr.length; i++)
			resize();
		arr[--start] = val;
	}

	@Override
	public void addEnd(int val)
	{

		resize();
		arr[end++] = val;
	}

	@Override
	public void addPos(int pos, int val)
	{
		resize();
		for (int i = end; i >= start + pos; i--)
		{
			arr[i] = arr[i - 1];
		}
		arr[start + pos] = val;
		end++;
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

	@Override
	public void addPos(int pos, int[] ini)
	{
		for (int i = 0; i < ini.length; i++)
		{
			addPos(pos + i, ini[i]);
		}

	}

	@Override
	public int delStart()
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		int ret = arr[start++];
		arr[start++] = 0;
		return ret;
	}

	@Override
	public int delEnd()
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		int ret = arr[--end];
		arr[--end] = 0;
		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		int ret = arr[pos + start];

		for (int i = pos + start; i < end; i++)
		{
			arr[i] = arr[i + 1];
		}
		end--;
		return ret;
	}

	@Override
	public int min()
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		return arr[minInd() + start];
	}

	@Override
	public int max()
	{
		if (size() == 0)
			throw new IllegalArgumentException();
		return arr[maxInd() + start];
	}

	@Override
	public int minInd()
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		int ind = start;
		for (int i = start; i < end; i++)
		{
			if (arr[ind] > arr[i])
			{
				ind = i;
			}
		}
		return ind - start;
	}

	@Override
	public int maxInd()
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		int ind = start;
		for (int i = start; i < end; i++)
		{
			if (arr[ind] < arr[i])
			{
				ind = i;
			}
		}
		return ind - start;
	}

	@Override
	public void set(int pos, int val)
	{
		if (size() == 0)
			return;

		arr[pos + start] = val;
	}

	@Override
	public int get(int pos)
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		return arr[pos + start];
	}

	@Override
	public void reverse()
	{
		if (start == 0)
			return;

		for (int i = start; i < end - (size() / 2); i++)
		{
			int tmp = arr[i];
			arr[i] = arr[end - (i - start) - 1];
			arr[end - (i - start) - 1] = tmp;
		}

	}

	@Override
	public void halfRevers()
	{
		if (size() <= 1)
			return;
		int h = size() / 2;
		int k = size() - h;

		for (int i = start; i < end - h; i++)
		{
			int tmp = arr[i];
			arr[i] = arr[i + k];
			arr[i + k] = tmp;
		}
	}

	@Override
	public void sort()
	{
		if (size() == 0)
			return;

		for (int i = size() - 1; i >= 1; i--)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr[start + j] > arr[start + j + 1])
				{
					int tmp = arr[start + j];
					arr[start + j] = arr[start + j + 1];
					arr[start + j + 1] = tmp;
				}
			}
		}
	}

	@Override
	public String toString()
	{
		return "AList2 " + Arrays.toString(arr);
	}
}

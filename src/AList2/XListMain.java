package AList2;

import java.util.Iterator;

import interfaces.EList;

public class XListMain
{
	public static void main(String[] args)
	{
		AList2 lst = new AList2();
		int[] arr = { 10, 211, 2, 333, 21, 10, 211, 2 };

		lst.init(arr);

		int[] tmp = new int[arr.length];

		// a.balanceEnd();

		// a.balance();

		// a.addPos(9,6);

		// a.halfRevers();

		// for (int i = 0; i < arr.length / 2; i++)
		// {
		// int tmp = arr[i];
		// arr[i] = arr[i + (arr.length / 2)];
		// arr[i + (arr.length / 2)] = tmp;
		// }
		//
		// for (int i = 1; i < 130; i++)
		// {
		//
		// a.addStart(i);
		// }

		// a.addStart(tmp);

		// a.addEnd(tmp);

		int i1 = 0;
		System.out.println();
		for (int m : lst)
		{
			tmp[i1] = m;
		}

		int size = lst.size();
		for (int i = 0; i < size; i++)
		{
			System.out.print(tmp[i] + ", ");

		}

		System.out.println();

		Iterator<Integer> itr = lst.iterator();
		int t = itr.next();
		int n = 0;
		while (itr.hasNext())
		{

			// System.out.println(i);
			if (t != 0)
			
				System.out.print(itr.next() + ", ");
			
		}

	}

}

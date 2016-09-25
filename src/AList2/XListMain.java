package AList2;

import interfaces.EList;

public class XListMain
{
	public static void main(String[] args)
	{
		AList2 a = new AList2();
		int[] arr = { 10, 211, 2, 333, 21, 10, 211, 2, 333, 21, 10, 211, 2, 333, 21, 10, 211, 2, 333, 21, 10, 211, 2,
				333, 21, 10, 211, 2, 333, 21 };

		a.init(arr);

		int[] tmp = { 1 };

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

		System.out.println(a);
	}

}

package LList1;

import interfaces.EList;

public class LlistX
{
	public static void main(String[] args)
	{
		LList1 lst = new LList1();
		int[] tmp = { 10, -211, -2, -333, -21, -30};

		lst.init(tmp);

		

    	System.out.println(lst.max());
		lst.displayList();

	}
}

package AList0;

import AList1.AList1;
import interfaces.EList;

public class XList0
{

	public static void main(String[] args)
	{
		EList lst = new AList1();
		int[] ini = { 10, 211, -2, 333, -21, -30 };
		lst.init(ini);

		int[] tmp = { 1, 1, 1, 10 };

		System.out.println(lst.maxInd());
	
		// lst.addPos(0, 1);
	}
}

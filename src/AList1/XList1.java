package AList1;

public class XList1
{

	public static void main(String[] args)
	{
		AList1 lst = new AList1();
		int[] ini = { 4, 5, 6, 3 };
		lst.init(ini);
		lst.addStart(3);
		System.out.println(lst);

	}

}

package LList1;

public class XList
{
	public static void main(String[] args)
	{
		LList1 l = new LList1();
		int[] ini = { 3, 1, 5, 6, 3 };

	     l.init(ini);
		l.sort();

		l.displayList();
	}
}

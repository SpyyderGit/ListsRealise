package LLIst2;

public class XLList2
{

	public static void main(String[] args)
	{
		LList2 lst = new LList2();

		int[] tmp = { 2, 3, 45, 2, 4, 5 };

		lst.init(tmp);

		lst.addEnd(9);
		lst.addStart(19);
		lst.addPos(1,tmp);
		lst.delStart();
        lst.displayList();
		
	}

}

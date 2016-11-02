package QsTree;

public class QMain
{
	public static void main(String[] args)
	{
		QsTree t = new QsTree();
		int[] ar = { 50, 25, 45 };
		t.init(ar);
		 t.add(4);
 t.add(6);
		System.out.println(t.toString());
	}
}

package QsTree;

public class QMain
{

	public static void main(String[] args)
	{
		QsTree t = new QsTree();
		int[] ar = { 50, 25, 45, 47, 185, 48, 46, 1, -30, -60 };
		t.init(ar);
        t.add(10); 
		System.out.println(t.size());
		System.out.println(t.toString());
	}
}

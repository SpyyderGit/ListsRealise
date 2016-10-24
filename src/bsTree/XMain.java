package bsTree;

public class XMain
{

	public static void main(String[] args)
	{
		BsTree t = new BsTree();
		int[] ar = { 5, 10, 8, 9, 3, 4, 2 };
		t.init(ar);
		t.add(7);
		t.print();

		System.out.println("\n" + t.leafs());
	}
}

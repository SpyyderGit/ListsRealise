package bsTree;

public class XMain
{

	public static void main(String[] args)
	{
		BsTree t = new BsTree();
		int[] ar = { 5, 10, 8, 9, 3, 2, 4, 15, 7 };
		t.init(ar);
		// t.add(7);
		// t.reverse();
		t.delete(15);
		System.out.println(t.toString());
		// System.out.println("\n" + t.leafs());
		//
		// t.toString();
	}
}
